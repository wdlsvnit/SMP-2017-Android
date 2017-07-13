
       
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>


typedef uint8_t BYTE;



int main(int argc, char *argv[])
{

    if (argc != 2)
    {
        fprintf(stderr, "Usage: ./copy infile \n");
        return 1;
    }


    char *infile = argv[1];
    

    
    FILE *file = fopen(argv[1], "r");
    if (file == NULL)
    {
        fprintf(stderr, "Could not open %s.\n", infile);
        return 2;
    }

    int c=0;
    
    BYTE buffer[512];
    
    char lname[10]; 
    
    FILE* temp = NULL; 
    
    while (!feof(file))
    {
         
         
         fread(buffer, sizeof(buffer), 1, file);
         
        if (buffer[0] == 0xff && buffer[1] == 0xd8 && buffer[2] == 0xff && (buffer[3] == 0xe0 || buffer[3] == 0xe1))
        {
            
            if (temp != NULL)
            {
                fclose(temp);
                
            }
            
            
            sprintf(lname, "%03d.jpg", c);
            
            
            temp = fopen(lname, "w");
            
            
            c++;
            
            
            fwrite(buffer, sizeof(buffer), 1, temp);
        }
        else if (c > 0)
        {
            
            fwrite(buffer, sizeof(buffer), 1, temp);            
            
        }
      
        
        
    }


    fclose(file);
    

    
    return 0;
}
