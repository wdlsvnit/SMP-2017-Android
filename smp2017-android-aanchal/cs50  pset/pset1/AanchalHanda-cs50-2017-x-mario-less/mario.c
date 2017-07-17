#include<stdio.h>
#include<cs50.h>
int main(void)
{
    printf("Height: ");
    int hei=get_int();
    int i,s,j;
  while(hei<0 || hei >23)
  { printf("Height: ");
      hei=get_int();}
    for(i=0;i<hei;i++)
    {
        for(s=hei-1;s>i;s--)
        printf(" ");
        for(j=0;j<i+2;j++)
        printf("#");
        printf("\n");
    }
}
    