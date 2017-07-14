#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>

int main(int argc , char **argv)
{
    
    char *key ;
    char key1;
    int j =0,n;
    char s[100];
    //check if arguments are correct
    if(argc!=2 )
    { 
        printf("Error , give correct input, give 1 argument, format - ./vigenere abc\n");
        return 1;
    }
    
    key = argv[1];
    int i,m =strlen(key);
    
    for(i = 0;i<m;i++)
     { 
           if(!isalpha(key[i]))
              {
                  printf("error only alphabetical key please");
                  return 1;
              }
     }
     
     
    printf("plaintext: ");
    gets(s);
    n =strlen(s);
    printf("ciphertext: ");
    for(i =0;i<n;i++)
    {   
        
     //uppercase
        if(isupper(s[i]) && isalpha(s[i]))
         { 
             
             key1= toupper(key[j%(m)])-'A';
             s[i]= (s[i] -'A' +key1)%26+65;
             j++;
         } 
     //lowercase
        if(islower(s[i]) && isalpha(s[i]))
           {
               
             key1= toupper(key[j%(m)])-'A';
             s[i]= (s[i] -'a' +key1)%26+97;
            j++;
               
           }
        printf("%c",s[i]);
        
    }
    
printf("\n");
    
    return 0;
}
