package com.find.a.job;

import java.util.ArrayList;

public class RadixSort {
 
    public void radixSort(int arr[], int maxDigits){
    	
    	ArrayList<Integer>[] bucket = (ArrayList<Integer>[])new ArrayList[10]; 
    	int exp =1; 
    	
    	for (int i=0; i<maxDigits; i++) {
    		for (int k=0; k<10; k++) bucket[k] = new ArrayList<Integer>(); 
    		for (int j=0; j<arr.length; j++) {
    			int n = (arr[j]/exp)%10; 
    			if (bucket[n] == null) bucket[n] = new ArrayList<Integer>(); 
    			bucket[n].add(arr[j]); 
    		}
    		int n=0; 
    		exp*=10; 
    		for (int k=0; k<10;k++) {
    			ArrayList<Integer> a = bucket[k]; 
    			if (a!=null && !a.isEmpty())  {
    				for (Integer num : a) {
    					arr[n++] = num; 
    				}
    				if (n>=arr.length) break; 
    			}
    		}
    	}
    	
        System.out.println("Sorted numbers");
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] +", ");
        }
    }
 
    public static void main(String[] argv){
        int n = 5;
        int arr[] = {134,42,22,31,53,104,8};
        new RadixSort().radixSort(arr, 3);
        System.exit(0);
    }
}