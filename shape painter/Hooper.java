
public class Hooper {

	private Pixel center;
	private double radius;
	
	public Hooper(){
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.center = new Pixel (width, height);
		double maxRadius = Math.min(width, height)/2;
		this.radius = maxRadius*1.5;
	}
	
	public Hooper(Pixel center, double radius){
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
		Painter.setColor("red"); 
		Pixel onHooper1 = new Pixel(center.getX()+radius*0.8,center.getY());
		Pixel onHooper2 = new Pixel(center.getX()+radius*0.8,center.getY());
		for(double theta=0.0;theta<Math.PI*2;theta=theta+0.0001){
			onHooper1.rotateRelativeToPixel(center,theta);
			onHooper2.rotateRelativeToPixel(center,theta*0.99999);
			Painter.drawLine(onHooper1, onHooper2);
		}
	}
}
