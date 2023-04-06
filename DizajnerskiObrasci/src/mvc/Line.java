package mvc;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint , Color color) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public Line(Point startPoint, Point endPoint, Color color, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
		this.color = color;
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	public boolean contains(int x,int y) {
		return startPoint.distance(x, y) + endPoint.distance(x, y) - length() <=2;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line)obj;
			if(this.startPoint.equals(pomocna.startPoint) 
					&& this.endPoint.equals(pomocna.endPoint))
				return true;
			else 
				return false;
		}else 
			return false;
	}
	
	// Metode pristupa (GET i SET metode):
	public Point getStartPoint() {
		return startPoint; // this.startPoint
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public String toString() {
		return startPoint + "-->" + endPoint;
		// (xStart, yStart) --> (xEnd, yEnd)
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getStartPoint().getX()-2, getStartPoint().getY() -2, 4, 4);
			g.drawRect(getEndPoint().getX() - 2, getEndPoint().getY() - 2, 4, 4);
		}
		
	}

	@Override
	public void moveTo(int x, int y) {
				
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Line)
			return (int) (this.length() - ((Line)o).length());
		return 0;
	}
	
	
}
