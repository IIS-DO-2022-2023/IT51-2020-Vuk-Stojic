package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.Point;
import mvc.Rectangle;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortFrame extends JFrame {
	
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	Rectangle r1 = new Rectangle();
	SortDialog sortDialog = new SortDialog();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrame frame = new SortFrame();
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
	public SortFrame() {
		setTitle("IT 51-2020 Vuk Stojic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnAddRect = new JButton("Add Rectangle");
		btnAddRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sortDialog.textFieldUpperLeftX.setText("");
				sortDialog.textFieldUpperLeftY.setText("");
				sortDialog.textFieldWidth.setText("");
				sortDialog.textFieldHeight.setText("");
				sortDialog.setVisible(true);
				
				if (sortDialog.isOk) {
					
					r1 = new Rectangle(new Point(Integer.valueOf(sortDialog.textFieldUpperLeftX.getText()), Integer.valueOf(sortDialog.textFieldUpperLeftY.getText())), Integer.valueOf(sortDialog.textFieldWidth.getText()), Integer.valueOf(sortDialog.textFieldHeight.getText()));
					dlm.addElement(r1);
					
				}
				
			}
		});
		GridBagConstraints gbc_btnAddRect = new GridBagConstraints();
		gbc_btnAddRect.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddRect.gridx = 1;
		gbc_btnAddRect.gridy = 1;
		contentPane.add(btnAddRect, gbc_btnAddRect);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dlm.size() > 1) {
				
				for (int i = 0; i < dlm.size(); i++) {
					for (int j = 0; j < dlm.size() - 1; j++) {
						
						if (dlm.getElementAt(i).area() < dlm.getElementAt(j).area()) {
							
							Rectangle temp = dlm.getElementAt(i);
							dlm.setElementAt(dlm.getElementAt(j), i);
							dlm.setElementAt(temp, j);
									
						}
						
					}
				}
				}
				
				else {
					JOptionPane.showMessageDialog(null, "The list is not big enough!");
				}
				
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.insets = new Insets(0, 0, 5, 0);
		gbc_btnSort.gridx = 9;
		gbc_btnSort.gridy = 1;
		contentPane.add(btnSort, gbc_btnSort);
		
		JList list = new JList();
		list.setModel(dlm);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.gridwidth = 10;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 3;
		contentPane.add(list, gbc_list);
	}

}
