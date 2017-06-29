#include  <stdio.h>

int main(void)
{
    int i,j=0,add=13;
	char a[100];
	gets(a);
	for(i=0;i<sizeof(a);i++)
	{
     
        if((a[i]>=65 && a[i]<=90)) 
	    {
           
	        printf("%c",a[i]+j);
            j++;
          
	    }
        
        if((a[i]>=97 && a[i]<=122))
	    {
            
	         printf("%c",a[i]+j);
             j++;
            
	    }
        if(a[i]==' ')
        {
            printf(" ");
        }
        if(j>=3)
        {
            j=0;
        }
    }
    return 0;
}urn 0;
}