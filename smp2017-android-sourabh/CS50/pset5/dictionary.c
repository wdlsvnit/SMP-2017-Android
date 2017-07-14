/**
 * Implements a dictionary's functionality.
 */
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <stdio.h>
#include <ctype.h>

#include "dictionary.h"
#define HASHTABLE 500

list * hashtable[HASHTABLE];
/**
 * Returns true if word is in dictionary else false.
 */
 list *first;

unsigned int hash1(char * str)
{
    unsigned long int hash = 5381;
    int c;
    while ((c = *str++))
    {
        hash = ((hash << 5) + hash) + tolower(c);
    }
    return hash % HASHTABLE;
  
}

void lladd(char* str,unsigned int hashval)
{
    
    list * add = malloc(sizeof(list));
    add->val = malloc(sizeof(char)*(strlen(str)+1));
    strcpy(add->val,str);
    add->nxt = hashtable[hashval];
    hashtable[hashval] = add;
}

bool check(const char *word)
{
    
    char * copy = malloc(sizeof(char)*(strlen(word)+1));
    
    for(int i = 0; i<=strlen(word);i++)
    {
        *(copy+i)=tolower(word[i]);
    }
    unsigned int hashval = hash1(copy);
    list * curr = hashtable[hashval];
    
    while(curr != NULL)
    {
        if(!strcmp((curr->val),copy))
        {
            free(copy);
            return true;
        }
        curr = curr->nxt;
    }
        free(copy);
    return false;
}

/**
 * Loads dictionary into memory. Returns true if successful else false.
 */
bool load(const char *dictionary)
{
    
    FILE *inptr = fopen(dictionary,"r");
    if(inptr == NULL)
    {
        return false;
    }
    while(1)
    {
           char word[45];
            int i=0,c=0;
           for(c = fgetc(inptr); (char)c!='\n';i++,c=fgetc(inptr))
           {
                 if(c==EOF)
                {
                    break;
                }
                 word[i]=(char)c;
           }
            word[i]='\0';
            unsigned int value = hash1(word);
            lladd(word,value);
            fgetc(inptr);
            if(feof(inptr))
            {
                break;
            }
            fseek(inptr,-sizeof(char),SEEK_CUR);
    }
    fclose(inptr);
    return true;
}

/**
 * Returns number of words in dictionary if loaded else 0 if not yet loaded.
 */
unsigned int size(void)
{
    
    int a =0;
    for(int i =0;i<HASHTABLE;i++)
    {
        list *curr = hashtable[i];
        while(curr != NULL)
        {
            curr = curr->nxt;
            a++;
        }
    }
    return a;
}

/**
 * Unloads dictionary from memory. Returns true if successful else false.
 */
bool unload(void)
{
    for(int i =0;i<HASHTABLE;i++)
    {
        list *curr = hashtable[i];
        while(curr != NULL)
        {
            list *temp = curr->nxt;
            free(curr->val);
            free(curr);
            curr = temp;
        }
        
    }
    return true;
    
}



 
 
