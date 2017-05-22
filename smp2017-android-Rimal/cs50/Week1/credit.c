#include<stdio.h>
#include<cs50.h>
int main()
{
    long long n,a=0,b=0,t,s;
    printf("Enter the number: ");
    n=get_long_long();
    for(t=n ; t>0 ; t/=100)
    {
            a+=t%10;
    }
    for(t=n/10;t>0;t/=100)
    {
            s=(t%10)*2;
            while(s>0)
            {
                b+=(s%10);
                s/=10;
            }
            
    }
    if((a+b)%10==0)
    {
        if ( (n >= 340000000000000 && n < 350000000000000) || (n >= 370000000000000 && n < 380000000000000) )
            printf("AMERICAN EXPRESS\n");
        else if ( n >= 5100000000000000 && n < 5600000000000000 )
            printf("MASTERCARD\n");
        else if ( (n >= 4000000000000 && n < 5000000000000) || (n >= 4000000000000000 && n < 5000000000000000) )
            printf("VISA\n");
        else
            printf("INVALID\n");
    }
    {
        printf("Invalid\n");
    }
    return 0;
}