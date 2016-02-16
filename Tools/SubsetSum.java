/*
 * Prints all the numbers that can be written by the given input
 */
import java.util.Scanner;
public class SubsetSum {
	public static void main(String[] args){
		System.out.println("Please enter the value: ");
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		subs(s,0);
		sc.close();
	}

	private static void subs (String s, int x) {
		if (!s.equals("")) //don't print the empty set
			System.out.println(s);
		for (int i = x; i < s.length(); ++i)
			subs(s.substring(0, i)+s.substring(i+1), i);
	}
}