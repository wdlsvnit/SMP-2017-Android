#include<stdio.h>
#include<cs50.h>
#include<string.h>
int main(void)
{
	string s;
	s=get_string();
	int n;
	n=strlen(s);
	char u;
	if((s[0]>=97)&&(s[0]<=122))
	{	u=s[0]-32;	}
	else
	{	u=s[0];	}
	printf("%c",u);
	for(int i=0;i<n;i++)
	{
		if(s[i]==' ')
		{	if((s[i+1]>=97)&&(s[i+1]<=122))
			{	u=s[i+1]-32;	}
			else
			{	u=s[i+1];	}
			printf("%c",u);
		}		
	}
	printf("\n");
}