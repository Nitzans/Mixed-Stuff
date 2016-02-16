
public class HanukiaCandles {
	public static void main(String[] args){
		int[] candles = {7, 5, 23, 5, 4};
		System.out.println(hanuka(candles));
	}
	
	public static boolean hanuka(int[] candles) {
		int day = 9;
		return hanuka(candles, day);
	}

	public static boolean hanuka(int[] candles, int day) {
		if (day == 1) return true;
		else{
			for (int i = 0; i < candles.length; i++){
				if (candles[i] >= day){
					candles[i] = candles[i]-day;
					if (hanuka(candles, day - 1))
						return true;
					candles[i] = candles[i]+day;
				}
			}
		}
		return false;
	}
}
