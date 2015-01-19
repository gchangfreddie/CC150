package CC150;

import java.util.*;
public class Question10_7 {

}


class HashList<K,V>{
	LinkedList<K> keyList; 
	HashMap<K,V> itemMap; 
	int max ; 
	int size ; 
	
	HashList(int capacity) {
		keyList = new LinkedList<K>(); 
		itemMap = new HashMap<K, V>(capacity); 
		max = capacity; size = 0; 
	}
	
	public V findQuery(K k){
		if (keyList.contains(k)) {
			// put k in the front of keylist
			return itemMap.get(k); 
		}
		
		// load from machine and put to the front of keylist and itemMap, if necessary clean keyList
		return null; 
	}
	
	public void remove(K k) {
		keyList.remove(k); 
		itemMap.remove(k); 
	}
	
	public void clean() {
		K k = keyList.removeLast(); 
		itemMap.remove(k); 
	}
}