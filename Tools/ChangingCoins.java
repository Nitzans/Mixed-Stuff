/*
 * Prints all the options of changing money
 * Example: 5 can be changed to {5}, {2,2,1}, {2,1,1,1}, {1,1,1,1,1}
 */
import java.util.Scanner;
public class ChangingCoins {
	public static void main(String[] args){
		Scanner sc= new Scanner (System.in);
		System.out.print("Please enter value: ");
		int x=sc.nextInt();
		int[] values = { 10, 5, 2, 1}; //The available coins
		int[] count = new int[values.length];
		change(x, values, count, 0);
		sc.close();
	}

	private static void change (int n, int[] values, int[] count, int min){
		if (n == 0) {
			for (int i = 0; i < count.length; i++)
				for (int j = 0; j < count[i]; j++)
					System.out.print(values[i] + "  ");
			System.out.println();
		} else
			for (int i = min; i < values.length; i++)
				if (n >= values[i]) {
					count[i]++;
					change(n-values[i], values, count, i);
					count[i]--;
				}
	}
}