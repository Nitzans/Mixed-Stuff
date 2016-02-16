
public class Pixel {
	// Contains the required fields that represent the x and y coordinates of the pixel.
	private double x;
	private double y;

	public Pixel(){
		// Initializes x and y as 0 (The Axes Origin).
		x=0.0;
		y=0.0;
	}

	public Pixel(double x, double y){
		this.x=x;
		this.y=y;
	}
	// Getters:
	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}

	public void translate(Pixel p){
		// Moves the pixel to another location by adding the distance to the original x and y values.
		this.x = this.x+p.getX();
		this.y = this.y+p.getY();
	}

	public void rotateRelativeToAxesOrigin(double theta){
		// Rotates the pixel using the axes origin as the pivot to a new location according to the rotation angle.
		double tempX = this.x*Math.cos(theta)-this.y*Math.sin(theta);
		double tempY = this.x*Math.sin(theta)+this.y*Math.cos(theta);
		this.x = tempX;
		this.y = tempY;
	}

	public void rotateRelativeToPixel(Pixel p1,double theta){
		// Also rotates the pixel, only now the pivot is another pixel.
		Pixel rotatable = new Pixel (p1.getX(),p1.getY());
		Pixel cross = new Pixel (this.x,this.y);
		rotatable.rotateRelativeToAxesOrigin(theta);
		cross.rotateRelativeToAxesOrigin(theta);
		this.y=p1.getY() - (rotatable.getY() - cross.getY());
		this.x=p1.getX() - (rotatable.getX() - cross.getX());
	}	
}
