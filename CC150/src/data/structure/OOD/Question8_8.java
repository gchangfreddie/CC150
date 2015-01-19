package data.structure.OOD;

import java.awt.*; 
import java.util.*;

public class Question8_8 {

}

enum Direction{
	left, right, top, bottom; 
}

enum Color {
	White, Black; 
}

class Game{
	Player[] players; 
	Board board; // board should have Row and Column, and board can compute the score
	private static Game gameInstance; 
	
	private Game() {
		board = new Board(10, 10); 
		players = new Player[2]; // must first initialize array before set value for it's items
		players[0] = new Player("p1", Color.Black); 
		players[1] = new Player("p2", Color.White); 
	}
	
	public static Game getInstance() {
		if (gameInstance == null) {
			gameInstance = new Game(); 
		}
		return gameInstance; 
	}
	
	public Board getBoard() {
		return board; 
	}
}

class Player{
	String name; 
	Color color; 
	
	Player(String n, Color c) {
		name = n; 
		color = c; 
	}
	
	/**
	 * this is important, we init the play action from player, then go to board to place piece and flip the colors
	 * @param r
	 * @param c
	 */
	public void playPiece(int r, int c) {
		Game.getInstance().getBoard().addPiece(new Piece(color), r, c); 
	}
}

class Board{
	Piece[][] disks; 
	int row, col; 
	LinkedList<Piece> whitePieceList; 
	LinkedList<Piece> blackPieceList; 
	
	Board(int r, int c) {
		row = r; 
		col = c; 
		whitePieceList = new LinkedList<Piece>(); 
		blackPieceList = new LinkedList<Piece>(); 
		disks = new Piece[r][c]; 
	}
	
	public void addPiece(Piece p, int r, int c) {
		disks[r][c] = p; 
		if (p.color == Color.White) {
			whitePieceList.add(p); 
		} else {
			blackPieceList.add(p); 
		}
		flipNeighbors(p, r, c); // should do it in board, because we will do multiple pieces, if we put it Piece class, each time we need go back
		// here to update disks and white/black List
	}
	
	/**
	 * for each p's neighbor q, if it has diff color with p, check its neighbors in straight direction,
	 * if that neighbors has same color with p, should flip q's color and update white/black list
	 */
	private void flipNeighbors(Piece p, int r, int c) {
		
	}
	
	public int getSocre(Color c) {
		if (c==Color.Black) return blackPieceList.size(); 
		return whitePieceList.size(); 
	}
	
}

class Piece{
	Color color; 
	
	Piece(Color c) {
		color = c; 
	}

	public void flip(){
		if (color == Color.Black) color = Color.White; 
		else color = Color.Black; 
	}
	
}