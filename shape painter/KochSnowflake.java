
public class KochSnowflake {
	// Contains the 3 Pixels that represent the edges of a triangle.
	private Pixel topLeft;
	private Pixel topRight;
	private Pixel bottom;

	public KochSnowflake(){
		// Determines the coordinates for each pixel.
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.bottom = new Pixel (width, 40);
		this.topLeft = new Pixel (width+(height-40)*Math.cos(Math.PI/6),height+(height-40)/2);
		this.topRight = new Pixel (width-(height-40)*Math.cos(Math.PI/6),height+(height-40)/2);
		// topRight and topLeft's coordinates were calculated using the geometric characteristics of the equilateral triangle.
	}

	public void draw(){
		// Using the lines that form the triangle, this function creates a KochCurve from each of these lines to form a snowflake.
		Painter.setColor("blue");
		KochCurve a = new KochCurve(bottom,topRight,4);
		KochCurve b = new KochCurve(topRight,topLeft,4);
		KochCurve c = new KochCurve(topLeft,bottom,4);

		a.draw();
		b.draw();
		c.draw();
	}
}
