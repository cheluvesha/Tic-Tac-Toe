// Welcome to TicTacToe 

import java.util.*;

class TicTacToe {

	//declaring a gobal tic tac toe board
	private static ArrayList<ArrayList<String> > board;

	//Method to initialise board
	public static void initBoard() {
		board = new ArrayList<ArrayList<String> >();
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
	}

	public static void main(String[] args) {

		initBoard();
		System.out.println(board);

	}
}
