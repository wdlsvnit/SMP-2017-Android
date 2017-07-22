/**
 * Implements a dictionary's functionality.
 */

#include <stdbool.h>
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#include "dictionary.h"


// size of hashtable
#define SIZE 1000000



typedef struct node
{
    char word[LENGTH+1];
    struct node* next;
}
node;

// create hashtable
node* hashtable[SIZE] = {NULL};


// create hash function
int hash (const char* word)
{
    int hash = 0;
    int n;
    for (int i = 0; word[i] != '\0'; i++)
    {
        
        if(isalpha(word[i]))
            n = word [i] - 'a' + 1;
        
        
        else
            n = 27;
            
        hash = ((hash << 3) + n) % SIZE;
    }
    return hash;    
}


int dictionarySize = 0;

/**
 * Returns true if word is in dictionary else false.
 */
bool check(const char *word)
{
    
    
    
    char temp[LENGTH + 1];
    int len = strlen(word);
    for(int i = 0; i < len; i++)
        temp[i] = tolower(word[i]);
    temp[len] = '\0';
    
    
    int index = hash(temp);
    
    
    if (hashtable[index] == NULL)
    {
        return false;
    }
    
    
    node* cursor = hashtable[index];
    
    
    while (cursor != NULL)
    {
        if (strcmp(temp, cursor->word) == 0)
        {
            return true;
        }
        cursor = cursor->next;
    }
    
    
    return false;
    
    
    
}

/**
 * Loads dictionary into memory. Returns true if successful else false.
 */
bool load(const char *dictionary)
{
    FILE* file = fopen(dictionary, "r");
    if (file == NULL)
        return false;
    
    
    char word[LENGTH+1];
    
    
    while (fscanf(file, "%s\n", word)!= EOF)
    {
    
        dictionarySize++;
        
    
        node* newWord = malloc(sizeof(node));
        
        
        strcpy(newWord->word, word);
        
        
        int index = hash(word);
        
        
        if (hashtable[index] == NULL)
        {
            hashtable[index] = newWord;
            newWord->next = NULL;
        }
        
        
        else
        {
            newWord->next = hashtable[index];
            hashtable[index] = newWord;
        }      
    }
    
    
    fclose(file);
    
    // return true if successful 
    return true;
}

/**
 * Returns number of words in dictionary if loaded else 0 if not yet loaded.
 */
unsigned int size(void)
{
    
    
    if (dictionarySize > 0)
    {
        return dictionarySize;
    }
     
    
    else
        return 0;
}

/**
 * Unloads dictionary from memory. Returns true if successful else false.
 */
bool unload(void)
{
    // TODO
    
    int index = 0;
    
    
    while (index < SIZE)
    {
        // if hashtable is empty at index, go to next index
        if (hashtable[index] == NULL)
        {
            index++;
        }
        
        // if hashtable is not empty, iterate through nodes and start freeing
        else
        {
            while(hashtable[index] != NULL)
            {
                node* cursor = hashtable[index];
                hashtable[index] = cursor->next;
                free(cursor);
            }
            
            // once hashtable is empty at index, go to next index
            index++;
        }
    }
    
    // return true if successful
    return true;
}
