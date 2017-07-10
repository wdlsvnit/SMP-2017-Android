#include <cs50.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
int main (int argc, char* argv[])
{
    bool isWord;
    string k;
    string p;
    int j = 0;
    int key;
    if (argc != 2)
    {
        printf("Sorry\n");
        return 1;
    }
    else
    {
        for (int i = 0, j = strlen(argv[1]); i < j; i++)
        {
            isWord = isalpha(argv[1][i]);
        }
        if (isWord == false)
        {
            printf("Sorry\n");
            return 1;
        }
    }
    k = argv[1];

    p = GetString();

    for (int i = 0, m = strlen(p); i < m; i++)
    {
        if (isalpha(p[i]))
        {
            j = j % strlen(k);
            if (isupper(k[j]))
            {
                key = k[j] - 'A';
            }
            else
            {
                key = k[j] - 'a';
            }
            if (isupper(p[i]))
            {
                p[i] = (p[i] - 'A' + key) % 26;
                p[i] = p[i] + 'A';
                j++;
            }
            else
            {
                p[i] = (p[i] - 'a' + key) % 26;
                p[i] = p[i] + 'a';
                j++;
            }
        }
    }
    for (int i = 0, m = strlen(p); i < m; i++)
    {
        printf("%c", p[i]);
    }
    printf("\n");

}
 