#include<stdio.h>
#include<cs50.h>
#include<string.h>

int main( int argc, string argv[] )  {

   if( argc == 2 ) 
{	string s;
	printf("plaintext: ");
	s=get_string();
	int n;
	n=strlen(s);
	long long int u,t;
	u=atoi(argv[1]);
	u=u%26;
	printf("ciphertext: ");
	for(int i=0;i<n;i++)
	{
		if((s[i]>=65)&&(s[i]<=90))
		{
			t=s[i]+u;
			if(t>90)
			{	t=64+(t%90);	}
			s[i]=t;
			printf("%c",s[i]);	
		}
		else if((s[i]>=97)&&(s[i]<=122))
		{
			t=s[i]+u;
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
	
   }
   else if( argc > 2 ) {
      printf("Too many arguments supplied.\n");
	return 1;
   }
   else {
      printf("One argument expected.\n");
	return 1;
 	}		
}