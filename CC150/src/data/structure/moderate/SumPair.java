package data.structure.moderate;

import java.util.*;

public class SumPair {
	public static List<Integer[]> findAllPair(int[] array, int sum) {
		List<Integer[]> list = new ArrayList<Integer[]>(); 
		if (array==null || array.length<=1) return list; 
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>(); 
		for (int i=0; i<array.length; i++) {
			int key = sum -array[i];
			if (!ht.containsKey(array[i])) {
				ht.put(key, i); 
			} else {
				Integer[] res = new Integer[]{array[i], array[ht.get(array[i])]};
				list.add(res); 
			}
		}
		return list; 
	}
	
	public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2]; 
        if (numbers==null || numbers.length==0) {
            return res; 
        }
        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>(); 
        for (int i=0; i<numbers.length; i++) {
            if (ht.containsKey(numbers[i])) {
                return new int[]{ht.get(numbers[i]), i}; 
            } else {
                ht.put(target-numbers[i], i); 
            }
        }
        return res;
    }
	
	public static List<Integer[]> findPair(int[] array, int sum){
		List<Integer[]> list = new ArrayList<Integer[]>(); 
		if (array==null || array.length<=1) return list; 
		Arrays.sort(array); 
		int s=0, e=array.length-1; 
		while(s<e){
			int tempSum = array[s] + array[e]; 
			if (tempSum<sum) s++; 
			else if (tempSum>sum) e--; 
			else {
				Integer[] res = new Integer[]{array[s], array[e]}; 
				list.add(res); 
				s++; e--; 
			}
		}
		return list; 
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{9,22,16,-3,-5,3,6,-7,10}; 
		List<Integer[]> res = findAllPair(array, 17); 
		for (Integer[] i : res) {
			for (int j=0; j<2; j++) {
				System.out.print(i[j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		List<Integer[]> res1 = findPair(array, 17); 
		for (Integer[] i : res1) {
			for (int j=0; j<2; j++) {
				System.out.print(i[j]+ " ");
			}
			System.out.println();
		}
	}
}
