import java.util.*;
/*
CSCI 3200
Assignment: Skyline
Authour:    Ashley Fraley
File:       Skyline.java
Tab Stops:  3

Description:

*/

public class Skyline
{
  public static void main(String [] args)
  {
    int [] Height = new int[1000];
    readInput(Height);
    writeOutput(Height);
  }

  
//readInput Method:
//Fills Height array with zeros
  
  static void readInput(int [] Height)
  {
    for(int i = 0; i < 1000; i++)
    {
      Height[i] = 0;
    }
    boolean ok = true;
    while(ok)
    {
      ok = readAndInstallLine(Height);
    }
  }

  
//readAndInstallLine Method: 
//Reads in input into the Height array line by line.
  
  static void readAndInstallLine(int [] Height)
  {
  
  }

  
//writeOutput:
//
  
  static void writeOutput(int [] Height)
  {
  
  }
}