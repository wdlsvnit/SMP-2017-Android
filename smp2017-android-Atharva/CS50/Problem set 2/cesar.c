#include  <stdio.h>
#include  <ctype.h>
int main(void)
{
    int i,add=13;
	char a[100];
	gets(a);
	for(i=0;i<sizeof(a);i++)
	{
	    if((a[i]>=65 && a[i]<=90)) 
	    {
            if(13+a[i]>90)
            {
                add=13+a[i]-90;
                printf("%c",64+add);
                add=13;
                continue;
            }
	        printf("%c",a[i]+add);
          
	    }
        
        if((a[i]>=97 && a[i]<=122))
	    {
             if(13+a[i]>122)
             {
                 add=13+a[i]-122;
                 printf("%c",96+add);
                 add=13;
                 continue;
             }
	         printf("%c",a[i]+add);
            
	    }
        if(a[i]==' ')
        {
            printf(" ");
        }
	}
    return 0;
}