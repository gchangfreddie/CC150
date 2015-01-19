package data.structure.Recursion;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Question9_11 {
	public static int f(String exp, boolean res) {
		int resNum = 0; 
		if (!(exp.contains("^") | exp.contains ("&") | exp.contains("|"))) {
			if (res){
				return exp=="1" ? 1 : 0; 
			} else {
				return exp=="0" ? 1 : 0; 
			}
		} else {
			String[] strings = exp.split("\\&|\\||\\^"); 
			//			String[] strings = Pattern.compile("\\&|\\||\\^").split(exp);  // the same result as above line
			for (int i=0; i<strings.length; i++) {
				System.out.print(strings[i] + "   ");
			}
		}
		return resNum; 
	}

	public static void main(String[] args){
		System.out.println(func("1&0^1|1", true, 0, 6)); 
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		System.out.println(funcDP("1&0^1|1", true, 0, 6, map)); 
		
		String s = new String ("grace"); 
		System.out.println(s.matches("a.*ce")); 
	}

	public static int func(String exp, boolean res, int s, int e) {
		if (s==e) {
			if( (res && exp.charAt(s) == '1') || (!res && exp.charAt(s) =='0') ) return 1; 
			else return 0; 
		} else {
			int c=0; 
			if (res) {
				for (int i=s+1; i<e; i+=2) {
					char  op = exp.charAt(i); 
					switch (op) {
					case '&': 
						c+=func(exp, res, s, i-1) * func(exp, res, i+1, e); 
						break; 
					case '|':
						c+=func(exp, res, s, i-1) * func(exp, res, i+1, e);
						c+=func(exp, false, s, i-1) * func(exp, res, i+1, e);
						c+=func(exp, res, s, i-1) * func(exp, false, i+1, e);
						break;
					case '^': 
						c+=func(exp, false, s, i-1) * func(exp, res, i+1, e); 
						c+=func(exp, res, s, i-1) * func(exp, false, i+1, e);
					}
				}
			} else {
				for (int i=s+1; i<e; i+=2) {
					char  op = exp.charAt(i); 
					switch (op) {
					case '|': 
						c+=func(exp, res, s, i-1) * func(exp, res, i+1, e); 
						break; 
					case '&':
						c+=func(exp, res, s, i-1) * func(exp, res, i+1, e);
						c+=func(exp, true, s, i-1) * func(exp, res, i+1, e);
						c+=func(exp, res, s, i-1) * func(exp, true, i+1, e);
						break;
					case '^': 
						c+=func(exp, res, s, i-1) * func(exp, res, i+1, e); 
						c+=func(exp, true, s, i-1) * func(exp, true, i+1, e);
					}
				}
			}
			return c; 
		}

	}

	public static int funcDP(String exp, boolean res, int s, int e, HashMap<String, Integer> map) {
		String key = ""+ s+e+res;
		if (map.containsKey(key))
			return map.get(key); 
		
		if (s==e) {
			if( (res && exp.charAt(s) == '1') || (!res && exp.charAt(s) =='0') ) return 1; 
			else return 0; 
		} else {
			int c=0; 
			if (res) {
				for (int i=s+1; i<e; i+=2) {
					char  op = exp.charAt(i); 
					switch (op) {
					case '&': 
						c+=funcDP(exp, res, s, i-1,map) * funcDP(exp, res, i+1, e,map); 
						break; 
					case '|':
						c+=funcDP(exp, res, s, i-1,map) * funcDP(exp, res, i+1, e,map);
						c+=funcDP(exp, false, s, i-1,map) * funcDP(exp, res, i+1, e,map);
						c+=funcDP(exp, res, s, i-1, map) * funcDP(exp, false, i+1, e, map);
						break;
					case '^': 
						c+=funcDP(exp, false, s, i-1, map) * funcDP(exp, res, i+1, e, map); 
						c+=funcDP(exp, res, s, i-1, map) * funcDP(exp, false, i+1, e,map);
					}
				}
			} else {
				for (int i=s+1; i<e; i+=2) {
					char  op = exp.charAt(i); 
					switch (op) {
					case '|': 
						c+=funcDP(exp, res, s, i-1,map) * funcDP(exp, res, i+1, e, map); 
						break; 
					case '&':
						c+=funcDP(exp, res, s, i-1, map) * funcDP(exp, res, i+1, e, map);
						c+=funcDP(exp, true, s, i-1, map) * funcDP(exp, res, i+1, e, map);
						c+=funcDP(exp, res, s, i-1, map) * funcDP(exp, true, i+1, e, map);
						break;
					case '^': 
						c+=funcDP(exp, res, s, i-1, map) * funcDP(exp, res, i+1, e, map); 
						c+=funcDP(exp, true, s, i-1, map) * funcDP(exp, true, i+1, e, map);
					}
				}
			}
			map.put(key,c); 
			return c; 
		}
	}
}