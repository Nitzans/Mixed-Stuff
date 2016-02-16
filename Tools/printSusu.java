
/*
 * The user type 'sum', which is the maximum value, and an array of numbers
 * The program will print all the possible combination for getting the sum with the given numbers (if there is so)
 */
public class printSusu {
	public static void main(String[] args){
		int sum=12;
		int[] arguments={3, 7, 2, 9};
		binSusu(arguments,sum);
	}

	public static void binSusu(int[] arguments, int sum) { //wrapper
		int i = 0;
		binSusu(arguments, sum, i, 0, "");
	}

	public static void binSusu(int[] arguments, int sum, int i, int acc, String s) {
		if (acc > sum) //you exceed the bound
			return;
		if (acc == sum) //this option fits
			System.out.println(s);		
		if (i == arguments.length) // end of arguments
			return;	
		else{
			binSusu(arguments, sum, i + 1, acc, s);
			binSusu(arguments, sum, i + 1, acc + arguments[i], s +" "+ arguments[i]+" ");	
		}
		return;
	}
}
