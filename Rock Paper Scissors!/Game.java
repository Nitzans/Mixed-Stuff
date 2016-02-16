/*
 * The classic and familiar game.
 * The user type "rock", "scissors" or "paper", and the computer randomize his choice.
 * Player can continue to another match by typing 'y'.
 * The score summarized in every step
 */

import java.util.Scanner;
import java.util.Random;

public class Game {
	public static void main(String[] args){
		boolean go=true;
		String comp ="";
		int countP=0;
		int countC=0;
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("Please Enter Your Choice [rock/scissors/paper]:");
			String input=sc.next();
			try{
				input = fix(input); //fix the word in case of misspelling
			} catch(Exception e){
				go=true;
			}

			int rand = new Random().nextInt(3);
			if (rand == 0) 
				comp="rock";
			if (rand == 1) 
				comp="paper";
			if (rand == 2) 
				comp="scissors";

			System.out.println("\t"+"You Chose: "+input);
			System.out.println("\t"+"Computer Chose: "+comp+"\n");

			switch(input){
			case "scissors":
				switch(comp){
				case "rock":
					countC++;
					System.out.println("**Computer Won** :(");
					break;
				case "paper":
					countP++;
					System.out.println("**You Won!** :)");
					break;
				case "scissors":
					System.out.println("**It's a Draw**");
					break;
				}
				break;
			case "rock":
				switch(comp){
				case "paper":
					countC++;
					System.out.println("**Computer Won** :(");
					break;
				case "scissors":
					countP++;
					System.out.println("**You Won!** :)");
					break;
				case "rock":
					System.out.println("**It's a Draw**");
					break;
				}
				break;
			case "paper":
				switch(comp){
				case "scissors":
					countC++;
					System.out.println("**Computer Won** :(");
					break;
				case "rock":
					countP++;
					System.out.println("**You Won!** :)");
					break;
				case "paper":
					System.out.println("**It's a Draw**");
					break;
				}
				break;
			}

			System.out.println("The Result Is: You: "+countP+" Computer: "+countC);
			System.out.println("Press 'y' to continue or any other key to quit");
			String choice=sc.next();
			if (!choice.equals("y")) go=false;
		}while (go);

		String winner="";
		if (countP>=countC) winner="You";
		else winner="Computer";
		System.out.println("The Final Winner Is: "+winner);
		System.out.println("Thanks for playing :) Hope you enjoyed");
		sc.close();
	}

	public static String fix (String input){
		if (input.charAt(0)=='s')
			return "scissors";
		if (input.charAt(0)=='r')
			return "rock";
		if (input.charAt(0)=='p')
			return "paper";
		else throw new IllegalArgumentException("please check you wrote correctly");
	}
}