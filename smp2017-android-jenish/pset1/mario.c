#include <stdio.h>

int main()
{
    int n;
    do
    {
    
        printf("Height : ");
        scanf("%d",&n);
    }
    while(n<=0 || n>23);
    
    for (int i=1;i<=n;i++)
    {
        for(int j=1;j<=n+1;j++)
        {
            if(j>n-i)
                printf("#");
            else
                printf(" ");
        }
        printf("\n");
    }
    
    return 0;
}
