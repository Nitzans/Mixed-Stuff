
public class DavidStar {
	// Contains a center pixel field and the radius field which determines the length of the star's arms.
	private Pixel center;
	private double radius;
	private Pixel start;
	public DavidStar(){
		// Determines where the center should be and also the length of the radius.
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.center = new Pixel (width, height);
		new Pixel (width/2,height/2);
		double maxRadius = Math.min(width, height)/2;
		this.radius = maxRadius;
	}

	public DavidStar(Pixel center, double radius){
		// The parameterized constructor for center and radius.
		this.center=new Pixel (center.getX(),center.getY());
		this.start=new Pixel (center.getX()/2,center.getY()/2);
		new Pixel (center.getX()*2,center.getY()*2);
		this.radius=radius;
	}
	// Getters:
	public Pixel getCenter(){
		// Returns the values of the center's coordinates.
		Pixel middle = new Pixel(center.getX(),center.getY());
		return middle;
	}

	public double getRadius(){
		return radius;

	}

	public void draw(){
		// Draws 6 lines using a "for" loop and a rotation angle of 60 degrees. This is done by rotating a new pixel each time relative to the center.
		Painter.setColor("blue");
		double theta=2*Math.PI/6;
		Pixel onRadius = new Pixel(center.getX()+radius,center.getY());

		
			
			Painter.drawLine(start, center);
			onRadius.rotateRelativeToPixel(center,theta);
	}
}
