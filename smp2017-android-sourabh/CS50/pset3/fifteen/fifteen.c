/**
 * fifteen.c
 *
 * Implements Game of Fifteen (generalized to d x d).
 *
 * Usage: fifteen d
 *
 * whereby the board's dimensions are to be d x d,
 * where d must be in [DIM_MIN,DIM_MAX]
 *
 * Note that usleep is obsolete, but it offers more granularity than
 * sleep and is simpler to use than nanosleep; `man usleep` for more.
 */
 
#define _XOPEN_SOURCE 500
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// constants
#define DIM_MIN 3
#define DIM_MAX 9

// board
int board[DIM_MAX][DIM_MAX];

// blank tile
int blankrow,blankcolumn;

//given tile
int tilerow,tilecolumn;

// dimensions
int d;

// prototypes
void clear(void);
void greet(void);
void init(void);
void draw(void);
int move(int tile);
int won(void);

int main(int argc, char **argv)
{
    // ensure proper usage
    if (argc != 2)
    {
        printf("Usage: fifteen d\n");
        return 1;
    }

    // ensure valid dimensions
    d = atoi(argv[1]);
    int i,j;
    if (d < DIM_MIN || d > DIM_MAX)
    {
        printf("Board must be between %i x %i and %i x %i, inclusive.\n",
            DIM_MIN, DIM_MIN, DIM_MAX, DIM_MAX);
        return 2;
    }

    // open log
    FILE *file = fopen("log.txt", "w");
    if (file == NULL)
    {
        return 3;
    }

    // greet user with instructions
    greet();

    // initialize the board
    init();

    // accept moves until game is won
    while (1)
    {
        // clear the screen
        clear();

        // draw the current state of the board
        draw();

        // log the current state of the board (for testing)
        for (i = 0; i < d; i++)
        {
            for (j = 0; j < d; j++)
            {
                fprintf(file, "%i", board[i][j]);
                if (j < d - 1)
                {
                    fprintf(file, "|");
                }
            }
            fprintf(file, "\n");
        }
        fflush(file);

        // check for win
        if (won())
        {
            printf("ftw!\n");
            break;
        }

        // prompt for move
        printf("Tile to move: ");
        int tile ;
	scanf("%d",&tile);
        
        // quit if user inputs 0 (for testing)
        if (tile == 0)
        {
            break;
        }

        // log move (for testing)
        fprintf(file, "%i\n", tile);
        fflush(file);

        // move if possible, else report illegality
        if (!move(tile))
        {
            printf("\nIllegal move.\n");
            usleep(500000);
        }

        // sleep thread for animation's sake
        usleep(500000);
    }
    
    // close log
    fclose(file);

    // success
    return 0;
}

/**
 * Clears screen using ANSI escape sequences.
 */
void clear(void)
{
    printf("\033[2J");
    printf("\033[%d;%dH", 0, 0);
}

/**
 * Greets player.
 */
void greet(void)
{
    clear();
    printf("WELCOME TO GAME OF FIFTEEN\n");
    usleep(2000000);
}

/**
 * Initializes the game's board with tiles numbered 1 through d*d - 1
 * (i.e., fills 2D array with values but does not actually print them).  
 */
void init(void)
{  // intializing in descending order
    int k =d*d-1,i,j;
    for(i =0 ;i<d;i++)
       {
           for( j =0;j<d;j++)
             {
                 board[i][j] = k;
                  k--;
              }
           
       }
    // changing 1 & 2 if even 
     if (d%2==0)
     { k = board[d-1][d-2];
     board[d-1][d-2]= board[d-1][d-3];
     board[d-1][d-3]=k;
     }
}

/**
 * Prints the board in its current state.
 */
void draw(void)
{
    // TODO prints board
    int i,j;
    for( i =0 ;i<d;i++)
       {
           for(j =0;j<d;j++)
             {   
                 if(board[i][j]==0)
                  {
                      printf("  _ ");
                      blankrow=i;
                      blankcolumn=j;
                  }
                  else 
                  printf(" %2d ",board[i][j]);

             }
           printf("\n");
       }
      
      
      
    
}

/**
 * If tile borders empty space, moves tile and returns true, else
 * returns false. 
 */
int move(int tile)
{  int temp,i,j; //temporary variable

    // TODO moving tile by determining its positiong with no. given
     for(i =0 ;i<d;i++)
       {
           for( j =0;j<d;j++)
                 if(board[i][j]==tile)
                  {  tilerow=i;
                     tilecolumn=j;
                     temp=1;
                     break;
                  }
               
          if(temp==1)  
          break;
          
       }
       
      
       if(tilerow==blankrow)
       { 
           if (tilecolumn==blankcolumn-1 || tilecolumn == blankcolumn+1 )
          
             { temp=board[tilerow][tilecolumn];
              board[tilerow][tilecolumn] = board[blankrow][blankcolumn];
              board[blankrow][blankcolumn]=temp;
            return 1;              
          
             }
                 
      }
          
       if(tilecolumn==blankcolumn)
       { 
           if (tilerow==blankrow-1 || tilerow == blankrow+1 )
          
             { temp=board[tilerow][tilecolumn];
              board[tilerow][tilecolumn] = board[blankrow][blankcolumn];
              board[blankrow][blankcolumn]=temp;
            return 1;              
          
             }
                 
      }
       
       
    
    
    return 0;
}

/**
 * Returns true if game is won (i.e., board is in winning configuration), 
 * else false.
 */
int won(void)
{
    int k = 1,i,j;//temp variable
    int m =0;
     // TODO check if won
    
     for(i =0 ;i<d;i++)
       {
           for(j =0;j<d;j++)
             {   
                if(board[i][j]==k )
                   {
                       k++;
                    }
                else
                {
                    m++;
                    break;
                }
              }
          if(m>0)
          break;
       }
       
    if(k==(d*d))
    return 1;
    else
    return 0;
}
