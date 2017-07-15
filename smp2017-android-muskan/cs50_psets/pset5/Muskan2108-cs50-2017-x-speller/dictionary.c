#include <stdbool.h>
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#include "dictionary.h"
#define SIZE 1000000
typedef struct element
{
    char word[LENGTH+1];
    struct element* next;
}
element;
element* table[SIZE] = {NULL};
int hash (const char* word)
{
    int hash = 0;
    int n;
    for (int i = 0; word[i] != '\0'; i++)
    {
        if((word[i]>='a')&&(word[i]<='z'))
            n = word [i] - 'a' + 1;
        else
            n = 27;
       hash = (hash+n)%SIZE;
    }
    return hash;    
}
int dsize = 0;

bool load(const char* dictionary)
{
    FILE* file = fopen(dictionary, "r");
    if (file == NULL)
        return false;
    char word[LENGTH+1];
    while (fscanf(file, "%s\n", word)!= EOF)
    {
        dsize++;
        element* newWord = malloc(sizeof(element));
        strcpy(newWord->word, word);
        int in = hash(word);
        if (table[in] == NULL)
        {
            table[in] = newWord;
            newWord->next = NULL;
        }
        else
        {
            newWord->next = table[in];
            table[in] = newWord;
        }      
    }
    fclose(file);
    return true;
}


bool check(const char* word)
{
    char temp[LENGTH + 1];
    int len = strlen(word);
    for(int i = 0; i < len; i++)
        temp[i] = tolower(word[i]);
    temp[len] = '\0';
    int in = hash(temp);
    if (table[in] == NULL)
    {
        return false;
    }
    element* c = table[in];
    while (c != NULL)
    {
        if (strcmp(temp, c->word) == 0)
        {
            return true;
        }
        c = c->next;
    }
    return false;
}


unsigned int size(void)
{
    if (dsize > 0)
    {
        return dsize;
    }
    else
        return 0;
}


bool unload(void)
{
    int in = 0;
    while (in < SIZE)
    {
        if (table[in] == NULL)
        {
            in++;
        }
        else
        {
            while(table[in] != NULL)
            {
                element* c = table[in];
                table[in] = c->next;
                free(c);
            }
            in++;
        }
    }
    return true;
}