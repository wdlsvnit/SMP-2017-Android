#include <stdio.h>

#include <string.h>
#include <ctype.h>

int main(int n)
{
    int i,j,k;
    char s[100];
    //printf("Enter the Key : ");
    //scanf("%d",&n);
    printf("Enter the string : ");
    
    gets(s);
    for (i=0;i<strlen(s);i++)
    {
        if(isalpha(s[i]))
        {
            if(isupper(s[i]))
            {
                j = (s[i] + n -65) % 26;
                k = j+65-1;
                printf("%c",k);
            }
            else
            {
                j = (s[i] + n -97) % 26;
                k= j+97-1;
                printf("%c",k);
            }
        }
        else
        {
            printf("%c",s[i]);
        }
        
    }
    
    
    
}
