package drawing;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ButtonGroup;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Circle;
import geometry.Donut;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PnlFrame extends JFrame {
	
	protected JToggleButton tglbtnPoint = new JToggleButton("Point");
	protected JToggleButton tglbtnLine = new JToggleButton("Line");
	protected JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	protected JToggleButton tglbtnCircle = new JToggleButton("Circle");
	protected JToggleButton tglbtnDonut = new JToggleButton("Donut");
	protected MouseEvent clickDetails;
	protected static PointDialog pointDialog = new PointDialog();
	protected static LineDialog lineDialog = new LineDialog();
	protected static RectDialog rectDialog = new RectDialog();
	protected static CircleDialog circleDialog = new CircleDialog();
	protected static DonutDialog donutDialog = new DonutDialog();
	protected static PnlDrawing pnlDrawing = new PnlDrawing();
	protected int numOfClicks = 0;
	protected int p1X = 0;
	protected int p1Y = 0;
	protected boolean clickedDelete = false;
	protected boolean clickedModify = false;
	protected int numOfSelects = 0;
	
	private JPanel contentPane;
	private final ButtonGroup mainButtons = new ButtonGroup();
	private final ButtonGroup shapeButtons = new ButtonGroup();
	private final JToggleButton tglbtnSelect = new JToggleButton("Select");
	private final JButton btnModify = new JButton("Modify");
	private final JButton btnDelete = new JButton("Delete");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PnlFrame frame = new PnlFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	protected void toggleVisibility() {
		
		if(!tglbtnPoint.isVisible()) {
			
			tglbtnPoint.setVisible(true);
			tglbtnLine.setVisible(true);
			tglbtnRectangle.setVisible(true);
			tglbtnCircle.setVisible(true);
			tglbtnDonut.setVisible(true);
			
		}
		
		else {
			
			tglbtnPoint.setVisible(false);
			tglbtnLine.setVisible(false);
			tglbtnRectangle.setVisible(false);
			tglbtnCircle.setVisible(false);
			tglbtnDonut.setVisible(false);
			
		}
		
	}
	
	protected void selectShape() {
			
			for (Shape s : pnlDrawing.listOfShapes) {
				
				
				if(s instanceof Point) {
					
					Point temp = (Point) s;
					
					if(s.isSelected()) {
						
						//Modify function
						if(clickedModify) {
							
							pointDialog.textFieldX.setEditable(true);
							pointDialog.textFieldY.setEditable(true);
							pointDialog.textFieldX.setText(String.valueOf(temp.getX()));
							pointDialog.textFieldY.setText(String.valueOf(temp.getY()));
							pointDialog.setVisible(true);
							
							if(pointDialog.isOk) {
								
								pnlDrawing.addShape(new Point(Integer.valueOf(pointDialog.textFieldX.getText()), Integer.valueOf(pointDialog.textFieldY.getText()), pointDialog.color));
								pnlDrawing.removeShape(s);
								numOfSelects--;
								pointDialog.color = Color.black;
								
							}
							
							clickedModify = false;
							pointDialog.isOk = false;
						}
						
						//Delete function
						else if(clickedDelete) {
							
							pnlDrawing.removeShape(s);
							numOfSelects--;
							clickedDelete = false;
							
						}
						
						s.setSelected(false);
						numOfSelects--;
						repaint();
						
					}
					
					//Select Function
					if(s.contains(clickDetails.getX(), clickDetails.getY())) {
						
						s.setSelected(true);
						numOfSelects++;
						
						if(numOfSelects > 1) {
							
							pnlDrawing.listOfShapes.get(pnlDrawing.findSelected()).setSelected(false);
							numOfSelects = 1;
							
						}
						
						repaint();
						
					}
					
			}
				
				if(s instanceof Line) {
					
					Line temp = (Line) s;
					
					if(s.isSelected()) {
						
						s.setSelected(false);
						
						numOfSelects--;
						
						repaint();
						
						//Modify function
						if(clickedModify) {
							
							lineDialog.textFieldX1.setEditable(true);
							lineDialog.textFieldY1.setEditable(true);
							lineDialog.textFieldX2.setEditable(true);
							lineDialog.textFieldY2.setEditable(true);
							lineDialog.textFieldX1.setText(String.valueOf(temp.getStartPoint().getX()));
							lineDialog.textFieldY1.setText(String.valueOf(temp.getStartPoint().getY()));
							lineDialog.textFieldX2.setText(String.valueOf(temp.getEndPoint().getX()));
							lineDialog.textFieldY2.setText(String.valueOf(temp.getEndPoint().getY()));
							lineDialog.setVisible(true);
							
							if(lineDialog.isOk) {
								
								pnlDrawing.addShape(new Line(new Point(Integer.valueOf(lineDialog.textFieldX1.getText()), Integer.valueOf(lineDialog.textFieldY1.getText())), new Point(Integer.valueOf(lineDialog.textFieldX2.getText()), Integer.valueOf(lineDialog.textFieldY2.getText())), lineDialog.color));
								pnlDrawing.removeShape(s);
								numOfSelects--;
								lineDialog.color = Color.black;
								
							}
							
							lineDialog.isOk = false;
							clickedModify = false;
							
						}
						
						//Delete function
						if(clickedDelete) {
							
							pnlDrawing.removeShape(s);
							numOfSelects--;
							clickedDelete = false;
							
						}
						
					}
					
					//Select Function
					if(temp.contains(clickDetails.getX(), clickDetails.getY())) {
							
							s.setSelected(true);
							numOfSelects++;
							
							if(numOfSelects > 1) {
								
								pnlDrawing.listOfShapes.get(pnlDrawing.findSelected()).setSelected(false);
								numOfSelects = 1;
								
							}
							
							repaint();
							
						}
						
					}
				
				if(s instanceof Rectangle) {
					
					Rectangle temp = (Rectangle) s;
					
					if(s.isSelected()) {
						
						s.setSelected(false);
						
						numOfSelects--;
						
						repaint();
						
						//Modify function
						if(clickedModify) {
							
							rectDialog.textFieldX.setEditable(true);
							rectDialog.textFieldY.setEditable(true);
							rectDialog.textFieldWidth.setEditable(true);
							rectDialog.textFieldHeight.setEditable(true);
							rectDialog.textFieldX.setText(String.valueOf(temp.getUpperLeftPoint().getX()));
							rectDialog.textFieldY.setText(String.valueOf(temp.getUpperLeftPoint().getY()));
							rectDialog.textFieldWidth.setText(String.valueOf(temp.getWidth()));
							rectDialog.textFieldHeight.setText(String.valueOf(temp.getHeight()));
							rectDialog.color = temp.getColor();
							rectDialog.innerColor = temp.getInnerColor();
							rectDialog.setVisible(true);
							
							if(rectDialog.isOk) {
								
								pnlDrawing.addShape(new Rectangle(new Point(Integer.valueOf(rectDialog.textFieldX.getText()), Integer.valueOf(rectDialog.textFieldY.getText())), Integer.valueOf(rectDialog.textFieldWidth.getText()), Integer.valueOf(rectDialog.textFieldHeight.getText()), rectDialog.color, rectDialog.innerColor));
								pnlDrawing.removeShape(s);
								numOfSelects--;
								rectDialog.innerColor = new Color(0f, 0f, 0f, 0f);
								rectDialog.color = Color.black;
								
							}
							
							rectDialog.isOk = false;
							clickedModify = false;
							
						}
						
						//Delete function
						if(clickedDelete) {
							
							pnlDrawing.removeShape(s);
							numOfSelects--;
							clickedDelete = false;
							
						}
						
					}
					
					//Select Function
					if(temp.contains(clickDetails.getX(), clickDetails.getY())) {
							
							s.setSelected(true);
							numOfSelects++;
							
							if(numOfSelects > 1) {
								
								pnlDrawing.listOfShapes.get(pnlDrawing.findSelected()).setSelected(false);
								numOfSelects = 1;
								
							}
							
							repaint();
							
						}
						
					}
				
				if(s instanceof Circle && s instanceof Donut == false) {
					
					Circle temp = (Circle) s;
					
					if(s.isSelected()) {
						
						s.setSelected(false);
						
						numOfSelects--;
						
						repaint();
						
						//Modify function
						if(clickedModify) {
							
							circleDialog.textFieldX.setEditable(true);
							circleDialog.textFieldY.setEditable(true);
							circleDialog.textFieldRadius.setEditable(true);
							circleDialog.textFieldX.setText(String.valueOf(temp.getCenter().getX()));
							circleDialog.textFieldY.setText(String.valueOf(temp.getCenter().getY()));
							circleDialog.textFieldRadius.setText(String.valueOf(temp.getRadius()));
							circleDialog.color = temp.getColor();
							circleDialog.innerColor = temp.getInnerColor();
							circleDialog.setVisible(true);
							
							if(circleDialog.isOk) {
								
								pnlDrawing.addShape(new Circle(new Point(Integer.valueOf(circleDialog.textFieldX.getText()), Integer.valueOf(circleDialog.textFieldY.getText())), Integer.valueOf(circleDialog.textFieldRadius.getText()), circleDialog.color, circleDialog.innerColor));
								pnlDrawing.removeShape(s);
								numOfSelects--;
								circleDialog.color = Color.black;
								circleDialog.innerColor = new Color(0f, 0f, 0f, 0f);
								
							}
							
							circleDialog.isOk = false;
							clickedModify = false;
							
						}
						
						//Delete Function
						if(clickedDelete) {
							
							pnlDrawing.removeShape(s);
							numOfSelects--;
							clickedDelete = false;
							
						}
						
					}
					
					//Select Function
					if(temp.contains(clickDetails.getX(), clickDetails.getY())) {
							
							s.setSelected(true);
							numOfSelects++;
							
							if(numOfSelects > 1) {
								
								pnlDrawing.listOfShapes.get(pnlDrawing.findSelected()).setSelected(false);
								numOfSelects = 1;
								
							}
							
							repaint();
							
						}
						
					}
				
				if(s instanceof Donut) {
					
					Donut temp = (Donut) s;
					
					if(s.isSelected()) {
						
						s.setSelected(false);
						
						numOfSelects--;
						
						repaint();
						
						//Modify Function
						if(clickedModify) {
							
							donutDialog.textFieldX.setEditable(true);
							donutDialog.textFieldY.setEditable(true);
							donutDialog.textFieldRadius.setEditable(true);
							donutDialog.textFieldInnerRadius.setEditable(true);
							donutDialog.textFieldX.setText(String.valueOf(temp.getCenter().getX()));
							donutDialog.textFieldY.setText(String.valueOf(temp.getCenter().getY()));
							donutDialog.textFieldRadius.setText(String.valueOf(temp.getRadius()));
							donutDialog.textFieldInnerRadius.setText(String.valueOf(temp.getInnerRadius()));
							donutDialog.color = temp.getColor();
							donutDialog.innerColor = temp.getInnerColor();
							donutDialog.setVisible(true);
							
							if(donutDialog.isOk) {
								
								pnlDrawing.addShape(new Donut((new Point(Integer.valueOf(donutDialog.textFieldX.getText()), Integer.valueOf(donutDialog.textFieldY.getText()))), Integer.valueOf(donutDialog.textFieldRadius.getText()), Integer.valueOf(donutDialog.textFieldInnerRadius.getText()), donutDialog.color, donutDialog.innerColor));

								pnlDrawing.removeShape(s);
								numOfClicks--;
								donutDialog.color = Color.black;
								circleDialog.innerColor = Color.white;
								
							}
							
							donutDialog.isOk = false;
							clickedModify = false;
							
						}
						
						//Delete Function
						else if(clickedDelete) {
							
							pnlDrawing.removeShape(s);
							numOfSelects--;
							clickedDelete = false;
							
						}
						
					}
					
					//Select Function
					if(temp.contains(clickDetails.getX(), clickDetails.getY())) {
						
							s.setSelected(true);
							numOfSelects++;
							
							if(numOfSelects > 1) {
								
								pnlDrawing.listOfShapes.get(pnlDrawing.findSelected()).setSelected(false);
								numOfSelects = 1;
								
							}
							
							repaint();
							
						}
						
					}
				
				
		}
		
	}
	

	/**
	 * Create the frame.
	 */
	public PnlFrame() {
		setTitle("IT 51-2020 Vuk Stojic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(new Dimension(800, 600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlInterface = new JPanel();
		pnlInterface.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInterface.setBackground(new Color(230, 230, 250));
		contentPane.add(pnlInterface, BorderLayout.NORTH);
		
		JToggleButton tglbtnDraw = new JToggleButton("Draw");
		mainButtons.add(tglbtnDraw);
		tglbtnDraw.setMnemonic(KeyEvent.VK_D);
		tglbtnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnDelete.setEnabled(false);
				btnModify.setEnabled(false);
				toggleVisibility();
				
			}
		});
		pnlInterface.add(tglbtnDraw);
		mainButtons.add(tglbtnSelect);
		tglbtnSelect.setMnemonic(KeyEvent.VK_S);
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnModify.setEnabled(true);
				btnDelete.setEnabled(true);
				
				if(tglbtnPoint.isVisible())
					toggleVisibility();
				
			}
		});
		
		pnlInterface.add(tglbtnSelect);
		mainButtons.add(btnModify);
		
		pnlInterface.add(btnModify);
		btnModify.setEnabled(false);
		btnModify.setMnemonic(KeyEvent.VK_M);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clickedModify = true;
				selectShape();
				
			}
		});
		mainButtons.add(btnDelete);
		
		pnlInterface.add(btnDelete);
		btnDelete.setMnemonic(KeyEvent.VK_DELETE);
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clickedDelete = true;
				selectShape();
				
				if(tglbtnDraw.isSelected()) {
					
					toggleVisibility();
					tglbtnDraw.setSelected(false);
					
				}
				
			}
		});
		
		//PnlDrawing pnlDrawing = new PnlDrawing();
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		shapeButtons.add(tglbtnPoint);
		tglbtnPoint.setMnemonic(KeyEvent.VK_Q);
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		pnlDrawing.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tglbtnPoint.setBackground(Color.WHITE);
		pnlDrawing.add(tglbtnPoint);
		tglbtnPoint.setVisible(false);
		shapeButtons.add(tglbtnLine);
		tglbtnLine.setMnemonic(KeyEvent.VK_W);
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		tglbtnLine.setBackground(Color.WHITE);
		pnlDrawing.add(tglbtnLine);
		tglbtnLine.setVisible(false);
		shapeButtons.add(tglbtnDonut);
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		shapeButtons.add(tglbtnRectangle);
		tglbtnRectangle.setMnemonic(KeyEvent.VK_E);
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		tglbtnRectangle.setBackground(Color.WHITE);
		pnlDrawing.add(tglbtnRectangle);
		tglbtnRectangle.setVisible(false);
		shapeButtons.add(tglbtnCircle);
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		tglbtnCircle.setBackground(Color.WHITE);
		pnlDrawing.add(tglbtnCircle);
		tglbtnCircle.setMnemonic(KeyEvent.VK_R);
		tglbtnCircle.setVisible(false);
		tglbtnDonut.setBackground(Color.WHITE);
		pnlDrawing.add(tglbtnDonut);
		tglbtnDonut.setMnemonic(KeyEvent.VK_T);
		tglbtnDonut.setVisible(false);
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				clickDetails = e;
				
				if(tglbtnSelect.isSelected())
					selectShape();
				
				
				if(tglbtnDraw.isSelected()) {
					
					//Point drawing
					if(tglbtnPoint.isSelected()) {
						
						Point p1 = new Point(e.getX(), e.getY());
						
						pointDialog.textFieldX.setText(String.valueOf(e.getX()));
						pointDialog.textFieldY.setText(String.valueOf(e.getY()));
						pointDialog.textFieldX.setEditable(false);
						pointDialog.textFieldY.setEditable(false);
						pnlDrawing.addShape(p1);
						pointDialog.setVisible(true);
						pnlDrawing.addShape(new Point(p1.getX(), p1.getY(), pointDialog.color));
						pointDialog.color = Color.black;
						pnlDrawing.removeShape(p1);
						if(!pointDialog.isOk)
							pnlDrawing.removeShape(new Point(e.getX(), e.getY()));
						pointDialog.isOk = false;
						
					}
					
					//Line drawing
					if(tglbtnLine.isSelected()) {
						
						numOfClicks++;
						
						if(numOfClicks == 1) {
						
							lineDialog.textFieldX1.setText(String.valueOf(e.getX()));
							lineDialog.textFieldY1.setText(String.valueOf(e.getY()));
							lineDialog.textFieldX1.setEditable(false);
							lineDialog.textFieldY1.setEditable(false);
							p1X = e.getX();
							p1Y = e.getY();
							toggleVisibility();
							tglbtnDraw.setEnabled(false);
							tglbtnSelect.setEnabled(false);
							
						}
						
						else if (numOfClicks == 2){
							
							lineDialog.textFieldX2.setText(String.valueOf(e.getX()));
							lineDialog.textFieldY2.setText(String.valueOf(e.getY()));
							lineDialog.textFieldX2.setEditable(false);
							lineDialog.textFieldY2.setEditable(false);
							Line l1 = new Line(new Point(p1X, p1Y), new Point(e.getX(), e.getY()));
							pnlDrawing.addShape(l1);
							numOfClicks = 0;
							lineDialog.setVisible(true);
							pnlDrawing.addShape(new Line(new Point(p1X, p1Y), new Point(e.getX(), e.getY()), lineDialog.color));
							lineDialog.color = Color.black;
							pnlDrawing.removeShape(l1);
							selectShape();
							if(!lineDialog.isOk)
								pnlDrawing.removeShape(new Line(new Point(p1X, p1Y), new Point(e.getX(), e.getY())));
							lineDialog.isOk = false;
							toggleVisibility();
							tglbtnDraw.setEnabled(true);
							tglbtnSelect.setEnabled(true);
							
						}
						
					}
					
					//Rectangle drawing
					if(tglbtnRectangle.isSelected()) {
						
						rectDialog.textFieldX.setText(String.valueOf(e.getX()));
						rectDialog.textFieldY.setText(String.valueOf(e.getY()));
						rectDialog.textFieldX.setEditable(false);
						rectDialog.textFieldY.setEditable(false);
						rectDialog.textFieldWidth.setText("");
						rectDialog.textFieldHeight.setText("");
						rectDialog.setVisible(true);
						
						if(rectDialog.isOk) {
							
							pnlDrawing.addShape(new Rectangle((new Point(e.getX(), e.getY())), Integer.valueOf(rectDialog.textFieldWidth.getText()), Integer.valueOf(rectDialog.textFieldHeight.getText()), rectDialog.color, rectDialog.innerColor));
							rectDialog.innerColor = new Color(0f, 0f, 0f, 0f);
							
						}
						
						rectDialog.color = Color.black;
						rectDialog.isOk = false;
						
					}
					
					//Circle drawing
					if(tglbtnCircle.isSelected()) {
						
						circleDialog.textFieldX.setText(String.valueOf(e.getX()));
						circleDialog.textFieldY.setText(String.valueOf(e.getY()));
						circleDialog.textFieldX.setEditable(false);
						circleDialog.textFieldY.setEditable(false);
						circleDialog.textFieldRadius.setText("");
						circleDialog.setVisible(true);
						
						if(circleDialog.isOk) {
							
							pnlDrawing.addShape(new Circle((new Point(e.getX(), e.getY())), Integer.valueOf(circleDialog.textFieldRadius.getText()), circleDialog.color, circleDialog.innerColor));
							circleDialog.innerColor = new Color(0f, 0f, 0f, 0f);
							
						}
						
						circleDialog.color = Color.black;
						circleDialog.isOk = false;
						
					}
					
					//Donut drawing
					if(tglbtnDonut.isSelected()) {
						
						donutDialog.textFieldX.setText(String.valueOf(e.getX()));
						donutDialog.textFieldY.setText(String.valueOf(e.getY()));
						donutDialog.textFieldX.setEditable(false);
						donutDialog.textFieldY.setEditable(false);
						donutDialog.textFieldRadius.setText("");
						donutDialog.textFieldInnerRadius.setText("");
						donutDialog.setVisible(true);
						
						if(donutDialog.isOk) {
							
							pnlDrawing.addShape(new Donut((new Point(e.getX(), e.getY())), Integer.valueOf(donutDialog.textFieldRadius.getText()), Integer.valueOf(donutDialog.textFieldInnerRadius.getText()), donutDialog.color, donutDialog.innerColor));
							circleDialog.innerColor = new Color(0f, 0f, 0f, 0f);
						}
						
						
						donutDialog.color = Color.black;
						donutDialog.isOk = false;
					}
					
				}
				
				
				
				}
			
			
		});
		
		
		}
	

}
