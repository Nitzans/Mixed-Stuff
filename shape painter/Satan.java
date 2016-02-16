
public class Satan {

	private Pixel center;
	private double radius;

	public Satan(){
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.center = new Pixel (width, height);
		double maxRadius = Math.min(width, height)/2;
		this.radius = maxRadius/2;
	}

	public Satan(Pixel center, double radius){
		this.center=new Pixel (center.getX(),center.getY());
		this.radius=radius;
	}

	public Pixel getCenter(){
		Pixel middle = new Pixel(center.getX(),center.getY());
		return middle;
	}

	public double getRadius(){
		return radius;

	}

	public void draw(){
		Painter.setColor("blue");
		double theta=9*Math.PI/5;
		Pixel edge1 = new Pixel(center.getX()+radius,center.getY());
		edge1.rotateRelativeToPixel(center,theta);
		Pixel edge2 = new Pixel(center.getX()+radius,center.getY());
		edge2.rotateRelativeToPixel(edge1,theta);
		Pixel edge3 = new Pixel(center.getX()+radius,center.getY());
		edge3.rotateRelativeToPixel(edge2,theta);
		Pixel edge4 = new Pixel(center.getX()+radius,center.getY());
		edge4.rotateRelativeToPixel(edge3,theta);
		Pixel edge5 = new Pixel(center.getX()+radius,center.getY());
		edge5.rotateRelativeToPixel(edge4,theta);
		Painter.drawLine(edge1, edge2);
		Painter.drawLine(edge2, edge3);
		Painter.drawLine(edge3, edge4);
		Painter.drawLine(edge4, edge5);
		Painter.drawLine(edge5, edge1);
	}
}
