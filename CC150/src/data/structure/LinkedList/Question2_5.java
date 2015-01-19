package data.structure.LinkedList;

public class Question2_5 {
	public LinkedListNode solution(LinkedListNode s1, LinkedListNode s2) {
		if (s1 == null ) return s2; 
		if (s2 == null) return s1; 
		
		int ou=0; 
		LinkedListNode s3 = null, t = null; 
		
		while(s1!=null && s2!=null) {
			int in = (s1.d + s2.d + ou) % 10;
			ou = (s1.d + s2.d + ou) / 10; 
			LinkedListNode temp = new LinkedListNode(in); 
			if (s3==null) {
				s3=temp; 
			} else {
				t.next = temp; 
			}
			t = temp; 
			s1 = s1.next; 
			s2 = s2.next;
		}
		if (s1!=null) {
			while(s1!=null) {
				int in = (s1.d+ou)%10; 
				ou = (s1.d  + ou) / 10;
				LinkedListNode temp = new LinkedListNode(in); 
				t.next = temp; 
				t = temp; 
				s1 = s1.next; 
			}
		}
		if (ou > 0) {
			t.next = new LinkedListNode(ou); 
		}
	
		return s3;
	}
	public static void main(String[] args) {

		LinkedListNode s1 = new LinkedListNode(4); 
		s1.add(new LinkedListNode(8)); 
		s1.add(new LinkedListNode(7));
		s1.add(new LinkedListNode(9));
		LinkedListNode s2 = new LinkedListNode(3); 
		s2.add(new LinkedListNode(5)); 
		s2.add(new LinkedListNode(9));
		
//		while(s1!=null) {
//			System.out.print(s1.d+ " ");
//			s1=s1.next; 
//		}
//		System.out.println(); 
//		while(s2!=null) {
//			System.out.print(s2.d+ " ");
//			s2=s2.next; 
//		}
//		System.out.println(); 
		
		Question2_5 q = new Question2_5(); 
		LinkedListNode s3 = q.solution1(s1, s2, 0); 
		while(s3!=null) {
			System.out.print(s3.d+ " ");
			s3=s3.next; 
		}
}

	public LinkedListNode solution1(LinkedListNode s1, LinkedListNode s2, int ca) {
		if (s1==null&& s2==null && ca==0) return null; 
		int d1 = s1!=null ? s1.d : 0; 
		int d2 = s2!=null ? s2.d : 0; 
		int data = (d1+d2+ca) % 10; 
		int c = (d1+d2+ca) / 10; 
		
		LinkedListNode s3 = new LinkedListNode(data); 
		s3.next = solution1(s1!= null ? s1.next : null, s2!= null ? s2.next: null, c); 
		return s3; 
	}
	
	public LinkedListNode followUp(LinkedListNode s1, LinkedListNode s2) {
		if (s2 == null && s1 == null) return null; 
		if (s1 == null) return s2;
		if (s2 == null) return s1; 
		int len1=0, len2=0;
		LinkedListNode n1=s1, n2=s2, n3=null; 
		while(n1!=null) {
			n1=n1.next; len1++; 
		}
		while(n2!=null) {
			n2 = n2.next; len2++;
		}
		// when len1 == len2
		while(s1!=null) {
			int d =(s1.d+s2.d) % 10;  
			int ca = (s1.d+s2.d) /10;
			n3 = new LinkedListNode(d); 
			PartialSum p =  add(s1.next, s2.next); 
		}
		return null; 
		
	}
	
	private PartialSum add(LinkedListNode s1, LinkedListNode s2){
		if (s2 == null && s1 == null) return null; 
		PartialSum p = null; 
		while(s1!=null) {
			int d =(s1.d+s2.d) % 10;  
			int ca = (s1.d+s2.d) /10;
			LinkedListNode node = new LinkedListNode(d); 
			p = new PartialSum(node); 
			p.ca = ca;
		}
		return p; 
	}
}

class PartialSum{
	LinkedListNode n; 
	int ca; 
	
	public PartialSum(LinkedListNode n) {
		this.n = n; 
	}
}