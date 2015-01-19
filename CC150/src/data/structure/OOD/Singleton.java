package data.structure.OOD;

public class Singleton {

	private static Singleton s = null; // can't get s by using Singleton.s since s is private, the only way is to call Singleton.getSingleton
	
	private Singleton() {}
	public static Singleton getSingleton() { // must be static, because we could not get an instance by calling constructor
		if (s== null) {
			s = new Singleton(); 
		}
		return s; 
	}
}
