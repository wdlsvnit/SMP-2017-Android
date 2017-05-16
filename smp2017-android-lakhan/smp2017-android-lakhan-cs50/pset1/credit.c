#include<stdio.h>
#include<cs50.h>
#include<math.h>

int main(void)
{
  printf("Number: ");
  
  long long int n,m;  
  
  do 
  {
   n= get_long_long();
  }
  while(n<=0)  ;
  
   m=n;
  int length = (int)(log10(n)+1) ;
    int s1=0,s2=0,s3=0,sum=0,i,j;
    int firstwo=0;
    
    for(i=1;i<=length;i++)
    {  if(i%2==0)
       { s1 = 2*(m%10);
          for(j=1;j<3;j++)
              { s3=s3+s1%10;
                 s1=s1/10;
                      
              }
       }      
       else
       s2 =s2+m%10;
        
       if(i==(length-1))
     firstwo=m%10;
      
      if(i==(length))
     firstwo=firstwo*10+m%10;
     
        m=m/10;
    }
    
    
    
    int ft = firstwo%10;
    int f = ft;
    firstwo=firstwo/10;
    ft = ft*10+firstwo%10;
    
    
    sum = s2+s3;
    if(sum%10!=0)
    printf("INVALID\n");
    
    else
    switch(length)
    {
      case 13: if(f==4)
                  printf("VISA\n");
                    break;

      case 15: if(ft==34||ft==37)
                  printf("AMEX\n");
                    break;
                    
     case 16: if(ft==51||ft==52|ft==53||ft==54||ft==55)
                  printf("MASTERCARD\n");
               
               if(f==4)
                  printf("VISA\n");
               
                    break;          
                    
    default : printf("INVALID\n");
                    break;
    }

    return 0;
}