package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RectDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldX;
	protected JTextField textFieldY;
	protected JTextField textFieldWidth;
	protected JTextField textFieldHeight;
	protected boolean isOk = false;
	protected Color color = Color.black;
	protected Color innerColor = new Color(0f, 0f, 0f, 0f);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RectDialog dialog = new RectDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RectDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblEntCred = new JLabel("Enter Credentials:");
			GridBagConstraints gbc_lblEntCred = new GridBagConstraints();
			gbc_lblEntCred.insets = new Insets(0, 0, 5, 5);
			gbc_lblEntCred.gridx = 1;
			gbc_lblEntCred.gridy = 0;
			contentPanel.add(lblEntCred, gbc_lblEntCred);
		}
		{
			JLabel lblUpperLeft = new JLabel("Upper Left Point [X, Y]:");
			GridBagConstraints gbc_lblUpperLeft = new GridBagConstraints();
			gbc_lblUpperLeft.anchor = GridBagConstraints.EAST;
			gbc_lblUpperLeft.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeft.gridx = 1;
			gbc_lblUpperLeft.gridy = 2;
			contentPanel.add(lblUpperLeft, gbc_lblUpperLeft);
		}
		{
			textFieldX = new JTextField();
			textFieldX.setToolTipText("X Coordinate");
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 2;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			textFieldY = new JTextField();
			textFieldY.setToolTipText("Y Coordinate");
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 3;
			gbc_textFieldY.gridy = 2;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldWidth.gridx = 2;
			gbc_textFieldWidth.gridy = 3;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 2;
			gbc_textFieldHeight.gridy = 4;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							
							int checkX = Integer.parseInt(textFieldX.getText());
							int checkY = Integer.parseInt(textFieldY.getText());
							int checkWidth = Integer.parseInt(textFieldWidth.getText());
							int checkHeight = Integer.parseInt(textFieldHeight.getText());
							
							if(checkWidth <= 0 || checkHeight <= 0 || checkX < 0 || checkY < 0) {
								
								throw new IllegalArgumentException();
								
							}
							
							isOk = true;
							setVisible(false);	
							
							}catch (Exception badInput){
							
							JOptionPane.showMessageDialog(null, "Invalid input!");
							
						}
					}
				});
				{
					JButton btnChangeColor = new JButton("Change Color");
					btnChangeColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							PnlFrame.rectDialog.color = JColorChooser.showDialog(PnlFrame.rectDialog, "Choose A Color", color);
							
						}
					});
					{
						JButton btnChangeFill = new JButton("Change Fill Color");
						btnChangeFill.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								PnlFrame.rectDialog.innerColor = JColorChooser.showDialog(PnlFrame.rectDialog, "Choose A Color To Fill The Shape", innerColor);
								
							}
						});
						buttonPane.add(btnChangeFill);
					}
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
	
	protected void modifyDialog(Rectangle input) {
		
		textFieldX.setEditable(true);
		textFieldY.setEditable(true);
		textFieldWidth.setEditable(true);
		textFieldHeight.setEditable(true);
		textFieldX.setText(String.valueOf(input.getUpperLeftPoint().getX()));
		textFieldY.setText(String.valueOf(input.getUpperLeftPoint().getY()));
		textFieldWidth.setText(String.valueOf(input.getWidth()));
		textFieldHeight.setText(String.valueOf(input.getHeight()));
		color = input.getColor();
		innerColor = input.getInnerColor();
		setVisible(true);
		
	}

}
