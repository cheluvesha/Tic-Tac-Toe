import java.util.*;

class TicTacToe {

	//declaring a gobal tic tac toe board and variables
	private static ArrayList<ArrayList<String> > board;
	private static ArrayList<Integer> cornerPosition; // to store corner position
	private static ArrayList<Integer> sidePosition; // // to store side position
	private static int whoseTurn = 0; // to monitor turns 1 --> player and 0 --> cpu
	private static int playerFlag = 1; // to check if player won(1) toss or cpu(0)
	private static String playerSymbol = ""; 
	private static String cpuSymbol = "";
	private static int isGameIsGoing = 1; // if 1 --> game is going and  0 --> end game

	//Method to initialise board
	public static void initBoard() {
		board = new ArrayList<ArrayList<String> >();
		board.add(new ArrayList<String>(Arrays.asList("1","2","3")));
		board.add(new ArrayList<String>(Arrays.asList("4","5","6")));
		board.add(new ArrayList<String>(Arrays.asList("7","8","9")));
	}

	public static void displayBoard() {
		System.out.println(board.get(0).get(0)+ " | " +board.get(0).get(1)+ " | " +board.get(0).get(2));
		System.out.println("----------");
		System.out.println(board.get(1).get(0)+ " | " +board.get(1).get(1)+ " | " +board.get(1).get(2));
		System.out.println("----------");
		System.out.println(board.get(2).get(0)+ " | " +board.get(2).get(1)+ " | " +board.get(2).get(2)+"\n");
	}

	//Method to choose who goes first
	public static void chooseFirst(int yourChoice) {
		int randomChoice = (int) Math.floor(Math.random()*10)%2+1;
		if (randomChoice == yourChoice) {
			whoseTurn = 1;
			System.out.println("You won the toss.");
		}
		else {
			whoseTurn =  0;
			System.out.println("CPU won the toss.");
		}
		chooseSymbol(whoseTurn);
	}

	//Secondary method to chooseSymbol method
	public static void secChooseSymbol(int userSymbolChoice) {
		if (userSymbolChoice == 1) {
				playerSymbol = "X";
				cpuSymbol = "O";
			}
			else {
				playerSymbol = "O";
				cpuSymbol = "X";
			}
	}

	//Method to choose symbol
	public static void chooseSymbol(int flag) {
		int userSymbolChoice;
		if (playerFlag == flag) {
			Scanner input = new Scanner(System.in);
			System.out.print("Select your symbol choice (1: X, 2: O): ");
			userSymbolChoice = input.nextInt();
			secChooseSymbol(userSymbolChoice);
		}
		else {
			userSymbolChoice = (int) Math.floor(Math.random()*10)%2+1;
			secChooseSymbol(userSymbolChoice);
		}
	}

	//Method perform first run of game
	public static void firstRun() {
		//take user input
		Scanner input = new Scanner(System.in);
		System.out.print("Select your toss choice (1:Head, 2:Tail): ");
		int userChoice = input.nextInt();
		chooseFirst(userChoice);
		System.out.println("Player symbol: "+playerSymbol+ "\nCPU Symbol : "+cpuSymbol+"\n");
		initBoard();
		System.out.println("Fresh Board:");
		displayBoard();
		System.out.println("----------------------------------------");
	}

	//Method to check row for win
	public static int checkRow() {
		int rowFlag = 0;
		if (board.get(0).get(0) == board.get(0).get(1) && board.get(0).get(1) == board.get(0).get(2))
			rowFlag = 1;
		else if (board.get(1).get(0) == board.get(1).get(1) && board.get(1).get(1) == board.get(1).get(2))
			rowFlag = 1;
		else if (board.get(2).get(0) == board.get(2).get(1) && board.get(2).get(1) == board.get(2).get(2))
			rowFlag = 1;
		return rowFlag;
	}

