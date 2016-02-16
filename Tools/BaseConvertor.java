/*
 * The code gets from the user a positive integer and base, and prints its value in this base
 * Throws exception if the base is 1
 */
import java.util.Scanner;
public class BaseConvertor {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter number: ");
		int n = sc.nextInt();
		System.out.println("Please choose base: ");
		try{
		int b = sc.nextInt();
		printBinary(n,b);
		} catch(Exception e){
		 System.out.println("1 is illegal as base! Please try again... \n");	
		 main(args);
		 sc.close();
		}
	} 

	public static void printBinary(int n, int b) throws Exception {
		if (b==1) throw new Exception();
		int m=n;
		String s = "";
		s = s+(n%b);
		while (n/b!=0){
			n=n/b;
			s = (n%b)+s;
		}
		System.out.print(m+" is "+s+" in base "+b);
	}
}