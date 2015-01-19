package moderate;

import java.util.Hashtable;

public class CountWord {
	
	public Hashtable<String, Integer> buildHT(String[] book) {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>(); 
		for (String word : book) {
			word = word.toLowerCase(); 
			if (!table.containsKey(word)) {
				table.put(word, 0); 
			}
			table.put(word, table.get(word)+1); 
		}
		return table; 
	}
	
	public int freq(String word, Hashtable<String, Integer> HT) {
		word = word.toLowerCase(); 
		if (HT.containsKey(word)) {
			return HT.get(word); 
		}
		return 0; 
	}
	
	public static void main(String[] args) {
		CountWord cw = new CountWord(); 
		String[] book = new String[]{"grace", "chang", "Cindy", "Xinyi", "Li", "google", "Grace", "Zillow", "Yahoo", "Grace"}; 
		 
		System.out.println(cw.freq("grace", cw.buildHT(book)));
	}
}
