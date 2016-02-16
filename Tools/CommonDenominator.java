/*
 * Finds the common denominator
 * Example: the common denominator of 2,3 and 5 is 30.
 * The program stops when typing zero
 */

import java.util.Scanner;
public class CommonDenominator  {
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int a = sc.nextInt();
		int b, res=-1;
		while (res!=0){
			b = sc.nextInt();
			res = (a*b/gcd(a,b));
			System.out.println(res);
			a=res;
		}
		System.out.println("Terminated");
		sc.close();
	}	

	public static int gcd(int n,int m){
		if (m==0) return n;
		else
			return gcd(m,n%m);
	}
}
