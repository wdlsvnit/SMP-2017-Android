#include<stdlib.h>
#include<stdio.h>
#include<cs50.h>

#include "bmp.h"

int main(int argc, char *argv[])
{
    //factor resize
    int factor = atoi(argv[1]);
    
    
    // ensure proper usage
    if (argc != 4 || (factor>100 || factor<=0))
    {
        fprintf(stderr, "Usage: ./copy factor infile outfile\n");
        return 1;
    }
    
    
    // remember filenames
    char *infile = argv[2];
    char *outfile = argv[3];

    // open input file 
    FILE *inptr = fopen(infile, "r");
    if (inptr == NULL)
    {
        fprintf(stderr, "Could not open %s.\n", infile);
        return 2;
    }

    // open output file
    FILE *outptr = fopen(outfile, "w");
    if (outptr == NULL)
    {
        fclose(inptr);
        fprintf(stderr, "Could not create %s.\n", outfile);
        return 3;
    }

    // read infile's BITMAPFILEHEADER
    BITMAPFILEHEADER bf;
    fread(&bf, sizeof(BITMAPFILEHEADER), 1, inptr);

    // read infile's BITMAPINFOHEADER
    BITMAPINFOHEADER bi,oldbi;
    fread(&bi, sizeof(BITMAPINFOHEADER), 1, inptr);

    // ensure infile is (likely) a 24-bit uncompressed BMP 4.0
    if (bf.bfType != 0x4d42 || bf.bfOffBits != 54 || bi.biSize != 40 || 
        bi.biBitCount != 24 || bi.biCompression != 0)
    {
        fclose(outptr);
        fclose(inptr);
        fprintf(stderr, "Unsupported file format.\n");
        return 4;
    }
    
    // determine padding for scanlines
    int oldpadding = (4 - ((bi.biWidth) * sizeof(RGBTRIPLE)) % 4) % 4;
      
    oldbi.biWidth = bi.biWidth;
    oldbi.biHeight = bi.biHeight;
    
       bi.biWidth *= factor;
       bi.biHeight *= factor;
    
      int newpadding =  (4 - ((bi.biWidth) * sizeof(RGBTRIPLE)) % 4) % 4;
  
       bi.biSizeImage = ((sizeof(RGBTRIPLE)*bi.biWidth)+newpadding) * abs(bi.biHeight);
       bf.bfSize = bi.biSizeImage + sizeof(BITMAPFILEHEADER)+sizeof(BITMAPINFOHEADER);
       
    
    
    // write outfile's BITMAPFILEHEADER
    fwrite(&bf, sizeof(BITMAPFILEHEADER), 1, outptr);

    // write outfile's BITMAPINFOHEADER
    fwrite(&bi, sizeof(BITMAPINFOHEADER), 1, outptr);

    // iterate over infile's scanlines
    for (int i = 0, biHeight = abs(oldbi.biHeight); i < biHeight;i++ )
    {
        // iterate over pixels in scanline
        for(int m=0; m<factor;m++)
        {
        for (int j = 0; j <oldbi.biWidth; j++)
        {
              
          // temporary storage
            RGBTRIPLE triple;

            // read RGB triple from infile
            fread(&triple, sizeof(RGBTRIPLE), 1, inptr);

            for(int k =0;k< factor;k++)
               // write RGB triple to outfile
              fwrite(&triple, sizeof(RGBTRIPLE), 1, outptr);
        
        }
        // then add it back (to demonstrate how)
            for (int l = 0; l < newpadding; l++)
               fputc(0x00, outptr);
           if(m<factor-1)      
           fseek(inptr, - oldbi.biWidth * sizeof(RGBTRIPLE), SEEK_CUR);        
        }
        fseek(inptr, oldpadding, SEEK_CUR);
    }
    // close infile
    fclose(inptr);

    // close outfile
    fclose(outptr);

    // success
    return 0;
}
