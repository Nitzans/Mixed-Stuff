import java.util.Scanner;

/*
 * Decrypts text using Cesar code
 */
public class Cesarcipher {
	public static void main (String[] decrypt){
		System.out.println("Enter the text you want to decrypt: ");
		Scanner sc = new Scanner(System.in);
		String encrypted =sc.next();
		encrypted=decrypt(encrypted,12);
		System.out.println(encrypted);
		sc.close();
	}
	
	/**
	 *@param str - the text to decrypt. key - how many letters to indent
	 *@return decrypted text
	 */
	public static String decrypt(String str, int key) {
		String ans = "";
		final int ALPHABET_SIZE = 26;
		for (int i = 0; i < str.length(); i=i+1) {
			int c = str.charAt(i);
			if ('A'<=c && c<='Z') {
				c = c - 'A';
				c = ((c + key) % ALPHABET_SIZE )+'A';
			}
			else if ('a'<=c && c<='z') {
				c = c - 'a';
				c = ((c + key) % ALPHABET_SIZE )+'a';
			}
			ans = ans + (char)c;
		}	
		return ans;
	}
}
