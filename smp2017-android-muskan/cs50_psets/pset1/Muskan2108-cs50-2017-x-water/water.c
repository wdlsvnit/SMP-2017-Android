#include<stdio.h>
#include<cs50.h>
int main(void)
{
    int b;
    printf("Minutes: ");
    b=get_int();
    printf("Bottles: %i\n",b*12);
}