	//Method to check column for win
	public static int checkCol() {
		int colFlag = 0;
		if (board.get(0).get(0) == board.get(1).get(0) && board.get(1).get(0) == board.get(2).get(0))
			colFlag = 1;
		else if (board.get(0).get(1) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(1))
			colFlag = 1;
		else if (board.get(0).get(2) == board.get(1).get(2) && board.get(1).get(2) == board.get(2).get(2))
			colFlag = 1;
		return colFlag;
	}

	//Method to check diagonal for win
	public static int checkDia() {
		int diaFlag = 0;
		if (board.get(0).get(0) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(2))
			diaFlag = 1;
		else if (board.get(0).get(2) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(0))
			diaFlag = 1;
		return diaFlag;
	}

	//Method to check win or not
	public static int checkWin() {
		if (checkRow() == 1 || checkCol() == 1 || checkDia() == 1)
			return 1;
		else
			return 0;
	}

	//Method to check tie or not
	public static int checkTie() {
		int tieFlag = 0;
		if (board.get(0).get(0) != "1" && board.get(0).get(1) != "2" && board.get(0).get(2) != "3") {
			if (board.get(1).get(0) != "4" && board.get(1).get(1) != "5" && board.get(1).get(2) != "6") {
				if (board.get(2).get(0) != "7" && board.get(2).get(1) != "8" && board.get(2).get(2) != "9")
					tieFlag = 1;
			}
		}
		return tieFlag;
	}

	//Method to check game is going or not
	public static void checkGameIsGoing() {
		int winFlag = checkWin();
		int tieFlag = checkTie();
		if (winFlag == 1 || tieFlag == 1)
			isGameIsGoing = 0;
	}

	//Method to change player
	public static void changePlayer() {
		if (whoseTurn == 0)
			whoseTurn = 1;
		else
			whoseTurn = 0;
	}

	//Method to to check valid position entered by user
	public static int checkValidPosition(int positionValid) {
		int rowPosition = (int) Math.floor((positionValid-1)/3);
		int colPosition = (positionValid-1)%3;
		String strPos = Integer.toString((positionValid));
		if (board.get(rowPosition).get(colPosition).equals(strPos))
			return 1;
		else
			return 0;
	}

	//find winnig position in row
	private static int chooseInRow(String matchingSymbol) {
		int minTwoFlag;
		int position;
		ArrayList<Integer> rowSum = new ArrayList<Integer>(Arrays.asList(6,15,24));
		for (int row=0; row<3 ; row++) {
			position = rowSum.get(row);
			minTwoFlag = 2;
			for (int col=0; col<3 ; col++ ) {
				if (board.get(row).get(col).equals(matchingSymbol) && (minTwoFlag != 0)){
					position -= (row*3)+(col+1);
					--minTwoFlag;
				}
			}
			if ((minTwoFlag == 0)) {
				if (checkValidPosition(position) == 1)
					return position;
				else {
					minTwoFlag = 2;
					break;
				}
			}
		}
		return 0;
	}

	//find winning positon in column
	private static int chooseInColumn(String matchingSymbol) {
		int minTwoFlag;
		int position;
		ArrayList<Integer> columnSum = new ArrayList<Integer>(Arrays.asList(12,15,18));
		for (int col=0; col<3 ; col++) {
			minTwoFlag = 2;
			position = columnSum.get(col);
			for (int row=0; row < 3 ; row++ ) {
				if (board.get(row).get(col).equals(matchingSymbol) && (minTwoFlag != 0)){
					position -= (row*3)+(col+1);
					--minTwoFlag;
				}
			}
			if ((minTwoFlag == 0)) {
				if (checkValidPosition(position) == 1)
					return position;
				else {
					minTwoFlag = 2;
					break;
				}
			}
		}
		return 0;
	}

	//find winning positon in diagonal_1
	private static int chooseInDiagonal_1(String matchingSymbol) {
		int diagonalSum = 15;
		int minTwoFlag = 2;
		int position = diagonalSum;
		for (int row=0; row<3 ; row++) {
			if (board.get(row).get(row).equals(matchingSymbol) && (minTwoFlag != 0)){
				position -= (row*3)+(row+1);
				--minTwoFlag;
			}
		}
		if ((minTwoFlag == 0)) {
			if (checkValidPosition(position) == 1)
				return position;
		}
		return 0;
	}

