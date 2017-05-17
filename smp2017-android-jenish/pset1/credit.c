#include <stdio.h>


int main()
{
    long long n,temp,a=0,b=0;
    printf("NUMBER : ");
    scanf("%lld",&n);
    temp=n;
    int k;
    int i=1;
    temp=n;
    while(temp>0)
    {
        if(i%2 == 0)
        {
            k=(temp%10)*2;
            while(k>0)
            {
                a = a + (k%10);
                k=k/10;
            }
            
        }
        else{
            b=b+(temp%10);
        }
        temp=temp/10;
        i++;
    }
   
    if((a+b)%10==0)
    {
        
        
        if((n>=340000000000000&&n<350000000000000)||(n>=370000000000000&&n<38000000000000000)){
            printf("AMEX\n");
            
        }
        else if(n>=5100000000000000&&n<5600000000000000){
            printf("MASTERCARD\n");
        }
        else if((n >= 4000000000000 && n < 5000000000000) || (n >= 4000000000000000 && n < 5000000000000000)){
            printf("VISA\n");
        }
        else
        {
            printf("INVALID\n");
        }
    }
    else
    {
        printf("INVALID\n");
    }
    return 0;
}
