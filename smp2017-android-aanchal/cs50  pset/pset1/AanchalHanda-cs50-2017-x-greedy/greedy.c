#include<stdio.h>
#include<cs50.h>
#include<math.h>
int main(void)
{  printf("O hai! How much change is owed?\n");
   float ch=get_float();
   while(ch<0)
   {printf("O hai! How much change is owed?\n");
    ch=get_float();}
  
   int change=round(ch*100);
   int c=0;
   
   c=change/25;
        change=change%25;
        
         c+=change/10;
        change=change%10;
       
         c+=change/5;
        change=change%5;
      
        c+=change;
       printf("%i\n",c);
    }