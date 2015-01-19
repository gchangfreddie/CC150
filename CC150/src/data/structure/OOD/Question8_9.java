package data.structure.OOD;

import java.util.ArrayList;

public class Question8_9 {

	public static void main(String[] args) {
		Entry home = new Directory("home", null) ; //Please remember we could not instantiate an abstract class. 
		
		Entry child = new File("child", (Directory)home); 
		
		System.out.println(home.name);
		
	}
}

abstract class Entry{
	public String name; 
	private int size; 
	private Entry parent; 
	private long createdTime; 
	private long lastModified;
	private long lastAccessed; 
	
	public Entry(String name, Directory p){
		this.name = name; 
		this.parent = p; 
		if (p!=null) p.add(this); 
		long curTime = System.currentTimeMillis();
		createdTime = curTime; 
		lastAccessed = curTime; 
		lastModified = curTime; 
	}
	
}

class Directory  extends Entry {
	private ArrayList<Entry> content = new ArrayList<Entry>(); 
	
	public Directory(String n, Directory p) { // we must have a constructor since there is default non-arg constructor in super class
		super(n, p); 
	}
	
	void add(Entry e) {
		content.add(e); 
	}
}

class File extends Entry {
	public File(String n, Directory p) {
		super(n, p); 
	}
}
