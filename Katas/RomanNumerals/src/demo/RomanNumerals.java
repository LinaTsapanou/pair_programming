package demo;

import java.util.Scanner;

public class RomanNumerals {
	
	public static String intToRoman(int num) {
		 
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
		String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
		StringBuilder roman = new StringBuilder();  
		
		for(int i=0; i<values.length; i++) {  
			while(num >= values[i]) {  
				num = num - values[i];  
				roman.append(romanLetters[i]);  
			}  
		}  
		return roman.toString();
	}  
	
	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);

		System.out.println("Roman Numerals");

		System.out.println("Enter an Integer:");
		int input = myObj.nextInt();

		System.out.println("Roman Numerals of " + input + " is: " + intToRoman(input));  
		
	}

}