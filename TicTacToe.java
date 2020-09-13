import java.util.*;

class TicTacToe {

	//declaring a gobal tic tac toe board
	private static ArrayList<ArrayList<String> > board;
	private static int whoseTurn = 0; // to monitor turns 1 --> player and 0 --> cpu
	private static int playerFlag = 1; // to check if player won(1) toss or cpu(0)
	private static String playerSymbol = "";
	private static String cpuSymbol = "";

	//Method to initialise board
	public static void initBoard() {
		board = new ArrayList<ArrayList<String> >();
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
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
	public static void secChooseSymbol(int userSymbolChoice){
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
			System.out.print("Select your choice (1: X, 2: O): ");
			userSymbolChoice = input.nextInt();
			secChooseSymbol(userSymbolChoice);
		}
		else {
			userSymbolChoice = (int) Math.floor(Math.random()*10)%2+1;
			secChooseSymbol(userSymbolChoice);
		}
	}

	//Main
	public static void main(String[] args) {
		//take user input
		Scanner input = new Scanner(System.in);
		System.out.print("Select your choice (1:Head, 2:Tail): ");
		int userChoice = input.nextInt();
		chooseFirst(userChoice);
		initBoard();
		System.out.println(board);

		System.out.println("Player symbol: "+playerSymbol+ " CPU Symbol : "+cpuSymbol);
	}
}
