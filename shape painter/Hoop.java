
public class Hoop {
	private Pixel center;
	private double radius;
	
	public Hoop(){
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.center = new Pixel (width, height);
		double maxRadius = Math.min(width, height)/2;
		this.radius = maxRadius;
	}
	
	public Hoop(Pixel center, double radius){
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
		Painter.setColor("darkGreen"); 
		Pixel onHoop1 = new Pixel(center.getX()+radius,center.getY());
		Pixel onHoop2 = new Pixel(center.getX()+radius,center.getY());
		for(double theta=0.0;theta<Math.PI*2;theta=theta+0.0001){
			onHoop1.rotateRelativeToPixel(center,theta);
			onHoop2.rotateRelativeToPixel(center,theta*0.99999);
			Painter.drawLine(onHoop1, onHoop2);
		}
	}
}