//package Assignment4;

import java.io.*;

//---------------------------------------------------
// Class list contains functions that work on lists.
// A list has type ListCell.  For example,
//
//   ListCell a = List.addToFront(4, List.emptyList);
//
// makes a = [4], using conceptual notation.
//---------------------------------------------------

public class List
{
    //--------------------------------------
    //              emptyList
    //--------------------------------------
    // emptyList is an empty list.
    //--------------------------------------

    public static ListCell emptyList;

    static
    {
	emptyList = null;
    }

    //-----------------------------------------------
    //              isEmpty
    //-----------------------------------------------
    // isEmpty(L) returns true if L is an
    // empty list.
    //-----------------------------------------------

    public static boolean isEmpty(ListCell L)
    {
	return L == emptyList;
    }

    //-----------------------------------------------
    //              head
    //-----------------------------------------------
    // head(L) returns the first member of
    // list L.
    //
    // Requirement: L must be nonempty.
    //-----------------------------------------------

    public static int head(ListCell L)
    {
	return L.item;
    }

    //-----------------------------------------------
    //              tail
    //-----------------------------------------------
    // tail(L) returns the list obtained by
    // removing the head of list L.
    //
    // Requirement: L must be nonempty.
    //-----------------------------------------------

    public static ListCell tail(ListCell L)
    {
	return L.next;
    }

    //-----------------------------------------------
    //              addToFront
    //-----------------------------------------------
    // addToFront(x,L) returns the list obtained
    // by adding x to the front of list L.
    //
    // Important: This function does not change L.
    //-----------------------------------------------

    public static ListCell addToFront(int x, ListCell L)
    {
	return new ListCell(x, L);
    }

    //-----------------------------------------------
    //              length
    //-----------------------------------------------
    // length(L) returns the number of items
    // that L has.
    //-----------------------------------------------

    public static int length(ListCell L)
    {
	if(L == null)
	{
	    return 0;
	}
	else
	{
	    return 1 + length(tail(L));
	}
    }

    //-----------------------------------------------
    //              reverse
    //-----------------------------------------------
    // reverse(L) returns the reversal of
    // list L.
    //
    // Important: This function does not change L.
    //-----------------------------------------------

    public static ListCell reverse(ListCell L)
    {
	ListCell rest = L;
	ListCell ans  = emptyList;
	while(rest != emptyList) 
	{
	    ans  = addToFront(head(rest), ans);
	    rest = tail(rest);
	}
	return ans;
    }

    //------------------------------------------------
    //              printList
    //------------------------------------------------
    // printList(F,L) prints list L on print
    // stream F.  To print L on the standard
    // output, use
    //    List.printList(System.out, L);
    //
    // This function does not print a newline character.
    //------------------------------------------------

    public static void printList(PrintStream F, ListCell L)
    {
	ListCell t, rest;

	F.print("[");
	for(rest = L; rest != emptyList; rest = tail(rest))
	{
	    F.print(head(rest));
	    t = tail(rest);
	    if(t != emptyList) 
	    {
		F.print(",");
	    }
	}
	F.print("]");
    }
  
}


//---------------------------------------------------
// An object of class ListCell is a single cell
// in a linked list.  The empty list is represented
// by null.
//---------------------------------------------------

class ListCell
{
    public int      item;
    public ListCell next;

    public ListCell(int i, ListCell n)
    {
	item = i;
	next = n;
    }
}
