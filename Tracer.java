/* 
Author: Ashley Fraley

Program: Tracer.java

Description: Tracer class is for tracing purposes. So when you add a piece of code in your
program to help you figure out where the error is you can track it down more efficiently
as well as turn it on and off as you see fit. This way you can leave in your tracing while
also being able to turn it back on when needed.
*/

import java.util.*;

public class Tracer
{
   public boolean [] traceLevel; //traceLevel array is the different levels of tracing
   public Tracer()
   {
      traceLevel = new boolean[10];
      for(int i = 0; i < traceLevel.length; i++)
      { 
         traceLevel[i] = false;
      }
   }

//turnOnLevels:
//Set every level to true from 0 to the level you choose
   public void turnOnLevels(int level)
   { 
      for(int i = 0; i <= level; i++)
      {
         traceLevel[level] = true;
      }
   }

//turnOn:
//Set the level to true
   public void turnOn(int level)
   { 
      traceLevel[level] = true;
   }

//turnOffLevels:
//Set every level to false from 0 to the level you choose
   public void turnOffLevels(int level)
   { 
      for(int i = 0; i <= level; i++)
      {
         traceLevel[level] = false;
      }
   }

//turnOff:
//Set the level to false
   public boolean turnOff(int level)
   {
      return false;
   }
}
