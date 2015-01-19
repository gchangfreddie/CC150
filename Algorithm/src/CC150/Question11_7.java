package CC150;

public class Question11_7 {

	public static void main(String[] args) {
		Person[] pa = new Person[]{new Person(5,6), new Person(31,33),
				new Person(14,8), new Person(15,18), new Person(4,2), new Person(25,28)}; 
		int max =0; 
		for (int i=0; i<pa.length; i++) {
			int temp = getTower(pa, i); 
			if (temp>max) max=temp; 
		}
		System.out.println(max);
		System.exit(0);
	}
	
	public static int getTower(Person[] pa, int i) {
		Person pi = pa[i]; 
		int maxH = 0; 
		for (int j=0; j<pa.length; j++) {
			Person p = pa[j]; 
			if (pi.compareTo(p)==1) {
				int h = getTower(pa, j ); 
				if (h> maxH) maxH= h; 
			}
		}
		return maxH+1; 
	}
}

class Person implements Comparable<Object> {
	int l, w; 
	public int compareTo(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o ; 
			if (p.l < l && p.w<w) return 1;
			else return -1;
		}
		return -1; 
	}
	
	public Person(int l, int w) {
		this.l = l;
		this.w = w; 
	}
}
