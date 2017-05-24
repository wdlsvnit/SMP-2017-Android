#include<stdio.h>
#include<cs50.h>
int main(){
    int n,i,j;
    printf("Enter the height of pyramid you want:");
   n=get_int();
    for(i=0;i<n;i++)
    {
        for(j=n-1;j>i;j--)
        {
            printf(" ");
        }
        for(j=0;j<=i;j++)
        {
            printf("*");
        }
        for(j=0;j<=i;j++)
        {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}