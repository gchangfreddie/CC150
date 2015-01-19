package data.structure.OOD;

import java.util.*;

public class Question8_1 {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>(); 
		list.add(12); list.add(1); list.add(3); list.add(12); list.add(1); list.add(12); 
		getScore(list); 
		
	}
	
	public static int getScore(List<Integer> l) {
		List<Integer> scores = possibleScores(l); 
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (int score : scores) {
			if (score>maxUnder && score<=21) maxUnder=score; 
			else if (score<minOver) minOver=score;
		}
		return maxUnder==Integer.MIN_VALUE ? minOver : maxUnder; 
	}
	
	private static List<Integer> possibleScores(List<Integer> cards){
		List<Integer> res = new ArrayList<Integer>(); 
		res.add(0);
		for (Integer c : cards){
			List<Integer> temp = new ArrayList<Integer>(res); 
			res.clear(); 
			if (c!=1) {
				for (Integer i : temp){
					if (c<11) i+=c; 
					else i+=10; 
					res.add(i); 
				}
			} else {
				for (Integer i : temp) {
					res.add(i+1); 
					res.add(i+11); 
				}
			}
		}
		return res; 
	}
}

abstract class Deck {
	ArrayList<Card> cardsList; 
	
	abstract public void shuffle() ; 
	
	
}


abstract class Card {
	Suit suit; 
	int value; 
	
	public int getValue() {
		return value; 
	}
}

class BlackCard extends Card{
	public int getValue() {
		/**
		 *  we need customize the value for J, Q, K and Ace. 
		 *  if Ace we need return 1 and do a special process in handler.score method
		 */
		
		return value; 
	}
}

class Hand<T extends Card> {
	List<Card> cards;
	
	public int getScore() {
		List<Integer> scores = possibleScores(); 
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (int score : scores) {
			if (score>maxUnder && score<=21) maxUnder=score; 
			else if (score<minOver) minOver=score;
		}
		return maxUnder==Integer.MIN_VALUE ? minOver : maxUnder; 
	}
	
	private List<Integer> possibleScores(){
		List<Integer> res = new ArrayList<Integer>(); 
		res.add(0);
		for (Card c : cards){
			if (c.value!=1) {
				for (Integer i : res){
					if (c.value<11) i+=c.value; 
					else i+=10; 
				}
			} else {
				for (Integer i : res) {
					Integer temp = new Integer(i); 
					temp+=11; 
					res.add(temp); 
					i+=1; 
				}
			}
		}
		return res; 
	}
	
	public void add(Card c) {
		cards.add(c); 
	}
	
}

enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value; 
	private Suit(int v) {
		value = v; 
	}
	public int getValue() {
		return value; 
	}
}