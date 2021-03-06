import java.util.*; 
/* 
CSCI 3200
Assignment: 2
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
//Returns x which follows after n in the hailstone sequence

 public static int next(int n)
  { 
    int x = 0;
    if(n%2 == 0)
     {
       return n/2;
     }
     else
     {
       return (3*n)+1;
     }
 }
    
    
//Sequence method:
// Prints out the hailstone sequence starting with n 
    
  public static void sequence(int n)
  {    
    int x = n;
    if(n == 1)
    {
       System.out.print(1);
    }
    else
    { 
       System.out.print(n + " "); 
       sequence(next(x)); 
    }
  }
    
    
//Length method:
//Returns the length of the hailstone sequence starting with n
  public static int length(int n)
  {
    int w = n;
    if(w == 1)
    {
      return 1;
    } 
    else
    {
      return 1 + length(next(w));
    }
  }

//Max method:
//Returns the max of the hailstone sequence
  public static int max(int n)
  {
    int x = next(n);
    if(x == 1)
    {
      return 1;
    }
    return Math.max(n,max(x));
  }

    
//longestLength:
//Returns the length of the longest hailstone sequence starting at 
//a number from 1 to n    
  public static int longestLength(int n)
  {
    int m = n - 1;
    if(n == 1)
    {
      return n;
    }
    return Math.max(length(n),longestLength(m));
  }
}