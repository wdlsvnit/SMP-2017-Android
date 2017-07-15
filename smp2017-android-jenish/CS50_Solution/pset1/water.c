#include <stdio.h>
int main()
{
    int n;
    printf("Mintes : ");
    do
    {
        scanf("%d",&n);
    }
    while(n<0);
    
    printf("Bottles : %d",n*12);
    return 0;
}
