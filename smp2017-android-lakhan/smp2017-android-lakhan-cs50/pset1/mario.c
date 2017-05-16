#include<cs50.h>
#include<stdio.h>

int main(void)
{ 

    int n;

  do
  {    printf("Height: ");
      n=get_int();
      
  }
  while(n<0||n>23);

      int i,j;
  
  for(i=0;i<n;i++)
     {
         for(j=i;j<n-1;j++)
         printf(" ");
         
         for(j=n-i-1;j<n+1;j++)
         printf("#");
         
      
      printf("\n");
     }

    return 0;
}