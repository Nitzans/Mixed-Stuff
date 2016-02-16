
public class Target {

	private FullCircle center1;
	private Hoop center2;
	private int depth;

	public Target(){
		this.center1 = new FullCircle();
		this.center2 = new Hoop();
		this.depth = 3;
	}

	public Target(Hoop center, int depth){
		this.depth=depth;
	}

	public FullCircle getCenter1(){
		FullCircle hoop = new FullCircle(center1.getCenter(),center1.getRadius()/2);
		return hoop;
	}

		public Hoop getCenter2(){
			Hoop hoop = new Hoop(center2.getCenter(),center2.getRadius()*1.2);
			return hoop;
		}
		public int getDepth(){
			return depth;

		}
		public double getRadius(){
			return center1.getRadius(); 
		}

		public void draw(){
			Painter.setColor("blue");
			double radius=center1.getRadius();
			
			Pixel circleCore3 = new Pixel(center1.getCenter().getX(),center1.getCenter().getY());
			Hooper smallSteps3 = new Hooper(circleCore3,radius*1.5);
			smallSteps3.draw();
			
			Pixel circleCore2 = new Pixel(center2.getCenter().getX(),center2.getCenter().getY());
			Hoop smallSteps = new Hoop(circleCore2,radius);
			smallSteps.draw();
			
			Pixel circleCore1 = new Pixel(center1.getCenter().getX(),center1.getCenter().getY());
			FullCircle smallSteps2 = new FullCircle(circleCore1,radius/5);
			smallSteps2.draw();
	}
}