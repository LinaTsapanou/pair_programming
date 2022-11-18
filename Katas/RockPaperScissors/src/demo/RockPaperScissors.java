package demo;

import java.util.*;

public class RockPaperScissors {
	
	static private String initMsg = "Enter Number of rounds to play";
	static private String errorMsg = "Not a valid input. Program shutting down";
	static private String inputMsg = "Enter your choice from : 1 = Rock, 2 = Paper, 3 = Scissors";
	static private String playAgainMsg = "Do you want to play again? : Y=Yes, N=No";
	static private String endGameMsg = "Thanks for playing!";
	
	
	static int R = 0;
	static int userWins = 0;
	static int computerWins = 0;
	static int ties = 0;
	
	// To display Player Names
	static String Player1 = "Player 1";
	static String Player2 = "Player 2";
	
	// To store Valid Choice Options that a Player can enter
    static String [] PlayerChoicesArr = {"1","2","3"};
    static List<String> PlayerChoices = Arrays.asList(PlayerChoicesArr);
	
    // To store the winning combinations
    static String [] WinsOptionsArr = {"1, 3", "2, 1", "3, 2"};
    static List<String> WinsOptions = Arrays.asList(WinsOptionsArr);
    

	public static void main(String[] args) {
		enterRounds();
	}
	
	private static void enterRounds() {
	
		output(initMsg);
        String input = input();
     
		if (isInputValid(input)) {
			int RoundsInput = Integer.parseInt(input);
			R = 0;
			while(R<RoundsInput) {
				play();
				R = R +1;
			}
	        	
		} else {
			output(errorMsg);
		}
		
		// Declare Overall Winner
		getOverallWinner();
       
        output(playAgainMsg);
        String input2 = input();
        if(input2.equals("Y")) {
        	// reset the Rounds and Scores
        	R = 0;
        	userWins = 0;
        	computerWins = 0;
        	ties = 0;
        	enterRounds();
        }
        else {
        	output(endGameMsg);	
        }	
	}
	
	
	private static void play() {
		output("Turn of Player 1 --> "+inputMsg);
		String player1Choice = input();
		output("Turn of Player 2 --> "+inputMsg);
		String player2Choice = input();
		
		if(isChoiceValid(player1Choice) && isChoiceValid(player2Choice)) {
			getWinner(player1Choice, player2Choice);
		}
		else{
			play();
		}	
	}
	
	public static void getOverallWinner() {
		if(userWins > computerWins) {
        	output("Overall WINNER IS "+Player1);
        }
        else if(computerWins > userWins) {
        	output("Overall WINNER IS "+Player2);
        }
        else {
        	output("Overall IT IS A TIE");
        }
	}
	
	
	public static void getWinner(String P1, String P2) {
		
		if(WinsOptions.contains(""+P1+", "+P2+"")) {
			 userWins = userWins + 1;
	         output("ROUND "+R+" , WINNER is "+Player1);
	    }
	    else if(WinsOptions.contains(""+P2+", "+P1+"")) {
	    	 computerWins = computerWins + 1;
	         output("ROUND "+R+" , WINNER is "+Player2);
	    }
	    else {
	    	ties = ties + 1;
	    	output("ROUND "+R+" , TIE");
	    }
		
	}

	
	private static boolean isChoiceValid(String input) {
		
		boolean result = false;
		
		if(PlayerChoices.contains(input)) {
			result= true;
		}

		return result;
	}
	
	

	private static boolean isInputValid(String input) {

		boolean result = false;

		int tempInput;
		try {
			tempInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return result;
		}
		
		// to check if user input is within valid range 1 to 10 inclusive
		if ((1 <= tempInput) && (tempInput <= 10)) {
			result = true;
		}
			
		return result;

	}

	private static void output(String msg) {
		System.out.println(msg);

	}

	private static String input() {
		String input = "";
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream

		input = sc.next();

		return input;
	}

}