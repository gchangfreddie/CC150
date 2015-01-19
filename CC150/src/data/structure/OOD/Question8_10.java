package data.structure.OOD;

import java.util.LinkedList;

public class Question8_10 {

	public static void main(String[] args) {
		HashTable ht = new HashTable(10); 
		
		Item item = new Item("13"); 
		
		ht.insert(item);
		
		System.out.println("done");
	}
}

class HashTable<K, V>{
	LinkedList<Item<K, V>>[] table; 
	int capability; 
	
	HashTable(int n) {
		capability = n; 
		table =(LinkedList<Item<K, V>>[]) new LinkedList[n]; // we could not create a generic array of LinkedList. That is a java flaw/feature. 
		//so we have to cast it.
	}
	
	public void insert(Item e) {
		LinkedList<Item<K, V>> list = table[e.hashCode()]; 
		if (list == null) {
			list = new LinkedList<Item<K, V>>(); 
			/**
			 * if at first, the list is null, we have to save it back to table
			 */
			table[e.hashCode()] = list; 
		}
		/**
		 * we need check the list's existing items to find the same-key item and replace it. If not we can add it directly.
		 */
		list.add(e); 
		
	}
	
	public boolean remove(String key){
		boolean res = false; 
		int index = Integer.parseInt(key) % 10 ; 
		if (table[index] == null) return res; 
		LinkedList<Item<K,V>> list = table[index]; 
		for (Item<K, V> item : list) {
			if (item.key.equals(key)) {
				list.remove(item); 
				res = true; 
				break; 
			}
		}
		return res;
	}
}

class Item<K, V>{
	String key; 
	
	Item(String n) {
		key = n; 
	}
	
	public int hashCode() {
		return Integer.parseInt(key) % 10; 
	}
}