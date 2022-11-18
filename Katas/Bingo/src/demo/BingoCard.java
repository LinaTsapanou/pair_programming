package demo;

import java.util.ArrayList;

public class BingoCard {

	private int[][]card = new int [5][5]; 

	public int[][] getCard(){
		return card;
	}
	
	public void setCard(int[][] card) {	
		this.card = card;
	}

	public BingoCard(){
		ArrayList<Integer> alreadyUsed = new ArrayList<Integer>(); 
		boolean valid = false;
		int tmp = 0; 

		for(int row = 0; row <= 4; row++){
			for(int col = 0; col < card.length; col++){
				while(!valid){ 
					tmp = (int)(Math.random() * 15)+1 + 15 * col; 
					if(!alreadyUsed.contains(tmp)){ 
						valid = true; 
						alreadyUsed.add(tmp);
					}
				}
				card[row][col] = tmp; 
				valid = false; 
			}
		}

		card[2][2] = 0;

	}


	public void printCard(){

		String title[] = {"  B  ","  I  ","  N  ","  G  ","  O  "}; 
		for(int i = 0; i < title.length; i++){ 
			System.out.print(title[i]);
		}
		System.out.println(); 

		for(int row = 0; row < card.length; row++){ 
			System.out.print("|"); 
			for(int col = 0; col < card[row].length; col++){ 
				System.out.print(card[row][col] + "\t|"); 
			}
			System.out.println("\n-----------------------------------------");
		}
	}


	public int checkMatch(int input){ 
		int cardPos=0; 
		for(int row = 0; row <= 4; row++){ 
			for(int col = 0; col < card.length; col++){ 
				if(card[row][col]==input){
					card[row][col]=0;
					return cardPos;
				}
                                cardPos++;
                        }
		}
		return -1;
	}


	public boolean checkBingo(){
		if(card[0][0]==0&&card[0][1]==0&&card[0][2]==0&&card[0][3]==0&&card[0][4]==0){
			return true;
		}else if(card[1][0]==0&&card[1][1]==0&&card[1][2]==0&&card[1][3]==0&&card[1][4]==0){
			return true;
		}else if(card[2][0]==0&&card[2][1]==0&&card[2][2]==0&&card[2][3]==0&&card[2][4]==0){
			return true;
		}else if(card[3][0]==0&&card[3][1]==0&&card[3][2]==0&&card[3][3]==0&&card[3][4]==0){
			return true;
		}else if(card[4][0]==0&&card[4][1]==0&&card[4][2]==0&&card[4][3]==0&&card[4][4]==0){
			return true;
		}else if(card[0][0]==0&&card[1][0]==0&&card[2][0]==0&&card[3][0]==0&&card[4][0]==0){
			return true;
		}else if(card[0][1]==0&&card[1][1]==0&&card[2][1]==0&&card[3][1]==0&&card[4][1]==0){
			return true;
		}else if(card[0][2]==0&&card[1][2]==0&&card[2][2]==0&&card[3][2]==0&&card[4][2]==0){
			return true;
		}else if(card[0][3]==0&&card[1][3]==0&&card[2][3]==0&&card[3][3]==0&&card[4][3]==0){
			return true;
		}else if(card[0][4]==0&&card[1][4]==0&&card[2][4]==0&&card[3][4]==0&&card[4][4]==0){
			return true;
		}else if(card[0][0]==0&&card[1][1]==0&&card[2][2]==0&&card[3][3]==0&&card[4][4]==0){
			return true;
		}else if(card[4][4]==0&&card[3][3]==0&&card[2][2]==0&&card[1][1]==0&&card[0][0]==0){
			return true;
		}else{ 
                    return false;
		}
	}

}