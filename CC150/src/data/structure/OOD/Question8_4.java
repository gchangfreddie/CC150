package data.structure.OOD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Question8_4 {

}

enum vehicleSize{ small, middle, large}; 

class Vehicle {
	int size; 
	String license; 
	ParkingSpot sp; 
	
	Vehicle(int s, String lice) {
		this.size = s; 
		this.license= lice; 
	}
}

class ParkingSpot {
	vehicleSize size; 
	int position; 
	boolean isTaken; 
	
	ParkingSpot(int i) {
		position = i; 
		isTaken = false; 
	}
}

class ParkingLot{
	LinkedList<ParkingSpot> parkingSpotList; 
	int size; 
	HashMap<Vehicle, ParkingSpot> parkList; 
	int takenSpot ; 
	
	public int size() {
		return size; 
	}
	
	public ParkingLot(int size) {
		parkingSpotList = new LinkedList<ParkingSpot>(); 
		this.size = size;
		for (int i=0; i<size; i++) {
			parkingSpotList.add(new ParkingSpot(i)); 
		}
		parkList = new HashMap<Vehicle, ParkingSpot>(); 
		takenSpot = 0; 
	}; 
	
	public void handleRequest(Vehicle v) {
		if (takenSpot>=size) {
			System.out.println("no space");
			return; 
		}
		ParkingSpot p = parkingSpotList.removeFirst(); 
		p.isTaken = true;
		parkList.put(v, p); 
	}
	
	public void relese(Vehicle v, ParkingSpot p) {
		p.isTaken = false;
		parkList.remove(v); 
		parkingSpotList.addLast(p); 
	}
}