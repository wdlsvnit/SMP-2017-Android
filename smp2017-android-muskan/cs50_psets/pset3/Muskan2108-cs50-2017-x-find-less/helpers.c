/**
 * helpers.c
 *
 * Helper functions for Problem Set 3.
 */
 
#include <cs50.h>

#include "helpers.h"
/**
 * Sorts array of n values.
 */
void sort(int values[], int n)
{
	 	int d,c,t;
	for (c = 1 ; c <= n - 1; c++) 
	{
    		d = c;
 		while ( d > 0 && values[d] < values[d-1]) 
		{
			t=values[d];
      			values[d]=values[d-1];
      			values[d-1]=t;
 			d--;
		}
  	}
	    return;
}

/**
 * Returns true if value is in array of n values, else false.
 */
bool search(int value, int values[], int n)
{
  	int first = 0;
   	int last = n;
  	int middle = (first+last)/2;
	int c=0;
 
   	while (first <= last) 
	{
      		if (values[middle] < value)
         	{	first = middle + 1;	}    
      		else if (values[middle] == value) 
		{
         		c++;
			break;
      		}
      		else
         	{	last = middle - 1;}
 			middle = (first + last)/2;
   	}
   	if (first >last)
     	{	return false;	}
	else if(c!=0)
	{	return true;	} 
	else
	   {    return false;   }
}
