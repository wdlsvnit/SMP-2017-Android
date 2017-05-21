#include <stdio.h>
main()
{
	int n,i,j,k;
	printf("Enter the height of the pyramid you want:");
	scanf("%d",&n);
	for (int i = 0; i <= n; i++)//for height
	{
		for (int j = 0; j < n; j++)//for spacing
		{
			printf(" ");
		}
		for (int k = 1; k <= i ; k++)//for pyramid
		{
			printf("*");
		}
		printf("\n");
	}
	return 0;
}