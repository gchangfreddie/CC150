package data.structure.LinkedList;

public class Question2_4_2 {
	public static void main(String[] args) {
		LinkedListNode lln = new LinkedListNode("h"); 
		lln.add(new LinkedListNode("G")); 
		lln.add(new LinkedListNode("F"));
		lln.add(new LinkedListNode("E"));
		lln.add(new LinkedListNode("D"));
		lln.add(new LinkedListNode("C"));
		lln.add(new LinkedListNode("B"));
		LinkedListNode node = new LinkedListNode("A"); 
		lln.add(node);
		
		LinkedListNode res  = quickSort(lln, "E"); 
		print(res); 
	}
	
	public static void print(LinkedListNode head){
		while (head!=null) {
			System.out.print(" "+head.data);
			head = head.next; 
		}
		System.out.println();
	}
	
	public static LinkedListNode quickSort(LinkedListNode l, String v) {
		LinkedListNode beHead = null, beEnd = null, afterHead = null, afterEnd = null; 
		
		while(l !=null) {
			LinkedListNode next = l.next; 
			l.next = null; 
			if (l.data.compareTo(v)<0) {
				if (beHead== null) {
					beHead = l; beEnd = l; 
				} else {
					beEnd.next = l;
					beEnd = l; 
				}
			} else {
				if (afterHead == null) {
					afterHead = l; afterEnd = l;
				} else {
					afterEnd.next = l; 
					afterEnd = l; 
				}
			}
			l = next; 
		}
		if (beHead == null) return afterHead; 
		else {
			if (afterHead == null) return beHead; 
			else {
				beEnd.next = afterHead; 
				return beHead; 
			}
		}
	}
	
	public static LinkedListNode qSort(LinkedListNode l, String v) {
		LinkedListNode beHead = null, afterHead = null; 
		
		while(l !=null) {
			LinkedListNode next = l.next; 
			if (l.data.compareTo(v)<0) {
				l.next = beHead; 
				beHead = l; 
			} else {
				l.next = afterHead; 
				afterHead = l;
			}
			l = next; 
		}
		if (beHead == null) return afterHead; 
		else {
			if (afterHead != null) {
				LinkedListNode res = beHead; 
				while(beHead.next != null) {
					beHead = beHead.next; 
				}
				beHead.next = afterHead; 
			}
			return beHead;
		}
	}
	
 }
