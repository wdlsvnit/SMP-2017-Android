#include<stdio.h>
#include<cs50.h>
int main(){
    int a;
    printf("Minutes : ");
    a=get_int();
    printf("Bottles : %i\n",a*12);
    return 0;
}