/**
 * helpers.c
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
    
    if (n<=0)
    return false;
    
    int middle, start ,end;
    end = n;
    start = 0;
    
    check: {
    
    middle = (start + end )/2;
    
    if (start>end)
    return false;
    
    if(values[middle] == value)
    return true;
    //right side
    else if(values[middle]<value)
        start =  middle+1;
    //left side
    else 
       end = middle-1 ;
     
     

    }
    goto check;          
} 

/**
 * Sorts array of n values.
 */
void sort(int values[], int n)
{
    // TODO: implement a sorting algorithm
     int count[65536]= {0};
     for (int i =0;i<=n;i++)
     {
         count[values[i]-1]++; //counting no.
     }
     
 
    
  
     //storing sorted array    
    // j for count array
    // i for values array
    for(int j=0,i=0;i<=n;)
    {
     if(count[j]>0)
     {
     values[i]=j+1;
     count[j]--;
     i++;
         
     }
     else 
     j++;
     
    }
   
   
    return;
}
