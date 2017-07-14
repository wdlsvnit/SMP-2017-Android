#include<stdio.h>
#include<cs50.h>
#include<string.h>

int main( int argc, string argv[] )  {

   if( argc == 2 ) 
{	int n1,x;
	n1=strlen(argv[1]);
	string b;
	b=argv[1];
	x=0;
	for(int j=0;j<n1;j++)
{
	if(((b[j]>=65)&&(b[j]<=90))||((b[j]>=97)&&(b[j]<=122)))
	{	continue;	}
	else
	{	x++;	}
	
}
if(x>0)
{	printf("Wrong argument passed.\n");
	return 1;	}
else
	{string s;
	printf("plaintext: ");
	s=get_string();
	int n,c;
	c=0;
	n=strlen(s);
	int t;
	printf("ciphertext: ");
	for(int i=0;i<n;i++)
	{
		if((s[i]>=65)&&(s[i]<=90))
		{	if(c>(n1-1))
			{	c=0;	}
			if((b[c]>=65)&&(b[c]<=90))
			{	t=s[i]+b[c]-65;	}
			else if((b[c]>=97)&&(b[c]<=122))
			{	t=s[i]+b[c]-65-32;	}
			c++;
			if(t>90)
			{	t=64+(t%90);	}
			s[i]=t;
			printf("%c",s[i]);	
		}
		else if((s[i]>=97)&&(s[i]<=122))
		{	if(c>(n1-1))
			{	c=0;	}
			if((b[c]>=65)&&(b[c]<=90))
			{	t=s[i]+b[c]-97+32;	}
			else if((b[c]>=97)&&(b[c]<=122))
			{	t=s[i]+b[c]-97;	}
			c++;
			if(t>122)
			{	t=96+(t%122);	}
			s[i]=t;
			printf("%c",s[i]);	
		}
		else
		{	printf("%c",s[i]);	}
	}
	printf("\n");
return 0;
	
   }}
   else if( argc > 2 ) {
      printf("Too many arguments supplied.\n");
	return 1;
   }
   else {
      printf("One argument expected.\n");
	return 1;
 	}		
}