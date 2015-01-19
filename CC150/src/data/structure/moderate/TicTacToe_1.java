package data.structure.moderate;

public class TicTacToe_1 {
	public Color hasWon(Color[][] board){
		int n=board.length;
		//check row 
		for (int i=0; i<n; i++){
			if (!board[i][0].color.equals("")) {
				int j=1; 
				for (; j<n; j++) {
					if (board[i][j] != board[i][j-1]) break; 
				}
				if 	(j==n) return board[i][0]; 
			}
		}
		//check column
		for (int i=0; i<n; i++) {
			if (!board[0][i].color.equals("")) {
				int j=1; 
				for (; j<n; j++) {
					if (board[j][i]!=board[j-1][i]) break;
				}
				if (j==n) return board[0][i]; 
			}
		}
		// check diagonal
		if (!board[0][0].color.equals("")) {
			int i=1; 
			for (; i<n; i++) {
				if (board[i][i]!=board[i-1][i-1]) break; 
			}
			if (i==n) return board[0][0]; 
		}
		if (!board[n-1][0].color.equals("")) {
			int i=1; 
			for (; i<n; i++){
				if (board[n-i-1][i]!=board[n-i][i-1]) break;
			}
			if (i==n) return board[n-1][0]; 
		}
		return null; 
	}
	
	class Color {
		String color; 
		public Color(String s){
			color=s;
		}
		public boolean equals(Object c){
			return ((Color)c).color.equals(color); 
		}
	}
}
