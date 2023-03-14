package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;
import sort.SortDialog;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackFrame extends JFrame {
	
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	StackDialog stackDialog = new StackDialog();
	Rectangle r1 = new Rectangle();
	boolean isEmpty = false;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackFrame() {
		setTitle("IT 51-2020 Vuk Stojic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnAddRect = new JButton("Add Rectangle");
		btnAddRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				stackDialog.textFieldUpperLeftX.setText("");
				stackDialog.textFieldUpperLeftY.setText("");
				stackDialog.textFieldWidth.setText("");
				stackDialog.textFieldHeight.setText("");
				stackDialog.setVisible(true);
				
				if (stackDialog.isOk) {
					
					r1 = new Rectangle(new Point(Integer.valueOf(stackDialog.textFieldUpperLeftX.getText()), Integer.valueOf(stackDialog.textFieldUpperLeftY.getText())), Integer.valueOf(stackDialog.textFieldWidth.getText()), Integer.valueOf(stackDialog.textFieldHeight.getText()));
					dlm.add(0, r1);
					
				}
				
				stackDialog.isOk = false;
				
			}
		});
		GridBagConstraints gbc_btnAddRect = new GridBagConstraints();
		gbc_btnAddRect.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddRect.gridx = 3;
		gbc_btnAddRect.gridy = 1;
		contentPane.add(btnAddRect, gbc_btnAddRect);
		
		JButton btnRemoveRect = new JButton("Remove Rectangle");
		btnRemoveRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(dlm.isEmpty()) {
						
						throw new IllegalArgumentException();
						
					}
					
				}catch(Exception listEmpty){
					
					isEmpty = true;
					JOptionPane.showMessageDialog(null, "The list is empty!");
					
				}
				
				if(!isEmpty) {
					
					stackDialog.textFieldUpperLeftX.setText(String.valueOf(dlm.elementAt(0).getUpperLeftPoint().getX()));
					stackDialog.textFieldUpperLeftY.setText(String.valueOf(dlm.elementAt(0).getUpperLeftPoint().getY()));
					stackDialog.textFieldWidth.setText(String.valueOf(dlm.elementAt(0).getWidth()));
					stackDialog.textFieldHeight.setText(String.valueOf(dlm.elementAt(0).getHeight()));
					stackDialog.textFieldUpperLeftX.setEditable(false);
					stackDialog.textFieldUpperLeftY.setEditable(false);
					stackDialog.textFieldWidth.setEditable(false);
					stackDialog.textFieldHeight.setEditable(false);
					stackDialog.setVisible(true);
					
					if (stackDialog.isOk) {
					
						dlm.remove(0);
						
					}
					
					stackDialog.isOk = false;
					
				}
				
				isEmpty = false;
				
			}
		});
		GridBagConstraints gbc_btnRemoveRect = new GridBagConstraints();
		gbc_btnRemoveRect.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveRect.gridx = 7;
		gbc_btnRemoveRect.gridy = 1;
		contentPane.add(btnRemoveRect, gbc_btnRemoveRect);
		
		JList list = new JList();
		list.setModel(dlm);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 2;
		gbc_list.gridwidth = 8;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 3;
		contentPane.add(list, gbc_list);
	}

}
