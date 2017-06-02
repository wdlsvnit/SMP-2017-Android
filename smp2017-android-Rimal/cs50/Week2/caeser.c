#include <stdio.h>
#include <cs50.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
 int main(int argc, string argv[])
{
    int key;
    int cipher;
     if (argc != 2)
    {
        printf("Enter the encription key while running the program.\n");
        return 1;
    }
    prinf("Enter the text to be encripted: ")
    string PlainText = GetString();
     key = atoi(argv[1]);
     for(int i = 0, length = strlen(PlainText); i < length; i++)
    {
        cipher = (PlainText[i] + key);
         if (isupper(PlainText[i]) && (cipher > 'Z'))
        {
            cipher = (cipher - 26);
        }
         if (islower(PlainText[i]) && (cipher > 'z'))
        {
            cipher = (cipher - 26);
        }
         if (isalpha(PlainText[i]))
        {
            printf("%c", cipher);
        }
         else
        {
            printf("%c", PlainText[i]);
        }
 
    }
 
    printf("\n");
    return 0;
}