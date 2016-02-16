
public class Circle {
	private Pixel center;
	private double radius;
	
	public Circle(){
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.center = new Pixel (width, height);
		double maxRadius = Math.min(width, height)/2;
		this.radius = maxRadius/2;
	}
	
	public Circle(Pixel center, double radius){
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
		Pixel onCircle1 = new Pixel(center.getX()+radius,center.getY());
		Pixel onCircle2 = new Pixel(center.getX()+radius,center.getY());
		for(double theta=0.0;theta<Math.PI;theta=theta+0.01){
			onCircle1.rotateRelativeToPixel(center,theta);
			onCircle2.rotateRelativeToPixel(center,theta*0.999);
			Painter.drawLine(onCircle1, onCircle2);
		}
	}
}
