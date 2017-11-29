//Author:     Ashley Fraley 
//Assignment: 3
//File:       search.java
//Tab Stops:

//Description:

import java.util.*;
import java.io.*;

public class search
{
 public static void main(String[] args)
 {
    int n = args.length;
    //Scanner p = new Scanner(System.in);
    String pattern; 
    File filename;
    if(n > 0)
    {
      for(int i = 1; i < n; i++)
      {
        pattern = args[0];
        filename = new File(args[i]);
        showFile(pattern,filename); 
      }
    }
    else 
    {
      System.out.println("Need a pattern");
    }
 }

 
//Matches:
//Takes in pattern and line. Returns true if pattern occurs in line.
//Returns false if not.
  static boolean matches(String pattern, String line)
  {
    Scanner n = new Scanner(line);
    while(n.hasNext())
    {
      String s = n.next();
      if(s.equalsIgnoreCase(pattern))
      {
        return true;
      }
    }
    return false; 
  }


//showFile:
//Takes the pattern and the name of a file.
  static void showFile(String pattern, File filename)
  {
    try 
    {
      Scanner k = new Scanner(filename);
      int count = 1;
      int m = 0;
      while(k.hasNextLine())
      {
        String line = k.nextLine();
        if(matches(pattern,line))
        {
          if(m == 0)
          {
            System.out.println(filename + ":");
            System.out.println(count + ". " + line);
            m++;
          }
          else
          {
            System.out.println(count + ". " + line);
            m++;
          }
        }
        count++;
      }
      k.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Can not open " + filename.getName());
    }
  }
}
