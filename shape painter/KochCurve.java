
public class KochCurve {
	// Contains the two pixels between which the curve will be drawn and the depth for the recursive method.
	private Pixel start;
	private Pixel end;
	private int depth;

	public KochCurve(){
		// Determines the center's location and the Pixels' coordinates.
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.start = new Pixel (width, height);
		this.end = new Pixel (width+(width/2), height+(height/2));
		this.depth=4;
	}

	public KochCurve(Pixel a, Pixel b, int depth){
		// The parameterized constructor for our fields.
		this.start = a;
		this.end = b;
		this.depth=depth;
	}

	public void draw(){
		// Calls a recursive function using two pixels and a depth to create the curve.
		recursiveDraw(start,end,depth);

	}
	public void recursiveDraw(Pixel start, Pixel end, int depth){
		// Creates 3 new pixels between start and end. lines will be drawn between the pixels and the recursive method will work on each line seperately.
		double deltaX = end.getX()-start.getX();
		double deltaY = end.getY()-start.getY();

		Pixel stat1 = new Pixel (start.getX()+(deltaX/3),start.getY()+(deltaY/3));
		Pixel stat2 = new Pixel (start.getX()+2*(deltaX/3),start.getY()+2*(deltaY/3));
		Pixel edge = new Pixel (start.getX()+2*(deltaX/3),start.getY()+2*(deltaY/3));
		edge.rotateRelativeToPixel(stat1, Math.PI/3);

		if (depth==1){ // The initial 4 lines for the level 1 curve.
			Painter.drawLine(start, stat1);
			Painter.drawLine(stat1, edge);
			Painter.drawLine(edge, stat2);
			Painter.drawLine(stat2, end); 
			return; 
		}
		// The recursive call for each seperate line.
		recursiveDraw(start,stat1,depth-1);
		recursiveDraw(stat1,edge,depth-1);
		recursiveDraw(edge,stat2,depth-1);
		recursiveDraw(stat2,end,depth-1);
	}
}
