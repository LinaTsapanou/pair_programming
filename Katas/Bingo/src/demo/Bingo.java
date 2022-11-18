package demo;

import java.util.Scanner;

public class Bingo {

	public static void main(String[] args) {
		 BingoCard newCard = new BingoCard();
	     newCard.printCard(); 
	     System.out.println("Welcome to Bingo Game");
	     
	     Scanner newInput = new Scanner(System.in); 
	        while(!newCard.checkBingo()){ 
	            System.out.print("Enter Next Bingo Number: "); 
	            int input = newInput.nextInt(); 
	            newCard.checkMatch(input);
	            newCard.printCard();
	        }

	}

}



