package data.structure.moderate;

import java.util.Iterator;

public class IterableClass<T> implements Iterable<T> {

	public Iterator<T> iterator() {
		Integer[] a = new Integer[3]; 
		return  new IteratorClass<T>(a); 
	}

	public static void main(String[] args) { 
	}

}

class IteratorClass<T> implements Iterator<T>{
	int i; 
	Integer[] array; 

	public IteratorClass(Integer[] a) {
		array = a; 
	}

	public boolean hasNext() {
		return i<array.length; 
	}

	@SuppressWarnings("unchecked")
	public T next() {
		return (T)array[i++];
	}

	public void remove() {
		i--; 
	}

}

