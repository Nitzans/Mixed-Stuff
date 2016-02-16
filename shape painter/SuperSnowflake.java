
public class SuperSnowflake {
	// Contains a snowflake object as the center and the depth.
	private Snowflake center;
	private int depth;

	public SuperSnowflake(){
		this.center = new Snowflake();
		this.depth = 4;
	}

	public SuperSnowflake(Snowflake center, int depth){
		this.center  = center;
		this.depth = depth;
	}
	// Getters:
	public Snowflake getCenter(){
		// Gets the center pixel and the radius for our snowflake.
		Snowflake snowy = new Snowflake(center.getCenter(),center.getDepth());
		return snowy;
	}

	public int getDepth(){
		return depth;
	}
	public void draw(){
		double radius=center.getRadius();
		Pixel flakeCore = new Pixel(center.getCenter().getCenter().getX(),center.getCenter().getCenter().getY());
		BasicStar icy = new BasicStar(flakeCore,radius);
		Snowflake moreSnow = new Snowflake (icy, 4);
		moreSnow.draw(); // Draws the main snowflake 
		double distance=radius*3;
		for (int j=1; j<depth; j++){
			// Creates three circles around the main snowflake, all with the same center, each one bigger than the one before it.
			Pixel roundAFlake = new Pixel ((center.getCenter().getCenter().getX())+distance,center.getCenter().getCenter().getY());
			radius=radius/2;
			distance=distance+(radius*3);
			for (int i=0;i<6;i++){ 
				// Draws 6 snowflakes around each circle, as the distance from the center grows, the snowflakes become smaller.
				BasicStar icyRevolver = new BasicStar(roundAFlake,radius);
				Snowflake evenMoreSnow = new Snowflake (icyRevolver, 4);
				evenMoreSnow.draw();
				roundAFlake.rotateRelativeToPixel(flakeCore, Math.PI/3);
			}
		}
	}
}