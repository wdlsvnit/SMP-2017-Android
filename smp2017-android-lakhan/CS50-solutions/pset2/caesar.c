#include<stdio.h>
#include<stdlib.h>
#include<cs50.h>
#include<ctype.h>
#include<string.h>

int main(int argc , string argv[])
{
    int key = 0;
    string s;
    
    if(argc!=2 || atoi(argv[1])<0)
    {
        printf("error , give correct input");
        return 1;
    }
    else 
    key = atoi(argv[1]); 
    
    
    printf("plaintext:  ");
    s=get_string();
    
   int n =strlen(s);

     printf("ciphertext: ");
    
    for(int i =0;i<n;i++)
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