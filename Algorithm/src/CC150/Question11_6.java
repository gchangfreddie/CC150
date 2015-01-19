package CC150;

public class Question11_6 {
	public static void main(String[] args){
		int[][] a = new int[4][5];

		a = build(4, 4); 
		print (a); 
		System.out.println(findE(a, 7));
	}
	
	public static Coord findE(int[][] ma,int x) {
		Coord o = new Coord(0, 0), d = new Coord(ma.length-1, ma[0].length-1); 
		return findE(ma, o, d, x);
	}
	
	public static Coord findE(int[][] ma, Coord o, Coord d, int x) {
		if (!o.inboounds(ma)|| !d.inboounds(ma)) return null; 
		if (ma[o.r][o.c]==x) 
			return o; 
		else if (!o.isBefore(d)) return null; 
		
		Coord s = (Coord)o.clone(); 
		int dis = Math.min(d.r- o.r, d.c-o.c); 
		Coord e = new Coord(s.r+dis, s.c + dis), p = new Coord(0,  0); 
		
		while (s.isBefore(e)) {
			p.setToAve(s, e);
			if (x>ma[p.r][p.c]) {
				s.r =p.r +1; 
				s.c = p.c+1; 
			} else {
				e.r = p.r-1; 
				e.c = p.c-1; 
			}
				
		}
		return pAndS(ma, o, d, s, x); 
	}
	
	public static  Coord pAndS(int[][] ma, Coord o, Coord d, Coord p, int e) {
		Coord llo = new Coord(p.r, o.c), lld = new Coord(d.r,  p.c-1), uro = new Coord(o.r,  p.c), urd = new Coord(p.r-1, d.c); 
		Coord ll = findE(ma, llo,  lld,  e); 
		if (ll == null) return findE(ma, uro, urd, e); 
		return ll; 
	}
	
	
	public static int[][] build (int ii, int jj) {
		int[][] temp = new int[ii][jj]; 
		for (int i = 0; i<ii; i++) {
			int t =1; 
			for (int j=0 ; j<jj;  j++) {
				temp[i][j] = i+t; 
				t++; 
			}
		}
		return temp;
	}

	private static void print(int[][] a) {
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

}

class Coord implements Cloneable{
	public int r, c; 
	public Coord(int r, int c) {
		this.r = r; 
		this.c = c; 
	}
	
	public boolean inboounds(int[][] ma) {
		return r>=0 && c>=0 && r<ma.length && c<ma.length; 
	}
	
	public boolean isBefore(Coord p) {
		return r <=p.r && c <=p.c; 
	}
	
	public Object clone(){
		return new Coord(r, c); 
	}
	
	public void setToAve(Coord min, Coord max) {
		r = (min.r + max.r) /2; 
		c = (min.c + max.c)/2; 
	}
	
	public String toString() {
		return r + " " + c; 
	}
}
