package data.structure.Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Question1 {

	public static void main(String[] args) {
		int i; 
		for (i=2; i>=0; --i) {
			System.out.printf("%d\n", i);
		}
		LinkedList<String> myLinkedList = new LinkedList<String>(); 
		myLinkedList.add("two");
		myLinkedList.addFirst("one");
		Iterator<String> iter = myLinkedList.iterator();
		try {while (iter.hasNext()) 
			System.out.print(iter.next()+ " ");
			System.exit(0); 
			}
//		catch(Exception e) {}
		finally{
			System.out.println("finally");
		}
		ArrayList<String> a = new ArrayList<String>(); 
		
	}
	
	public int comput(String s) {
		return 1;  
	}
	
	public int comput(double s) {
		return -1; 
	}
}
