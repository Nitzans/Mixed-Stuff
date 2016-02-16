
import java.util.Scanner;

/*
 * The class main get from the user the shape he wish to draw
 * and call the drew method of the selected shape.
 */

public class Main {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);	
		System.out.println("Please enter the number of the shape you wish to draw:\n" +
				" 1-example\n" +
				" 2-BasicStar\n" +
				" 3-Snowflake\n" +
				" 4-SuperSnowflake\n" +
				" 5-KochCurve\n" +
				" 6-KochSnowflake\n"+
				" 7-Circle\n"+
				" 8-FullCircle\n"+
				" 9-Audi\n"+
				" 10-Target\n");
		int shape = sc.nextInt();
		// chooses which shape to draw based on the number received
		switch(shape){
		case 1:
			drawExample();
			break;
		case 2:
			drawBasicStar();
			break;
		case 3:
			drawSnowflake();
			break;
		case 4:
			drawSuperSnowflake();
			break;
		case 5:
			drawKochCurve();
			break;
		case 6:
			drawKochSnowflake();
			break;
		case 7:
			drawCircle();
			break;
		case 8:
			drawFullCircle();
			break;
		case 9:
			drawAudi();
			break;
		case 10:
			drawTarget();
			break;
		default: System.out.println("invalid shape");
		}		
		sc.close();
	}
	
	// Draw the example line
	public static void drawExample(){
		Painter.draw("example");
	}

	// Draw a BasicStar
	public static void drawBasicStar(){
		Painter.draw("BasicStar");
	}

	// Draw a Snowflake
	public static void drawSnowflake(){
		Painter.draw("Snowflake");
	}
	
	// Draw a SuperSnowflake
	public static void drawSuperSnowflake(){
		Painter.draw("SuperSnowflake");
	}
	
	// Draw a KochCurve
	public static void drawKochCurve(){
		Painter.draw("KochCurve");
	}
	
	// Draw a KochSnowflake
	public static void drawKochSnowflake(){
		Painter.draw("KochSnowflake");
	}
	
	// Draw a Circle
		public static void drawCircle(){
			Painter.draw("Circle");
	}
		
	// Draw a full Circle
		public static void drawFullCircle(){
			Painter.draw("FullCircle");
	}

	// Draw a Audi sign
		public static void drawAudi(){
			Painter.draw("Audi");
	}
		
	// Draw a target sign
		public static void drawTarget(){
			Painter.draw("Target");
	}
}
