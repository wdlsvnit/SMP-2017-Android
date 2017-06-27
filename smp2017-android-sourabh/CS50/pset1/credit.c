#include<stdio.h>
int main(){
    long long a,suma=0,sumb=0,temp1,temp;
    printf("Number: ");
    scanf("%lld",&a);
    for(temp=a;temp>0;temp/=100)
    {
            suma+=temp%10;
    }
    for(temp=a/10;temp>0;temp/=100)
    {
            temp1=(temp%10)*2;
            while(temp1>0)
            {
                sumb+=(temp1%10);
                temp1/=10;
            }
            
    }
    if((suma+sumb)%10==0)
    {
        
    
  	    if((a>=340000000000000ll&&a<350000000000000ll)||(a>=370000000000000ll&&a<38000000000000000ll))
	    {
		printf("AMEX\n");   
	     
	    }
	    else if(a>=5100000000000000ll&&a<5600000000000000ll)
	    {
		printf("MASTERCARD\n");
	    }
	    else if((a >= 4000000000000ll && a < 5000000000000ll) || (a >= 4000000000000000ll && a < 5000000000000000ll))
	    {
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
