package data.structure.Java;

import java.util.Iterator;;

// Iterable: Implementing this interface allows an object to be the target of the "foreach" statement.
public class CircularArray <V> implements Iterable<V>{
	private V[] array; 
	private int offset = 0; 
	private int len; 
	
	public CircularArray(int size) {
		array = (V[])new Object[size];
		len = size; 
	}
	
	public void rotate(int i) {
		offset = convert(i);
	}
	
	public V get(int index) {
		return array[convert(index)]; 
	}

	private int convert(int index) {
		return (index+offset)%len;
	}
	
	public void set(int i, V item) {
		array[convert(i)] = item; 
	}
	
	public Iterator<V> iterator() {
		return new CircularArrayIterator<V>(this); 
	}
	
	private class CircularArrayIterator<T> implements Iterator<T>{
		private T[] array; 
		private int index = -1; 
		
		public CircularArrayIterator(CircularArray<T> v){
			array= v.array; 
		}
		
		@Override
		public boolean hasNext() {
			return index<array.length-1; 
		}
		
		@Override
		public T next() {
			index++; 
			return array[convert(index)]; 
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) {
		CircularArray<Integer> q = new CircularArray<Integer>(9); 
		q.set(0, 0); q.set(1, 1); 
		q.set(2, 2); q.set(3, 3); 
		q.set(4, 4); q.set(5, 5); 
		q.set(6, 6); q.set(7, 7); 
		q.set(8, 8);
		q.rotate(3);
		q.rotate(4); 
		
		for (Integer i : q) { // "foreach" first call iterator() method, then use hasNext() and next()
			System.out.print(" " + i);
		}
		System.out.println();
		
		System.out.println(q.get(6));
	}

}
