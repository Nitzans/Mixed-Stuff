/**
 * The code makes random choice between Heads or Tail as many times as you wish.
 * it prints all the results and summarize the final score
 */
import java.util.Scanner;
import java.util.Random;
public class Raffle{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many times you want to flip the coin?");
		int times = sc.nextInt();
		int counterH=0;
		int counterT=0;
		int r;
		Random rand = new Random();
		for (int i=0;i<times;i++){
			r = rand.nextInt(2);
			if (r==0){ 
				System.out.println("Heads");
				counterH++;
			}
			if (r==1){ 
				System.out.println("Tail");
				counterT++;
			}
		}
		System.out.println();
		System.out.println("Heads: "+counterH); 
		System.out.println("Tail: "+counterT);
	}
}