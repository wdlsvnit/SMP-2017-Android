#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>

int main(int argc , char **argv)
{
    int key = 0,i;
    char *s;
    
    if(argc!=2 || atoi(argv[1])<0)
    {
        printf("error , give correct input\n");
        return 1;
    }
    else 
    key = atoi(argv[1]); 
    
    
    printf("plaintext:  ");
    gets(s);
    
   int n =strlen(s);

     printf("ciphertext: ");
    
    for(i =0;i<n;i++)
    {   
     //uppercase
        if(isupper(s[i]) && isalpha(s[i]))
           s[i]= (s[i] -'A' +key)%26+65;
           
     //lowercase
        if(islower(s[i]) && isalpha(s[i]))
           s[i]= (s[i] -'a' +key)%26+97;
           
        printf("%c",s[i]);
        
    }
    
printf("\n");
    
    return 0;
}
