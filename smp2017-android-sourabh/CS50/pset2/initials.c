#include<stdio.h>
#include<ctype.h>
#include<string.h>

int main(void)
{
    char s[101];
    gets(s);
    int n =strlen(s);
    int i;
    while(s[i++]==' '); 
    printf("%c",s[i-1]);
    if(s!=NULL)
    {
       for(i=0;i<n;i++)
       {
		if(s[i]==' '&&s[i+1]!=' ')
			printf("%c",toupper(s[i+1]));
       }
    }
    printf("\n");
    return 0;
    
}
