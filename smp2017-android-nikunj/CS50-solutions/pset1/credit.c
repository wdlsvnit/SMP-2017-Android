#include<stdio.h>
#include<cs50.h>
int main(){
    long long a,suma=0,sumb=0,temp1;
    printf("Number: ");
    a=get_long_long();
    for(long long temp=a;temp>0;temp/=100){
            suma+=temp%10;
    }
    for(long long temp=a/10;temp>0;temp/=100){
            temp1=(temp%10)*2;
            while(temp1>0)
            {
                sumb+=(temp1%10);
                temp1/=10;
            }
            
    }
    if((suma+sumb)%10==0)
    {
        
    
    if((a>=340000000000000ll&&a<350000000000000ll)||(a>=370000000000000ll&&a<38000000000000000ll)){
        printf("AMEX\n");   
     
    }
    else if(a>=5100000000000000ll&&a<5600000000000000ll){
        printf("MASTERCARD\n");
    }
    else if((a >= 4000000000000ll && a < 5000000000000ll) || (a >= 4000000000000000ll && a < 5000000000000000ll)){
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