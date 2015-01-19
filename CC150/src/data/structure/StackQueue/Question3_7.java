package data.structure.StackQueue;
/**
 * LinkedList has many useful API, such as get(i), getFirst, getLast, addLast, addFirst, pollFirst, pollLast. 
 */
import java.util.LinkedList;

public class Question3_7 {
	LinkedList<Animal> aQueue = new LinkedList<Animal>(); 
	LinkedList<Dog> dogQueue = new LinkedList<Dog>(); 
	LinkedList<Cat> catQueue = new LinkedList<Cat>(); 
	
	public void enqueue(Animal a) {
		aQueue.addLast(a); 
		if (a instanceof Dog) {
			dogQueue.addLast((Dog)a); 
		} else if (a instanceof Cat) {
			catQueue.addLast((Cat)a); 
		}
	}
	
	public void save(Animal a) {
	}
	
	public void save(Dog g) {
	}
	
	public void save(Cat c) {
	}
	
	public Animal dequeueAny() {
		Animal out = aQueue.poll(); 
		if (out instanceof Dog) {
			dogQueue.pollFirst(); 
		} else {
			catQueue.removeFirst(); 
		}
		return out; 
	}
	
	public Dog dequeueDog() {
		Dog out =dogQueue.pop(); 
		if (out != null) {
			for (int i =0; i<aQueue.size(); i++){
				if (aQueue.get(i) instanceof Dog ) {
					aQueue.remove(i); 
					break; 
				} 
			}
		}
		return out; 
	}
	
	public Cat dequeueCat() {
		Cat out =catQueue.pop(); 
		if (out != null) {
			for (int i =0; i<aQueue.size(); i++){
				if (aQueue.get(i) instanceof Cat ) {
					aQueue.remove(i); 
					break; 
				} 
			}
		}
		return out; 
	}

public static void main(String[] args) {
	Question3_7 q = new Question3_7(); 
	
	q.enqueue(new Dog("a"));
	q.enqueue(new Cat("1")); 
	q.enqueue(new Dog("b"));
	q.enqueue(new Cat("2")); 
	q.enqueue(new Dog("c"));
	q.enqueue(new Cat("3")); 
	q.enqueue(new Dog("d"));
	q.enqueue(new Dog("e")); 
	
	System.out.println(q.dequeueAny().name);
	System.out.println(q.dequeueDog().name);
	System.out.println(q.dequeueDog().name);
	System.err.println(q.dequeueAny().name);
	
	q.print(q.aQueue);
	q.print(q.catQueue); 
	q.print(q.dogQueue);
	
}

private void print(LinkedList l) {
	for (int i =0; i<l.size();i++) {
		System.out.print("  " + ((Animal)l.get(i)).name);
	}
	System.out.println();
}
}

class Animal{
	String name; 
	int arrivalTime; 
	
	Animal(String name) {
		this.name = name; 
	}
}

class Dog extends Animal implements Animals{
	Dog(String name) {
		super(name);
	}
}

class Cat extends Animal implements Animals{
	Cat(String name) {
		super(name); 
	}
}

