/*
 		       CSCI 3200
Author: 	    Ashley Fraley
Assignment:  5
File: 	    ShortestPath.java
Tab stops:	 3
Description: It shows the graph then computes the 
shortest from the start vertex to the end vertex. 
*/
import java.util.*;
import java.util.PriorityQueue;

class Graph
{
	private PairList [] adj; //array of pairList

//Constructor:
//Initializes the adj [] but setting each pairlist to equal emptylist
	public Graph(int vertex)
	{
		adj = new PairList[vertex+1];
      for(int i = 0; i < adj.length; i++)
      { 
         adj[i] = new PairList();
      }
	}

//Accessor:
//getAdjacentList:
//Returns the adjacenct list for the vertex v

	public PairList getAdjacentList(int v)
	{
		return adj[v];
	}
	
//Instance Methods:
//insert:
//Adds an edge between u and v, of weight w

   public void insert(int u, int v, double w)
	{
	   adj[u] = adj[u].addToFront(v,w);
		adj[v] = adj[v].addToFront(u,w);
	}

/* 
show:
Prints out all the adjacent lists with the help of 
my function showPairList
*/
	public void show()
	{
		int length = adj.length;
		System.out.printf("There are %d vertices. The adjacency lists are as follows.\n", length-1);
		for(int i = 1; i <length; i++)
		{	
         System.out.printf("Vertex %d \n",i);
			showPairList(adj[i], i);
		} 
	}

//showPairList:
//This is a helper function for my show function
//it makes formating the output of the pairlist easier

	private void showPairList(PairList L, int u)
	{
		PairList rest = L;
		while(!rest.isEmpty())
		{
			int v = rest.headVertex();
			double w = rest.headWeight();	
         //if(v > u)
         //{	   
            System.out.printf("to %d, weight %f\n",v,w);
         //}         
         rest = rest.tail();
		}
	}
}

class Event implements Comparable<Event>
{
   private int vertex;
   private double time;

//Constructor:
   public Event(int v, double t)
   {
      vertex = v;
      time = t;
   }

//Accessor:

//getVertex:
//Returns vertex
   public int getVertex()
   {
      return vertex;
   }  

//getTime:
//Returns time
   public double getTime()
   {
      return time;
   }

//Instance Method:

//compareTo:
//Returns the time difference between events
   public int compareTo(Event d)
   {
      double t = d.getTime();
      double s = time;
      
      return (int)(s-t);
   }
}


public class ShortestPath
{  
	private static Graph g;
	private static double [] distance;
	private static PriorityQueue <Event> eventQueue;
	private static int start;
   private static int end;

   public static void main(String[] args)
	{
      Scanner keyboard = new Scanner(System.in);
      int vertex = keyboard.nextInt();
      g = new Graph(vertex);
		distance = new double [vertex+1];
      eventQueue = new PriorityQueue<Event>();
		g = readGraph(keyboard);
      start = keyboard.nextInt();
      end = keyboard.nextInt();
      keyboard.close();
		g.show();
      eventQueue.add(new Event(start,0));
      eventMaker();
      double d = distance[end];
      System.out.println("The shortest distance from " + start + " to " + end + " is " + d + ".");
	}

/*
readGraph:
Reads in a graph starting at the first line containing 
the number of vertices and ending after it has read the 0 
at the end. It returns a graph
*/
	static Graph readGraph(Scanner keyboard)
	{
      for(int i = 1; i < distance.length; i++)
      {
         distance[i] = -1;
      }
      while(keyboard.hasNext())
		{
        int u = keyboard.nextInt();
        if(u == 0)
        {
            break;
        }
        else
        {
            int v = keyboard.nextInt();
            double w = keyboard.nextDouble();
            //System.out.printf("Read Graph to %d, weight %f\n",v,w); 
            g.insert(u,v,w);
        }
		}
		return g;
	}

/*
sendSignal:
Find the adjacent vertexs of v and 
creates events for each one
*/
   static void sendSignals(int v, double t)
   {
      PairList next = g.getAdjacentList(v);
      while(!next.isEmpty())
      {
         int u = next.headVertex();
         double w = next.headWeight();
         Event m = new Event(u,t+w); 
         eventQueue.add(m);
         next = next.tail();
      }
   }
/*
sendSignals:
Sends a signal and if the vertex has an unknown
distance then is will set the distance at
the vertex to equal time. Then it will run 
sendSignals
*/
   static void sendSignal(Event e)
   {
      int v = e.getVertex();
      double t = e.getTime();
      sendSignals(v,t);
      if(distance[v] == -1)
      {  
         distance[v] = t;
      }
   }

/*
eventMaker:
Pulls out events one at a time and processes
them until the end vertex has a known distance
*/
   static void eventMaker()
   {
      Event m = eventQueue.poll();
      while(distance[end] == -1)
      {
         sendSignal(m);
         m = eventQueue.poll();
      }
   }
}
