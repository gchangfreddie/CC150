package data.structure.moderate;

public class TictacToe {
	char[][] board = new char[3][3];
	
	enum Piece {Empty, Red, Blue}; 
	
	public boolean isWon(char label) {
		for (int i=0; i<3; i++) {
			int j=0; 
			for (; board[i][j] == label && j<3; j++) {
			}
			if (j==3) return true; 
		}
		for (int j=0; j<3; j++) {
			int i=0; 
			for (; board[i][j]==label && i<3; i++) {
			}
			if (i==3) return true; 
		}
		if (board[1][1]!=label) return false; 
		else {
			if (board[0][0]==label && board[2][2]==label) return true;
			else if (board[0][2]==label && board[2][0]==label) return true;
			else return false; 
		}
	}
	
	public char isWon(char[][] board) {
		int len = board.length; 
		for (int i=0; i<len; i++) {
			if (board[i][0]!=' ') {
				int j=1;
				for (; j<len; j++) {
					if (board[i][j]!=board[i][j-1]) break; 
				}
				if (j==len) return board[i][0]; 
			}
		}
		
		for (int j=0; j<len; j++) {
			if (board[0][j]!=' ') {
				int i=1; 
				for (; i<len; i++) {
					if (board[i][j]!=board[i-1][j]) break;
				}
				if (i==len) return board[0][j]; 
			}
		}
		if (board[0][0]!=' ') {
			int i=1; 
			for (;i<len; i++) {
				if (board[i][i]!=board[i-1][i-1]) break;
			}
			if (i==len) return board[0][0]; 
		}
		if (board[len-1][0] !=' '){
			int i=1; 
			for (; i<len; i++) {
				if (board[len-1-i][i]!=board[len-i][i-1]) break;
			}
			if (i==len) return board[len-1][0]; 
		}
		return ' '; 
	
	}
}
