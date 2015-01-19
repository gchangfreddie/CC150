package data.structure.moderate;

public class MasterMind {
	public static int[] findHit(String g, String s) { 
		StringBuffer sg = new StringBuffer(); 
		StringBuffer ss = new StringBuffer(); 
		int hit =0, phit=0;
		for (int i=0; i<s.length(); i++) {
			if (g.charAt(i)==s.charAt(i)){
				hit++; 
			} else {
				sg.append(g.charAt(i)); 
				ss.append(s.charAt(i)); 
			}
		}
		int i=0; 
		while(sg.length()>0){
			String c = sg.substring(i,i+1); 
			if (ss.indexOf(c)!=-1){
				phit++; 
				ss.delete(ss.indexOf(c), ss.indexOf(c)+1); 
			}
			sg.deleteCharAt(i); 
		}
		return new int[]{hit, phit};
	}
	
	public static void main(String[] args) {
		int[] res = findHit("YYYY", "RGGB");
		for (int i: res) {
			System.out.println(i);
		}
	}
	
}
