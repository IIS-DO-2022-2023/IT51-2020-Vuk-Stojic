package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DrawingFrame extends JFrame {
	protected JToggleButton tglbtnPoint = new JToggleButton("Point");
	protected JToggleButton tglbtnLine = new JToggleButton("Line");
	protected JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	protected JToggleButton tglbtnCircle = new JToggleButton("Circle");
	protected JToggleButton tglbtnDonut = new JToggleButton("Donut");

	private JPanel contentPane;
	private DrawingView view = new DrawingView();
	private DrawingController controller;
	private final ButtonGroup mainButtons = new ButtonGroup();
	private final ButtonGroup shapeButtons = new ButtonGroup();
	private final JToggleButton tglbtnSelect = new JToggleButton("Select");
	private final JButton btnModify = new JButton("Modify");
	private final JButton btnDelete = new JButton("Delete");
	
	public DrawingFrame() {
		
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
				
				
			}
		});
		mainButtons.add(btnDelete);
		
		pnlInterface.add(btnDelete);
		btnDelete.setMnemonic(KeyEvent.VK_DELETE);
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


				
			}
		});
		
		//PnlDrawing pnlDrawing = new PnlDrawing();
		contentPane.add(view, BorderLayout.CENTER);
		shapeButtons.add(tglbtnPoint);
		tglbtnPoint.setMnemonic(KeyEvent.VK_Q);
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		view.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tglbtnPoint.setBackground(Color.WHITE);
		view.add(tglbtnPoint);
		tglbtnPoint.setVisible(false);
		shapeButtons.add(tglbtnLine);
		tglbtnLine.setMnemonic(KeyEvent.VK_W);
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		tglbtnLine.setBackground(Color.WHITE);
		view.add(tglbtnLine);
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
		view.add(tglbtnRectangle);
		tglbtnRectangle.setVisible(false);
		shapeButtons.add(tglbtnCircle);
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		tglbtnCircle.setBackground(Color.WHITE);
		view.add(tglbtnCircle);
		tglbtnCircle.setMnemonic(KeyEvent.VK_R);
		tglbtnCircle.setVisible(false);
		tglbtnDonut.setBackground(Color.WHITE);
		view.add(tglbtnDonut);
		tglbtnDonut.setMnemonic(KeyEvent.VK_T);
		tglbtnDonut.setVisible(false);
		
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseClicked(e);
			}
		});
		getContentPane().add(view, BorderLayout.CENTER);
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
	
	public DrawingView getView() {
		return view;
	}
	
	public void setDrawingController(DrawingController drawingController) {
		this.controller = drawingController;
	}
	
}
