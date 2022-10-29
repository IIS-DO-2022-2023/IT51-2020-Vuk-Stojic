package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	// Prosiruje klasu Circle i time nasleđuje sva obeležja i 
	// metode klase Circle, koji nisu deklarisani kao private.
	
	private int innerRadius;
	private Color innerColor = new Color(0f, 0f, 0f, 0f);
	
	public Donut() {
		
	}
	public Donut(Point center, int radius, int innerRadius) {
		//setCenter(center);
		//setRadius(radius);
		super(center, radius); // Poziv konstruktora osnovne klase; Prosledjujem mu parametre
								// Mora biti prva naredba u konstruktoru izvedene klase
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color) {
		this(center, radius, innerRadius);
		this.color = color;
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color, Color innerColor) {
		this(center, radius, innerRadius, color);
		this.innerColor = innerColor;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color, boolean selected) {
		this(center, radius, innerRadius, color);
		this.selected = selected;
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color, Color innerColor, boolean selected) {
		this(center, radius, innerRadius, color, selected);
		this.innerColor = innerColor;
	}
	
	
	@Override
	public boolean contains(int x, int y) {
		
		return (center.distance(x, y) <= getRadius() && center.distance(x, y) >= innerRadius);
		
	}
	
	@Override
	public boolean contains(Point p) {
		
		return this.contains(p.getX(), p.getY());
		
	}
	@Override
	public double area() {
		
		return super.area() - innerRadius*innerRadius*Math.PI;
		// Korišćenjem ključne reči super pozivamo metodu osnovne klase.
		// Da smo napisali samo area() došlo bi do rekurzije.
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut pomocni = (Donut)obj;
			if(getCenter().equals(pomocni.getCenter()) 
					&& getRadius() == pomocni.getRadius()
					&& innerRadius == pomocni.innerRadius)
				return true;
				
		}
		return false;
	}
	@Override
	public String toString() {
		// Center: (xCenter,yCenter), radius: <radius>, innerRadius: <innerRadius>
		return super.toString() + ", innerRadius: "+ innerRadius;
	}
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public Color getInnerColor() {
		return innerColor;
	}
	
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	@Override
	public void draw(Graphics g) {
		
		super.setInnerColor(innerColor);
		super.draw(g); //Draws a circle (Outer)
		super.setInnerColor(new Color(0f, 0f, 0f, 0f));
		
		//Draws an inner circle
		g.setColor(Color.white);
		g.fillOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
		g.setColor(color);
		g.drawOval(getCenter().getX() - innerRadius,getCenter().getY() - innerRadius, 2*innerRadius, 2*innerRadius);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX()-innerRadius -2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX()+ innerRadius -2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX()-2	, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX()-2	, getCenter().getY() + innerRadius - 2, 4, 4);
		}
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut)
			return (int) (this.area() - ((Donut)o).area());
		return 0;
	}
	
	
}
