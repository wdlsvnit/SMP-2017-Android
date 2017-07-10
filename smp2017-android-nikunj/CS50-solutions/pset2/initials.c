#include <cs50.h>
#include <stdio.h>
#include <ctype.h>
int main(void)
{
    string n = GetString();
    char initials[10];
    int i = 0, j = 0;
    for (i=0; n[i]!='\0'; i++)
    {
        if (i == 0)                            
            demo[j++]=toupper(n[i]);
        if (n[i-1] == ' ')                
            demo[j++]=toupper(n[i]);
    }
    for(i=0; i<j; i++)                     
        printf("%c",demp[i]);
    printf("\n");
    return 0;
}