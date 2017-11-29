import java.util.*; 
/* 
CSCI 3200
Assignment: 1
Author:     Ashley Fraley
File:       hailstone.java
Tab stops:  3

Description: Prints the entire hailstone sequence starting with n. Gives the length of
the hailstone sequence starting at n. Returns the largest integer of the sequence. 
Also returns the longest hailston sequence starting with a number up to n and the length.
*/

public class hailstone
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What number shall I start with?");
    int n = keyboard.nextInt();
    System.out.println("The hailstone sequence starting at " + n + " is:");
    sequence(n);
    System.out.println("");
    System.out.println("The length of the sequence is " + length(n) + ".");
    System.out.println("The largest number in the sequence is " + max(n) + ".");
    System.out.println("The longest hailstone sequence starting with a number up to " + n + " has length " + longestLength(n));
  }
    
    
//Next method:
//Returns x which is the next integer after n in the hailstone sequence
   
  public static int next(int n)
  { 
    int x = 0;
    if(n%2 == 0)
    {
     x = n/2;
    }
    else
    {
     x = (3*n)+1;
    }
    return x;
  }
    
    
//Sequence method:
// Prints out the hailstone sequence starting with n 
    
  public static void sequence(int n)
  {
    int z = n;
    System.out.print(z + " ");
    while (z > 1)
    {
      z = next(z);
      System.out.print(z + " ");
    }
  }
   
    
//Length method:
// Returns the length of the hailstone sequence starting with n
    
    public static int length(int n)
    {
      int m = 1;
      int z = n;
      while (z > 1)
      {
        z = next(z);
        m++;
      }
      return m;
    }
    
    
//Max method:
// Returns z as the max of the hailstone sequence
    
    public static int max(int n)
    {
      int z = n;
      int x = n;
      while(x>1)
      {
        x = next(x);
        if(x>z)
        {
          z = x;
        }
      }
      return z;
    }

    
//longestLength:
// Returns the length of the longest hailstone sequence starting at 
// a number from 1 to n    
    
    public static int longestLength(int n)
    {
      int z = length(n);
      int m = z;
      for( int i = 1; i<=n; i++)
      {
        int y = length(i);
        if(y>m)
        {
          m = y;
        }
      }
      return m;
    }   
}
