package demo;

import java.util.Arrays;
import java.util.List;

public class Player {
	private int score;
	String name;
    public static final List<String> pointsDisplay = Arrays.asList("0", "15", "30", "40","A");

    public Player(String name) {
        this.name = name;
    }

    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }

    public void winBall() {
        this.score = this.score + 1;
    }

    public String getScoreDescription(){
        return pointsDisplay.get(score);
    }

}