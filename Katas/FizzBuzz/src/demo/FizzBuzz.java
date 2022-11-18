package demo;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			String output = "";
			
			if (i % 3 == 0) {
				output = output + "fizz ";
			} 
			if (i % 5 == 0) {
				output = output + "buzz ";
			} 
			if (i % 7 == 0) {
				output = output + "pop ";
			} 
			
			
			if (output == "") {
				output = ""+i;
			}
			System.out.println(output);
			
			
		}
		sc.close();

	}

}
