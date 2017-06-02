#include<stdio.h>
#include<cs50.h>
#include<string.h>
#include<ctype.h>

int main(void)
{
    string n;
    n=get_string();
    printf("%c",toupper(n[0]));
    for (int i=0 ; i<strlen(n);i++)
    {
        if(n[i]==' ' && n[i+1]!='\0')
        printf("%c",toupper(n[i+1]));
    }
    printf("\n");
}