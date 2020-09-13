import java.util.*;

class TicTacToe {

	//declaring a gobal tic tac toe board
	private static ArrayList<ArrayList<String> > board;
	private static int whoseTurn = 0;

	//Method to initialise board
	public static void initBoard() {
		board = new ArrayList<ArrayList<String> >();
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
		board.add(new ArrayList<String>(Arrays.asList("-","-","-")));
	}

	//Method to choose who goes first
	public static void chooseFirst(int yourChoice) {
		Random random = new Random();
		int randomChoice = random.nextInt(2);
		if (randomChoice == yourChoice) {
			whoseTurn =  randomChoice;
			System.out.println("You won the toss.");
		}
		else {
			whoseTurn =  randomChoice;
			System.out.println("CPU won the toss.");
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
	}
}
