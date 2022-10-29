package drawing;

import java.awt.Graphics;

import javax.swing.JPanel;

import geometry.Rectangle;
import geometry.Shape;
import geometry.Point;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;

public class PnlDrawing extends JPanel {

	public ArrayList<Shape> listOfShapes = new ArrayList<Shape>();
	
	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
	}

	
	protected void addShape(Shape s) {
		
		listOfShapes.add(s);
		repaint();
		
	}
	
	protected void removeShape(Shape s) {
		
		listOfShapes.remove(s);
		repaint();
		
	}
	
	protected int findSelected() {
		
		for(Shape s : listOfShapes) {
			
			if(s.isSelected())
				return listOfShapes.indexOf(s);
			
			
			else return 0;
		}
		
		return 0;
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		
		super.paint(g);
		
		for(Shape s : listOfShapes) {
			g.setColor(s.getColor());
			s.draw(g);
			g.setColor(Color.BLACK);
		}
		
	}

}
