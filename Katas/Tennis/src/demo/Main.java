package demo;

public class Main {

	public static void main(String[] args) {
		Player p1 = new Player("Anne");
		Player p2 = new Player("Jay");
		
		Game tennisKata = new Game(p1,p2);
		
		int max = 20;
		int min = 0;
		
		do{
			int randomNumber = (int) (Math.random()*(max-min)) + min;
			if(randomNumber % 2 == 0) {
				p1.winBall();
				System.out.println(p1.getName()+" won this round.");
			}else {
				p2.winBall();
				System.out.println(p2.getName()+" won this round.");
			}
			System.out.println(tennisKata.getScore());
		}
		while(tennisKata.getLeadPlayer().getScoreDescription() != "A");
		
		
		System.out.println("The winner is: "+tennisKata.getLeadPlayer().getName());
		

	}

}
