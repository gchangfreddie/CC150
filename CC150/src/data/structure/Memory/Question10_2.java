package data.structure.Memory;

import java.util.*;

public class Question10_2 {

}

class Server{
	HashMap<Integer, Machine> idToMachine = new HashMap<Integer, Machine>(); 
	HashMap<Integer, Integer> personIDToMachineID = new HashMap<Integer, Integer>(); 
	
	public Machine getMachine(int id) { 
		return idToMachine.get(id); 
	}
	
	public int getMachineID(int personID) {
		Integer machineID = personIDToMachineID.get(personID);
		if (machineID == null) return -1; 
		return machineID; 
	}
	
	public Person getPerson(int personID){
		return getMachine(getMachineID(personID)).getPerson(personID); 
	}
}

class Machine{
	int ID;
	HashMap<Integer, Person> idToPerson = new HashMap<Integer, Person>(); 
	Machine(int id) {
		ID = id; 
	}
	
	public Person getPerson(int id){
		return idToPerson.get(id); 
	}
}

class Person{
	int ID;
	List<Integer> friends = new ArrayList<Integer>(); 
	
	Person(int id) {
		ID = id; 
	}
	
	public void addFriends(int id) {
		friends.add(id);
	}
		
}