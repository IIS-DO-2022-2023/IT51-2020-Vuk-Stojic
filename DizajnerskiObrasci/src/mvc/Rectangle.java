package mvc;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{

	private Point upperLeftPoint;
	private int height;
	private int width;
	private Color innerColor = new Color(0f, 0f, 0f, 0f);
	
	public Rectangle() {
		
	}
	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color) {
		this(upperLeftPoint, width, height);
		this.color = color;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color, Color innerColor) {
		this(upperLeftPoint, width, height, color);
		this.innerColor = innerColor;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color, boolean selected) {
		this(upperLeftPoint, width, height, color);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color, Color innerColor, boolean selected) {
		this(upperLeftPoint, width, height, color, innerColor);
		this.selected = selected;
	}
	
	public boolean contains(int x, int y) {
		return (upperLeftPoint.getX() <= x && (upperLeftPoint.getX() + width) >= x
				&& upperLeftPoint.getY() <= y && (upperLeftPoint.getY() + height) >= y);
	}
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	//Metode za izračunavanje površine i obima:
	
	public int area() {
		return width * height;
	}
	public int circumference() {
		return 2*width + 2*height;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle pomocni = (Rectangle)obj;
			if (this.upperLeftPoint.equals(pomocni.upperLeftPoint) 
					&& this.width == pomocni.width 
					&& this.height == pomocni.height)
				return true;
			else 
				return false;
		} else
			return false;
	}
	
	//Metode pristupa:
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Color getInnerColor() {
		return innerColor;
	}
	
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	public String toString() {
		return "Upper left point: " + upperLeftPoint + ", width = " 
						+ width + ", height = " + height; 
		//Upper left point: (xUpperLeft, yUpperLeft), width = <width>, height = <height>
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(innerColor);
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		g.setColor(color);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
		}
		
	}
	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
		
	}
	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
		
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle)
			return this.area() - ((Rectangle)o).area();
		return 0;
	}
	 
}
