/**
 * helpers.c
 *
 * Computer Science 50
 * Problem Set 3
 *
 * Helper functions for Problem Set 3.
 */
       
#include <cs50.h>

#include "helpers.h"

/**
 * Returns true if value is in array of n values, else false.
 */
bool search(int value, int values[], int n)
{
    // TODO: implement a searching algorithm
    int j=0;
    int i=0;
    for(i=0;i<n;i++)
    {
        if(value == values[i])
        {
            j=1;
            
        }
        
        
    }
    if(j==0)
    return false;
    else
    return true;
}

/**
 * Sorts array of n values.
 */
void sort(int values[], int n)
{
    // TODO: implement an O(n^2) sorting algorithm
    int i,j;
    int temp;
    for(i=0;i<n-1;i++)
    {
        for(j=0;j<n-i-1;j++)
        {
            if(values[j] > values[j+1])
            {
                temp=values[j+1];
                values[j+1]=values[j];
                values[j]=temp;
            }
        }
    }
    
   // return;
}