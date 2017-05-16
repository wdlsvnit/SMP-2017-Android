#include<cs50.h>
#include<stdio.h>

int main(void)
{
    int n ;
    
    printf("Minutes: ");
    
    do
    {
        n = get_int();
    }
    while(n<0); 
    
    printf("Bottles: %d",n*12);
    
       
}