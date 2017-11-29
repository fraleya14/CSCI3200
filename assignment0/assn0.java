// Author:     Karl Abrahamson
// Assignment: 0
// File:       assn0.java
// Tab stops:  none

// This program shows the greatest common divisor
// of two numbers that are read from the user.
import java.util.Scanner;

public class assn0
{
    //===========================================
    //             gcd
    //===========================================
    // gcd(a,b) returns the greatest common
    // divisor of a and b.
    //===========================================

    public static long gcd(long a, long b)
    {
	if(a == 0)
	    {
		return b;
	    }
	else
	    {
		return gcd(b % a, a);
	    }
    }

    //===========================================
    //               main
    //===========================================
    
    public static void main(String[] argv)
    {
	long a, b;
	Scanner keyboard = new Scanner(System.in);
    
	System.out.print("gcd of which two numbers? ");
	a = keyboard.nextLong();
	b = keyboard.nextLong();
	System.out.printf("The gcd of %d and %d is %d\n", a, b, gcd(a,b));
    }
}
