#include<stdio.h>
#include<cs50.h>
int main(void)
{
    int n;
    printf("Height: ");
    n=get_int();
    while((n<0)||(n>23))
    { printf("Retry: ");
        n=get_int();    }
        for(int i=0;i<n;i++)
        {
            for(int j=n;j>i+1;j--)
            {   printf(" ");    }
            for(int k=-1;k<=i;k++)
            {   printf("#");    }
            printf("\n");
        }
    
}