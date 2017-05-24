#include<stdio.h>
#include<stdlib.h>
#include<stdint.h>


int main(int argc , char* argv[])
{
   if(argc != 2)   
    {
        fprintf(stderr,"Usage: ./recover image");
        return 1;
    }
    
    char *infile = argv[1];
    
    //opening file
    FILE *inptr = fopen(infile,"r");
    FILE *outptr =NULL;
    
    if(inptr == NULL)
    {
        fprintf(stderr,"Could not open file \n");
        return 2;
    }

    int photosfound= 0;
    int pics=0;
    unsigned char buffer[512] = {0};
    char file[8];                 
    
    
    while(fread(&buffer,sizeof(buffer),1,inptr) )    
       { 
           if(buffer[0]== 0xff && buffer[1]==0xd8 && buffer[2]==0xff && (buffer[3] & 0xf0)==0xe0)
           {
                     if(photosfound==1)
                     fclose(outptr);
               
                      else
                      photosfound=1;
                     
                  
                 sprintf(file,"%03d.jpg",pics);
                  outptr = fopen(file,"w") ;
                 pics++;
           }
     
          if(photosfound==1)
         fwrite(&buffer,sizeof(buffer),1,outptr);
          
           
       }        
    fclose(inptr);
    fclose(outptr);
    
return 0;

}
    

