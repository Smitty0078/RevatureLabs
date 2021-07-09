package com.michael.test;

import java.util.ArrayList;
import java.util.Iterator;
import com.michael.model.Item;


public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item(1, "This is item 1"));
        items.add(new Item(2, "This is item 2"));
        items.add(new Item(3, "This is item 3"));
        items.add(new Item(4, "This is item 4"));
        items.add(new Item(5, "This is item 5"));
        
        System.out.println(items.get(2));
        
        Item removed = items.remove(items.size()-1);
        System.out.println(removed);
        
        printList(items);
        
        iteration(items);
        System.out.println(items.size());
        
        
       
	}
	
	public static void iteration(ArrayList<Item> items)
	{
		//iterating over a list
	       Iterator<Item> iter = items.iterator();
	       while (iter.hasNext()) {
	         Item item = iter.next();
	         System.out.println("removing item: " + item);
	         iter.remove();
	         //iter.remove();
	         //items.add(new Item(6, "this is a new item"));
	       }
	}
	
	public static void printList(ArrayList<Item> items)
	{
		System.out.println("--- Printing ---");
		for(int i = 0; i < items.size(); i++)
	        {
	        	System.out.println(i);
	        }
	}

}
