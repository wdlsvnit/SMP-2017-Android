#include<stdio.h>
int main(){
    int a,i,j;
    printf("Height : ");
    scanf("%d",&a);
    for( i=0;i<a;i++)
    {
        for( j=a-1;j>i;j--)
        {
            printf(" ");
        }
        for(j=0;j<=i;j++)
        {
            printf("#");
        }
        printf(" ");
        for( j=0;j<=i;j++)
        {
            printf("#");
        }
        printf("\n");
    }
    return 0;
}
