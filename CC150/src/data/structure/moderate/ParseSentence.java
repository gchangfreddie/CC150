package data.structure.moderate;

import java.util.*;

public class ParseSentence {
	HashSet<String> dictionary = new HashSet<String>(); 
	//wordStart is the starting index we process, 
	//wordEnd is the end index for a word
	public int parseSimple(int wordStart, int wordEnd, String sentence, Hashtable<Integer, Integer> cache) {
		//base case 
		if (wordEnd>=sentence.length()) return wordEnd - wordStart; 
		if (cache.containsKey(wordStart)) return cache.get(wordStart); 
		String word = sentence.substring(wordStart, wordEnd+1); 
		//check whether word is a valid prefix in dictionary, return a boolean isValidPrefix
		int bestExact = parseSimple(wordEnd+1, wordEnd+1, sentence, cache); 
		if (!dictionary.contains(word)) bestExact+=word.length(); 
		
		int bestExtend = Integer.MAX_VALUE; 
		// if isValidPrefix is false, we will NOT do this. because this is to adjoin word with following characters. 
			bestExtend = parseSimple(wordStart, wordEnd+1, sentence, cache); 
		
		cache.put(wordStart, Math.min(bestExact, bestExtend)); 
		return cache.get(wordStart); 
	}
	
	public Result parse(int s, int e, String sentence, Hashtable<Integer, Result> cache) {
		if (e>=sentence.length()) return new Result(e-s, sentence.substring(s).toUpperCase()); 
		if (cache.containsKey(s)) return cache.get(s).clone(); 
		String word = sentence.substring(s, e+1); 
		Result bestExact = parse(e+1, e+1, sentence, cache);
		if (!dictionary.contains(word)) {
			bestExact.num +=word.length(); 
			bestExact.s = word.toUpperCase() + " " + bestExact.s; 
		}
		Result bestExtend = parse(s, e+1, sentence, cache); 
		Result best = bestExact.min(bestExact, bestExtend); 
		cache.put(s, best.clone());
		return best; 
	}
	
	public static void main(String[] args) {
		ParseSentence ps = new ParseSentence(); 
		ps.dictionary.add("this"); 
		ps.dictionary.add("is"); 
		ps.dictionary.add("a"); 
		ps.dictionary.add("we"); 
		ps.dictionary.add("some"); 
		ps.dictionary.add("awesome"); 
		ps.dictionary.add("me");
		ps.dictionary.add("say"); 
		Hashtable<Integer, Integer> cache = new Hashtable<Integer, Integer>(); 
		Hashtable<Integer, Result> c = new Hashtable<Integer, Result>(); 
		int res = ps.parseSimple(0, 0, "thatisawesome", cache);
		Result r = ps.parse(0, 0, "thatisawesome", c); 
		System.out.println(res);
		System.out.println(r.s);
	}
}

class Result extends Object{
	String s=""; 
	int num=Integer.MAX_VALUE; 
	
	Result(int n, String ss) {
		s=ss; 
		num=n; 
	}
	
	public Result clone() {
		return new Result(num, s);  
	}
	
	public Result min(Result r1, Result r2){
		if (r1==null) return r2; 
		if (r2==null) return r1; 
		return r1.num>r2.num? r2: r1;
	}
}
