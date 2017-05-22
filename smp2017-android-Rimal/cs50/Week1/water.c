#include <cs50.h>
#include <stdio.h>
int main(void)
{
    int minutes,b;
    printf("Enter the time in minutes: ");
    minutes = get_int();
    if (minutes > 0)
    {
        b = ( 128 * (1.5 * minutes) ) / 16;
        printf("bottles: %d\n",b);
    }
    else
    {
        printf("Enter integer value\n");
    }
}