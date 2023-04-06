package mvc;

import java.awt.event.MouseEvent;

public class DrawingController {

	private DrawingModel model;
	private DrawingFrame frame;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	public void setModel(DrawingModel model) {
		this.model = model;
	}
	
	public void mouseClicked(MouseEvent e) {
		
		frame.repaint();
	}
	

}
