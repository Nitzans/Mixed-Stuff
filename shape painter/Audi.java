public class Audi {
	private Circle center;

	public Audi(){
		this.center = new Circle();
	}

	public Audi(Circle center){
		this.center =center;
	}

	public Circle getCenter(){
		Circle more = new Circle(center.getCenter(),center.getRadius());
		return more;
	}
	
	public double getRadius(){
		return center.getRadius(); 
	}

	public void draw(){
		double radius=center.getRadius();
		Pixel circleCore = new Pixel(center.getCenter().getX(),center.getCenter().getY());
		Pixel onRadius1 = new Pixel(circleCore.getX()+radius*1.3,circleCore.getY());
		Pixel onRadius2 = new Pixel(onRadius1.getX()+radius*1.3,onRadius1.getY());
		Pixel onRadius3 = new Pixel(onRadius2.getX()+radius*1.3,onRadius2.getY());
		Pixel onRadius4 = new Pixel(onRadius3.getX()+radius*1.3,onRadius3.getY());
		Circle smallSteps = new Circle(circleCore,radius);
			smallSteps.draw();
			smallSteps = new Circle(onRadius1,radius);
			smallSteps.draw();
			smallSteps = new Circle(onRadius2,radius);
			smallSteps.draw();
			smallSteps = new Circle(onRadius3,radius);
			smallSteps.draw();
			smallSteps = new Circle(onRadius4,radius);
	}
}
