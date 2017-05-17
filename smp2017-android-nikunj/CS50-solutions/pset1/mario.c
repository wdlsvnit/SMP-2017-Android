#include<stdio.h>
#include<cs50.h>
int main(){
    int a;
    printf("Height : ");
    a=get_int();
    for(int i=0;i<a;i++)
    {
        for(int j=a-1;j>i;j--)
        {
            printf(" ");
        }
        for(int j=0;j<=i;j++)
        {
            printf("#");
        }
        printf(" ");
        for(int j=0;j<=i;j++)
        {
            printf("#");
        }
        printf("\n");
    }
    return 0;
}