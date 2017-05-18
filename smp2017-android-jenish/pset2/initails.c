#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main()
{
    int j=0;
    char a[100];
    gets(a);
    for(int i=0;a[i]!='\0';i++)
    {
        if(j == 0)
        {
            printf("%c",toupper(a[i]));
        }
        if(a[i] == ' ')
        {
            j=0;
        }
        else
        {
            j=1;
        }
    }
    
    return 0;s
}
