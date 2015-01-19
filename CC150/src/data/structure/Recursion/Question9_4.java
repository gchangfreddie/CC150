package data.structure.Recursion;

import java.util.*;

public class Question9_4 {
	static Set<Set<String>> res = new HashSet<Set<String>>(); 
	
	public static Set<Set<String>> getSubSet(String[] set, int index) {
		Set<Set<String>> result ; 
		if (set.length == index) {
			result = new HashSet<Set<String>>(); 
			result.add(new HashSet<String>()); 
		} else {
			result = getSubSet(set, index+1);
			Iterator<Set<String>> it = result.iterator();
			String str = set[index]; 
			Set<Set<String>> temp = new HashSet<Set<String>>(); 	
			
			while (it.hasNext()){
				Set<String> hs = new HashSet<String>(); 
				hs.add(str); 
				hs.addAll(it.next()); 
				temp.add(hs);
			}	
			
			//merge temp and res
		    result.addAll(temp); 
		}
		return result; 	
	}
	
	public static void main(String[] args){
		ArrayList<String> set =  new ArrayList<String>(); 
		set.add("Grace");
		set.add("X"); 
		set.add("W"); 
		set.add("T"); 
		set.add("F"); 
		String[] array = (String[])set.toArray(new String[5]); //new String[6] is necessary, otherwise will have compile error
//		res = getSubSet(array, 0); 
		res = getSubSetBit(array); 
		System.out.println(res.size());
		System.out.println(Integer.toBinaryString(10).toCharArray()); 
		
		for (Set<String> s: res) {
			Iterator<String> it = s.iterator(); 
			while (it.hasNext()){
				String st = it.next();
				System.out.print(st + "\t");
			}
			System.out.println();
		}
		System.out.println(res.size());
	}
	
	public static Set<Set<String>> getSubSetBit(String[] set) {
		int size = 1<<set.length; 
		Set<Set<String>> result = new HashSet<Set<String>>(); 
		for (int i=0; i<size; i++) {
			Set<String> item = new HashSet<String>(); 
			int index = 0; 
			for (int j=i; j>0; j>>=1) {
				if ((j&1)==1 ) {
					item.add(set[index]); 
				}
				index++; 
			}
			result.add(item); 
		}
		return result; 
	}
}
