package data.structure.Math;

public class Question7_4 {
	public static int substraction(int m, int n){
		return m+negate(n); 
	}
	
	private static int negate(int m) {
		if (m==0) return 0; 
		int d = (m<0) ? 1 : -1; 
		int neg = 0; 
		while (m!=0) {
			neg +=d; 
			m +=d; 
		}
		return neg; 
 	}
	
	public static int multiplication(int m, int n) {
		if (m==0 || n==0) return 0; 
		if (m<n) return multiplication(n, m); 
		int res =0; 
		for (int i=0;i<abs(n); i++) {
			res+=m; 
		}
		if (n<0) res = negate(res); 
		return res; 
	}
	
	private static int abs(int n) {
		if (n>=0) return n;
		return negate(n); 
	}
	
	public static int division(int m, int n) {
		if (m==0 || n == 0) return 0; 
		int i=0; 
		int absm = abs(m),absn = abs(n); 
		while (absm>=absn) {
			absm=substraction(absm, absn);
			i++; 
		}
		if ((m<0&&n<0) || (m>0&&n>0)) {
			return i; 
		} else {
			return negate(i); 
		}
	}
	
	public static int div(int m, int n) {
		if (n==0) System.err.println("Error");
		if (m==0 ) return 0;
		
		int product=0, x=0; 
		while ((product+abs(n))<=abs(m)) {
			product += abs(n); 
			x++;
		}
		if ((m<0&&n<0) || (m>0&&n>0)) {
			return x; 
		} else {
			return negate(x); 
		}
	}
	
	public static void main(String[] args) {
		System.out.println(division(100, -50) + "  " +div(100, -50) +" " +  100/-50);
		System.out.println(substraction(46, -3));
		System.out.println(multiplication(-3, -16));
	}
	
}
