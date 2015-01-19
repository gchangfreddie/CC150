package data.structure.moderate;
import java.util.*;
public class GameMasterMind {

	public static int[] findHitPHit(String guess, String solution){
		int hit=0, phit=0; 
		char[] g= guess.toCharArray(), so = solution.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i=0; i<4; i++){
			if (g[i]==so[i]) {
				hit++; 
				g[i]=' '; 
				so[i]=' '; 
			} else {
				if (!map.containsKey(so[i])) map.put(so[i], 1); 
				else map.put(so[i], map.get(so[i])+1); 
			}
		}
		for (int i=0; i<4; i++){
			if (g[i]!=' ' ){
				if (map.containsKey(g[i])) {
					if (map.get(g[i])==1) map.remove(g[i]); 
					else map.put(g[i], map.get(g[i])-1); 
					phit++; 
				}
 			}
		}
		int[] res = new int[]{hit, phit} ;
		return res;
	}
	
	public static void main(String[] args){
		int[] res = findHitPHit("GGRR", "RGBY"); 
		System.out.println("hit is " + res[0] + " p hit is "+ res[1]);
	}
}
