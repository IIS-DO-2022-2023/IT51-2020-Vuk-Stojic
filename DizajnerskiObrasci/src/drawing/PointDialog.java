package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PointDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldX;
	protected JTextField textFieldY;
	protected Color color = Color.black;
	protected JColorChooser colorChooser = new JColorChooser();
	protected boolean isOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PointDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblEntCred = new JLabel("Enter Credentials:");
			GridBagConstraints gbc_lblEntCred = new GridBagConstraints();
			gbc_lblEntCred.insets = new Insets(0, 0, 5, 5);
			gbc_lblEntCred.gridx = 1;
			gbc_lblEntCred.gridy = 1;
			contentPanel.add(lblEntCred, gbc_lblEntCred);
		}
		{
			JLabel lblXCoordinate = new JLabel("X Coordinate:");
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
			gbc_lblXCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinate.gridx = 1;
			gbc_lblXCoordinate.gridy = 3;
			contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.anchor = GridBagConstraints.WEST;
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 3;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblYCoordinate = new JLabel("Y Coordinate:");
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinate.insets = new Insets(0, 0, 0, 5);
			gbc_lblYCoordinate.gridx = 1;
			gbc_lblYCoordinate.gridy = 4;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.anchor = GridBagConstraints.WEST;
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 4;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try{
							
							int checkX = Integer.parseInt(textFieldX.getText());
							int checkY = Integer.parseInt(textFieldY.getText());

							
							if(checkX < 0 || checkY < 0) {
								
								throw new IllegalArgumentException();
								
							}
							
							isOk = true;
							setVisible(false);
							
						} catch(Exception ex) {
							
							JOptionPane.showMessageDialog(null, "Invalid input!");
							
						}
						
					}
				});
				{
					JButton btnChangeColor = new JButton("Change Color");
					btnChangeColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							PnlFrame.pointDialog.color = JColorChooser.showDialog(PnlFrame.pointDialog, "Choose A Color", color);
							
						}
					});
					buttonPane.add(btnChangeColor);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void modifyDialog(Point input) {
		
		textFieldX.setEditable(true);
		textFieldY.setEditable(true);
		textFieldX.setText(String.valueOf(input.getX()));
		textFieldY.setText(String.valueOf(input.getY()));
		setVisible(true);
		
	}

}
