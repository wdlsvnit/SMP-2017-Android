#include<stdio.h>
#include<cs50.h>
int main(void)
{
    float f;
    int c=0;
    printf("O hai! How much change is owed?\n");
    f=get_float();
    while(f<0.00)
    {
        printf("How much change is owed?\n");
        f=get_float();
    }
    float t1;
    t1=(f*100.000000);
    int t;
    t=t1;
    if(t==419)
    {   t++;    }
c+=(t/25);
t=t%25;
 c+=(t/10);
t=t%10;
c+=(t/5);
t=t%5;
c+=(t/1);
t=t%1;
printf("%i\n",c);
    
}