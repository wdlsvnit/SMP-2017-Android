#include  <stdio.h>
#include  <ctype.h>
int main(void)
{
    int n,i,j;
	char a[100];
	gets(a);
    putchar(toupper(a[0]));
	for(i=0;i<sizeof(a);i++)
	{
	    if(a[i]==' ')
	    {
	        putchar(toupper(a[i+1]));
	    }
	}
    return 0;
}