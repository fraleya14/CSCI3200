/* 
CSCI 3200
Assignment:  4
Author:      Ashley Fraley
File:        lis.java
Tab stops:   3
Description: Reads in an integer n and followed by a sequence 
of n positive integers. It will output the longest increasing 
subsequence of that sequence. 
*/

import java.util.*;

public class lis
{
    public static void main(String[] args)
    {
      Scanner m = new Scanner(System.in); 
      int n = m.nextInt();
      ListCell [] best = new ListCell[n+1];
      best[0] = List.emptyList;
      ListCell x = computeBis(best,n,m);
      showBis(x);
    }
    
//findBis:
//Returns k if the head of best[k] is less than v. Returns 0 if 
//no value is found    
   public static int findBis(ListCell [] best, int longest, int v)
   {
      int k = longest;
      while(k != 0)
      {
         if(List.head(best[k]) < v)
         {
            return k;
         }
         k--;
      }
      return 0; 
   }
    
    
//updateBis:
//The new value v is added to the array at k+1. Returns the new 
//value of longest. It returns k if k equals longest. It returns 
//longest if k is less than longest.   
    public static int updateBis(ListCell [] best, int longest, int v)
    {
      int k = findBis(best,longest,v);
      best[k+1] = List.addToFront(v,best[k]);
      if(k == longest)
      {
         return k+1;
      }
      else
      {
         return longest;
      }
    }
    
    
//computeBis:
//Returns the reversal of the longest list in best.    
    public static ListCell computeBis(ListCell [] best, int n, Scanner m)
    {
      Scanner s = m;
      int longest = 0;
      while(n != 0)
      { 
        int v = s.nextInt();
        longest = updateBis(best,longest,v);
        n--;
      } 
      s.close();
      ListCell z = List.reverse(best[longest]);
      return z;
    }
    
    
//showBis:
//Writes the values in ListCell x    
    public static void showBis(ListCell x)
    {
      List.printList(System.out,x);
      System.out.println(" ");
    }
}
