
import java.util.Scanner;
public class FindMax {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter The Array Size:");
		int size=sc.nextInt();
		int[] arr=new int [size];
		int max=arr[0];
		System.out.println("Now Please Enter The Numbers:");
		for (int i=0; i<size;++i){
			arr[i]=sc.nextInt();
			if(arr[i]>max) 
				max=arr[i];
		}
		System.out.println(max+" Is The Biggest Value");
	}
}