/*
 * Prints how many every number appears in the given array
 * Note: the user should type the array directly in the code
 */
public class Occurences {
	public static void main(String[] args){
		int[] a = {5,-1,3,1,3,4,1,3,5,3,1000};
		occurrences(a);
	}

	public static void occurrences(int[] a){
		insertion(a);//sorts the array
		int j=0;
		for (int i=0;i<a.length;i=j){
			int count=1;
			for (j=i+1;j<a.length && a[i]==a[j];j++)
				count++;
			System.out.println(a[i]+" appears "+count+" times");
		}
	}
	public static void insertion(int[] arr){
		for (int i=1;i<arr.length;i++){
			insert(arr,i);
		}
	}

	public static void insert (int[] arr, int i){
		int pointer=arr[i];
		while (i>0 && pointer<arr[i-1]){
			arr[i]=arr[i-1];
			i--;
		}
		arr[i]=pointer;
	}
}
