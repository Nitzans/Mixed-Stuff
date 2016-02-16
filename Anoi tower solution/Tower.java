import java.util.Scanner;

public class Tower {
	public static void main (String[] args){
		char a='a';
		char b='b';
		char c='c';
		System.out.println("How money ring do you want to solve?");
		int rings = new Scanner(System.in).nextInt();
		hanoi(rings,a,b,c);

	}

	public static void hanoi(int n,char source,char destination,char extra){
		if (n>0){
			hanoi(n-1,source,extra,destination);
			System.out.println("Move disk from "+source+" to "+destination);
			hanoi(n-1,extra,destination,source);
			return;
		}

	}

}
