import java.util.*;
import java.lang.Math.*;

public class EditDistance2
{
   public static void main(String[] args)
   {
      Scanner k = new Scanner(System.in);
      String s = k.nextLine();
      String t = k.nextLine();
      int m = s.length()-1;
	   int n = t.length()-1;
	   int[][] distance = new int[m + 1][n + 1];
      System.out.println("The edit distance between " + '"' + s + '"' + " and " + '"' + t + '"' + " is " + d(s,t,m,n) + ".");
   }
   public static int minNum(int x, int y, int z)
   {
      return Math.min(Math.min(x,y),z);
   }
   public static int d(String s, String t, int m, int n)
   {
	   if(m==0)
	   {
	      return n;
	   }
	   if(n==0)
	   {
	      return m;
	   }   
	   if(s.charAt(m) == t.charAt(n))
	   {
	      return d(s,t,m-1,n-1);
	   }
	   return 1 + minNum( d(s,t,m,n-1), d(s,t,m-1,n), d(s,t,m-1,n-1));
   }
 }
	
