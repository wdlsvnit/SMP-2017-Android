#include<stdio.h>
#include<cs50.h>
#include<ctype.h>
#include<string.h>

int main(void)
{
    string s = get_string();
    int n =strlen(s);
    int i;
    int temp=1;
     
    if(s!=NULL)
    {
       for(i=0;i<n;i++)
       {
         if(temp>=1)
         {
          if(toupper(s[i])>='A' && toupper(s[i])<='Z')
          {printf("%c",toupper(s[i]));
          temp=0;
          }  
         }
         
         if(s[i]==' ')
         temp++;
       }
    }
    printf("\n");
    
    return 0;
    
}