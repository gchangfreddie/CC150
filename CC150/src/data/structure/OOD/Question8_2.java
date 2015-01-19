package data.structure.OOD;

import java.util.*;

public class Question8_2 { 

}

class CallCenter{ 
	/**
	 * keep each level employee a dependent queue availabeRepQueue
	 * So we have an List of size 3, 0 res, 1 manager, 2 director
	 */
	/** 
	 * keep each call a dependent queue incomingCallQueue
	 * So we have an List of size 3, each call first is 0, can raise to 1 and so on to 2
	 */
	
	
	public void dispatchCall(Call c) {
		Employee rep = getHandler(c); 
		if (rep!= null) {
			/**
			 * remove the rep from the available queue
			 */
			if (rep.answerCall(c)){
				;
			} else {
				getHandler(c).answerCall(c); 
			}
			answerNextCall(); 
		} else {
			/**
			 * put the call to the corresponding call Queue; 
			 */
		}
	}
	
	private Employee getHandler(Call c) {
		/**
		 * According to c's level we get the employee from the corresponding emp Queue. If the Queue is null, return null
		 * otherwise pop the first one from the Queue
		 */
		return null; 
	}
	
	private void answerNextCall() {
		/**
		 * get a call from call queue 0, 
		 */
	}
	
}

abstract class Employee{
	String name; 
	int level; 
	boolean availabel; 
	
	public boolean answerCall(Call c) {

		if (level >= c.getLevel()) {
			return true;
		} else {
			passCall(c); 
			return false; 
		}
}	

	
	abstract public void passCall(Call c) ; 
		
}

class Call{
	int level;
	String name; 
	
	Call(String user) {
		name = user; 
		level = 0; 
	}
	
	public int getLevel() {
		return level; 
	}
	
	public void setLevel(int l) {
		level = l; 
	}
	
	public String getName() {
		return name; 
	}
}