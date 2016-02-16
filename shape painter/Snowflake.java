
public class Snowflake {
	// Contains a Basic Star as the center and the depth required for the recursive function.
	private BasicStar center;
	private int depth;

	public Snowflake(){
		// Initializes the Basic Star center and the depth's values.
		this.center = new BasicStar();
		this.depth = 4;
	}

	public Snowflake(BasicStar center, int depth){
		this.center =center;
		this.depth=depth;
	}

	// Getters:
	public BasicStar getCenter(){
		// Gets the center pixel and the radius for our Basic Star.
		BasicStar twinkle = new BasicStar(center.getCenter(),center.getRadius());
		return twinkle;
	}
	public int getDepth(){
		return depth;

	}
	public double getRadius(){
		return center.getRadius(); 
	}

	public void draw(){
		//Calls a recursive draw method using a Pixel, a radius the depth.
		int depth = this.depth;
		double radius=center.getRadius();
		Pixel starCore = new Pixel(center.getCenter().getX(),center.getCenter().getY());
		recursiveDraw(starCore,radius,depth);
	}

	private void recursiveDraw (Pixel point, double radius, int depth){
		// Recursively draws a smaller Basic star at the 6 tips of each star drawn before it. 
		BasicStar smallSteps = new BasicStar(point,radius);
		if (depth==1) smallSteps.draw(); // The condition in which the recursive call stops.
		else{
			Pixel onRadius = new Pixel(point.getX()+radius,point.getY());
			for(int rotation=0;rotation<6;rotation+=1){
				smallSteps.draw();
				recursiveDraw(onRadius,(radius/3), (depth-1));
				onRadius.rotateRelativeToPixel(point,(2*(Math.PI)/6)); // Same rotation method used to draw a single Basic Star.
			} 
		}
	}
}
