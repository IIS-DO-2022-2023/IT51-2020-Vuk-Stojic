package mvc;

import java.util.ArrayList;
import java.util.List;

public class DrawingModel {

	private List<Shape> shapes = new ArrayList<Shape>();
	
	
	
	public void add(Shape shape) {
		shapes.add(shape);
	}
	
	public void remove(Shape shape) {
		shapes.remove(shape);
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}
	
}
