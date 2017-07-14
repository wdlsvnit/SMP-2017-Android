/**
 * generate.c
 *
 * Generates pseudorandom numbers in [0,MAX), one per line.
 *
 * Usage: generate n [s]
 *
 * where n is number of pseudorandom numbers to print
 * and s is an optional seed
 */
 
#define _XOPEN_SOURCE

#include <cs50.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// upper limit on range of integers that can be generated
#define LIMIT 65536

int main(int argc, string argv[])
{
    // If one or two arguments are not passed while running the program,it will
//    show how the program should be given inputs and thus ends the program immediately..
    if (argc != 2 && argc != 3)
    {
        printf("Usage: ./generate n [s]\n");
        return 1;
    }

    // argv is a string, so the string argv[1] is converted to int data type for further 
    // execuation of program..
    int n = atoi(argv[1]); 

    // The second argument is converted to int data type and srand48 function is used to 
    // create randomness in the output. Bigger the value passed in argv[2], higher will be the 
    //randomness in the output. If argv[2]==0, then everytime same numbers are generated
    //as previos output if the argv[1] is same everytime..
    if (argc == 3)
    {
        srand48((long) atoi(argv[2]));
    }
    else
    {
        srand48((long) time(NULL));
    }

    //drand48() creates random floating numbers between 0.0 and 1.0 therefore it is
    // multiplied by the limit and converted to int data type by (int);
    //and as loop is iterated n times, n random numbers between 0 and LIMIT
    //is generated and printed...
    for (int i = 0; i < n; i++)
    {
        printf("%i\n", (int) (drand48() * LIMIT));
    }

    // success
    return 0;
}
