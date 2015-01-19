package data.structure.OOD;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Question8_3 {

}

class JukeBox{
	private CDPlayer cdPlayer; 
	private Selector selector; 
	private HashMap<Song, CD> cdCollection; 
	
	public void handleRequest(Song song) {
		CD cd = cdCollection.get(song); 
		
		cdPlayer.add(cd, song); 
	}
	
}

class CDPlayer{
	CD currentCD; 
	List<Song> playList = new LinkedList<Song>(); 
	
	void playSong(Song s){
		playList.remove(0); 
	}
	
	void add(CD cd, Song s) {
		playList.add(s); 
	}
	
}

class Selector{
	Song song; 
	
	Song pickSong(CD cd) {
		return song; 
	}
}

class CD{
	String name; 
	List<Song> songs; 
}

class Song{
	String name; 

}