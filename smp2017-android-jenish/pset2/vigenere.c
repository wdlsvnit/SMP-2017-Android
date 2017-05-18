#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>

int main(int argc , char* argv[])
{
    
    char* key ;
    
    
    if(argc!=2 )
    {
        printf("error , give correct input, give 1 argument, format - ./vigenere abc");
        return 1;
    }
    
    key = argv[1];
    int i;
    for(i = 0;i<strlen(key);i++)
    {
        if(!isalpha(argv[1][i]))
        {
            printf("error only alphabetical key please");
            return 1;
        }
    }
    
    
    printf("plaintext: ");
    char s[100];
    gets(s);
    
    
    printf("ciphertext: ");
    
    char key1;
    int j =0;
    for(i =0;i<strlen(s);i++)
    {
        if(isalpha(s[i]))
        {
            //uppercase
            if(isupper(s[i]))
            {
                
                key1= toupper(key[j%(strlen(key))])-65;
                s[i]= (s[i] -'A' + key1)%26+65;
                j++;
            }
            //lowercase
            if(islower(s[i]) && isalpha(s[i]))
            {
                
                key1= toupper(key[j%(strlen(key))])-65;
                s[i]= (s[i] -'a' +key1)%26+97;
                j++;
                
            }
        }
        printf("%c",s[i]);
        
    }
    
    printf("\n");
    
    return 0;
}
