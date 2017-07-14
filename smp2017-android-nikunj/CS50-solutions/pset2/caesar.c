#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main (int argc, string argv[])
{
    int k;
    string p;
    if (argc != 2)
    {
        printf("Sorry\n");
        return 1;
    }
    k = atoi(argv[1]);
    p = GetString();
    for (int i = 0, m = strlen(p); i < m; i++)
    {
        if (isalpha(p[i]))
        {
            if (isupper(p[i]))
            {
            
                p[i] = (p[i] - 'A' + k) % 26;
                p[i] = p[i] + 'A';
            }
            else
            {
            
                p[i] = (p[i] - 'a' + k) % 26;
                p[i] = p[i] + 'a';
            }
        }
    }
    for (int i = 0, m = strlen(p); i < m; i++)
    {
        printf("%c", p[i]);
    }
    printf("\n");
}