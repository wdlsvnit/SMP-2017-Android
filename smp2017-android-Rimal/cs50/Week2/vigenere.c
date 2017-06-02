#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main (int argc, string argv[])
{
    if(argc !=2)
    {
        printf("please put in command line argument: example - ./vigenere command\n");
        return 1;
    }
    string key = argv[1];
    int l = strlen(key);
    for (int i=0;i<l; i++)
    {
        if(!isalpha(key[i]))
        {
            printf("please make sure command is letter only. Please no numbers or special characters!\n");
            return 1;
        }
    }
    string text = GetString();

    for (int i=0, k=0; i<l; i++)
    {
        if(isalpha(text[i]))
        {
            if(isupper(text[i]))
            {
                text[i]=((text[i]-'A')+(key[k%l]))%26+'A';
            }
            else
            {
                if(islower(text[i]))
                {
                text[i]=((text[i]-'a')+(key[k%l]))%26+'a';
            }
        }
    }
}
printf("%s\n",text);
return 0;
}