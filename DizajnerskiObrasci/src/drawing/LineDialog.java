package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldX1;
	protected JTextField textFieldY1;
	protected JTextField textFieldX2;
	protected JTextField textFieldY2;
	protected boolean isOk = false;
	private boolean error = false;
	protected Color color = Color.black;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LineDialog dialog = new LineDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LineDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			JLabel lblP1Coordinate = new JLabel("Starting Point Coordinates [X, Y]:");
			GridBagConstraints gbc_lblP1Coordinate = new GridBagConstraints();
			gbc_lblP1Coordinate.anchor = GridBagConstraints.EAST;
			gbc_lblP1Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblP1Coordinate.gridx = 1;
			gbc_lblP1Coordinate.gridy = 3;
			contentPanel.add(lblP1Coordinate, gbc_lblP1Coordinate);
		}
		{
			textFieldX1 = new JTextField();
			textFieldX1.setToolTipText("X Coordinate");
			GridBagConstraints gbc_textFieldX1 = new GridBagConstraints();
			gbc_textFieldX1.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX1.gridx = 2;
			gbc_textFieldX1.gridy = 3;
			contentPanel.add(textFieldX1, gbc_textFieldX1);
			textFieldX1.setColumns(10);
		}
		{
			textFieldY1 = new JTextField();
			textFieldY1.setToolTipText("Y Coordinate");
			GridBagConstraints gbc_textFieldY1 = new GridBagConstraints();
			gbc_textFieldY1.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY1.gridx = 3;
			gbc_textFieldY1.gridy = 3;
			contentPanel.add(textFieldY1, gbc_textFieldY1);
			textFieldY1.setColumns(10);
		}
		{
			JLabel lblP2Coordinate = new JLabel("End Point Coordinates [X, Y]:");
			GridBagConstraints gbc_lblP2Coordinate = new GridBagConstraints();
			gbc_lblP2Coordinate.anchor = GridBagConstraints.EAST;
			gbc_lblP2Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblP2Coordinate.gridx = 1;
			gbc_lblP2Coordinate.gridy = 4;
			contentPanel.add(lblP2Coordinate, gbc_lblP2Coordinate);
		}
		{
			textFieldX2 = new JTextField();
			textFieldX2.setToolTipText("X Coordinate");
			GridBagConstraints gbc_textFieldX2 = new GridBagConstraints();
			gbc_textFieldX2.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX2.gridx = 2;
			gbc_textFieldX2.gridy = 4;
			contentPanel.add(textFieldX2, gbc_textFieldX2);
			textFieldX2.setColumns(10);
		}
		{
			textFieldY2 = new JTextField();
			textFieldY2.setToolTipText("Y Coordinate");
			GridBagConstraints gbc_textFieldY2 = new GridBagConstraints();
			gbc_textFieldY2.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY2.gridx = 3;
			gbc_textFieldY2.gridy = 4;
			contentPanel.add(textFieldY2, gbc_textFieldY2);
			textFieldY2.setColumns(10);
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
							
							int checkX1 = Integer.parseInt(textFieldX1.getText());
							int checkY1 = Integer.parseInt(textFieldY1.getText());
							int checkX2 = Integer.parseInt(textFieldX2.getText());
							int checkY2 = Integer.parseInt(textFieldY2.getText());
							Line l1 = new Line(new Point(checkX1, checkY1), new Point(checkX2, checkY2));
							
							if(l1.length() <= 0 || checkX1 < 0 || checkY1 < 0 || checkX2 < 0 || checkY2 < 0) {
								
								throw new IllegalArgumentException();
								
							}
							
						} catch(Exception ex) {
							
							JOptionPane.showMessageDialog(null, "Invalid input!");
							error = true;
							
						}
						
						if(!error) {
						
							isOk = true;
							setVisible(false);
							
						}
						
						error = false;
					}
				});
				{
					JButton btnChangeColor = new JButton("Change Color");
					btnChangeColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							PnlFrame.lineDialog.color = JColorChooser.showDialog(PnlFrame.lineDialog, "Choose A Color", color);
							
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

}
