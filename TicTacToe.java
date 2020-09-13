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
		board.add(new ArrayList<String>(Arrays.asList("1","2","3")));
		board.add(new ArrayList<String>(Arrays.asList("4","5","6")));
		board.add(new ArrayList<String>(Arrays.asList("7","8","9")));
	}

	public static void displayBoard() {
		System.out.println(board.get(0).get(0)+ "|" +board.get(0).get(1)+ "|" +board.get(0).get(2));
		System.out.println(board.get(1).get(0)+ "|" +board.get(1).get(1)+ "|" +board.get(1).get(2));
		System.out.println(board.get(2).get(0)+ "|" +board.get(2).get(1)+ "|" +board.get(2).get(2));
	}

	//Method to choose who goes first
	public static void chooseFirst(int yourChoice) {
		Random random =new Random();
		int randomChoice = random.nextInt(2);
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

	//Main
	public static void main(String[] args) {
		//initial run to set all variables
		firstRun();
	}
}
