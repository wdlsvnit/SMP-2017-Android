#include<stdio.h>
#include<stdlib.h>
#include<cs50.h>
#include<ctype.h>
#include<string.h>

int main(int argc , string argv[])
{
    
    string key ;
    
    
    //check if arguments are correct
    if(argc!=2 )
    { 
        printf("error , give correct input, give 1 argument, format - ./vigenere abc");
        return 1;
    }
    
    key = argv[1];
    int m =strlen(key);
    
    for(int i = 0;i<m;i++)
     { 
           if(!isalpha(argv[1][i]))
              {
                  printf("error only alphabetical key please");
                  return 1;
              }
     }
     
     
    printf("plaintext: ");
  string  s = get_string();
    int n =strlen(s);

     printf("ciphertext: ");
    
    char key1;
    int j =0;
    for(int i =0;i<n;i++)
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