	//find winning positon in diagonal_2
	private static int chooseInDiagonal_2(String matchingSymbol) {
		int col;
		int diagonalSum = 15;
		int minTwoFlag = 2;
		int position = diagonalSum;
		for (int row=0; row<3 ; row++) {
			col = 2-row;
			if (board.get(row).get(col).equals(matchingSymbol) && (minTwoFlag != 0)){
				position -= (row*3)+(col+1);
				--minTwoFlag;
			}
		}
		if ((minTwoFlag == 0)) {
			if (checkValidPosition(position) == 1)
				return position;
		}
		return 0;
	}

	//Method to check winning position
	public static int chooseWinningPosition(int turnMonitor){
		String matchSymbol;
		if (turnMonitor == 1)
			matchSymbol = playerSymbol;
		else
			matchSymbol = cpuSymbol;
		
		if (chooseInRow(matchSymbol) != 0)
			return chooseInRow(matchSymbol);
		else if (chooseInColumn(matchSymbol) != 0)
			return chooseInColumn(matchSymbol);
		else if (chooseInDiagonal_1(matchSymbol) != 0)
			return chooseInDiagonal_1(matchSymbol);
		else if (chooseInDiagonal_2(matchSymbol) != 0)
			return chooseInDiagonal_2(matchSymbol);
		else
			return 0;
	}

	//Method to manage player turn
	public static void manageTurn() {
		int valid = 0;
		if (whoseTurn == 1){
			System.out.println("Your turn : ");
			while (valid != 1){
				Scanner input = new Scanner(System.in);
				System.out.print("Select an empty position: ");
				int userPositionChoice = input.nextInt();
				int row = (int) Math.floor((userPositionChoice-1)/3);
				int col = (userPositionChoice-1)%3;
				valid = checkValidPosition(userPositionChoice);
				if (valid == 1)
					board.get(row).set(col, playerSymbol);
				else 
					System.out.println("Invalid Entry: Selected position is not empty.");
				displayBoard();
			}
		}
		else {
			System.out.println("CPU turn : ");
			while (valid != 1){
				int cpuPositionChoice;
				int goForWin = chooseWinningPosition(whoseTurn);
				int preventOpponentWin = chooseWinningPosition(1-whoseTurn);
				int chooseCorner = cornerPosition.get((int) Math.floor(Math.random()*10)%cornerPosition.size());
				int chooseSide = sidePosition.get((int) Math.floor(Math.random()*10)%sidePosition.size());
				int chooseCentre = 5;
				if (goForWin != 0)
					cpuPositionChoice = goForWin;
				else if (preventOpponentWin != 0)
					cpuPositionChoice = preventOpponentWin;
				else if (chooseCorner != 0)
					cpuPositionChoice = chooseCorner;
				else if (chooseCentre != 0)
					cpuPositionChoice = chooseCentre;
				else
					cpuPositionChoice = chooseSide;
				int row = (int) Math.floor((cpuPositionChoice-1)/3);
				int col = (cpuPositionChoice-1)%3;
				valid = checkValidPosition(cpuPositionChoice);
				if (valid == 1)
					board.get(row).set(col, cpuSymbol);
			}
			displayBoard();
		}
	}	

	//Main function
	public static void main(String[] args) {
		//initial run to set all variables
		cornerPosition = new ArrayList<Integer>(Arrays.asList(1,3,7,9));
		sidePosition = new ArrayList<Integer>(Arrays.asList(2,4,6,8));
		firstRun();
		while (isGameIsGoing == 1) {
			manageTurn();
			checkGameIsGoing();
			changePlayer();
		}
		//Report winner
		changePlayer();
		if (whoseTurn == 1)
			System.out.println("Congrats!! You Won.");
		else
			System.out.println("Opps!! CPU Wins.");
	}
}
