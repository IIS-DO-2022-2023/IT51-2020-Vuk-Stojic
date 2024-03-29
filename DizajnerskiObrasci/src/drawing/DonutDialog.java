package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.Donut;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonutDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldX;
	protected JTextField textFieldY;
	protected JTextField textFieldInnerRadius;
	protected JTextField textFieldRadius;
	protected boolean isOk = false;
	protected Color color = Color.black;
	protected Color innerColor = new Color(0f, 0f, 0f, 0f);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DonutDialog dialog = new DonutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DonutDialog() {
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
			JLabel lblCenter = new JLabel("Center Point [X, Y]:");
			GridBagConstraints gbc_lblCenter = new GridBagConstraints();
			gbc_lblCenter.anchor = GridBagConstraints.EAST;
			gbc_lblCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenter.gridx = 1;
			gbc_lblCenter.gridy = 2;
			contentPanel.add(lblCenter, gbc_lblCenter);
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
			JLabel lblInnerRadius = new JLabel("Inner Radius:");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 1;
			gbc_lblInnerRadius.gridy = 3;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textFieldInnerRadius = new JTextField();
			GridBagConstraints gbc_textFieldInnerRadius = new GridBagConstraints();
			gbc_textFieldInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldInnerRadius.gridx = 2;
			gbc_textFieldInnerRadius.gridy = 3;
			contentPanel.add(textFieldInnerRadius, gbc_textFieldInnerRadius);
			textFieldInnerRadius.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 4;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 2;
			gbc_textFieldRadius.gridy = 4;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
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
							int checkRadius = Integer.parseInt(textFieldRadius.getText());
							int checkInnerRadius = Integer.parseInt(textFieldInnerRadius.getText());
							
							if(checkRadius <= 0 || checkInnerRadius <= 0 || checkInnerRadius >= checkRadius || checkX < 0 || checkY < 0) {
								
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
							
							PnlFrame.donutDialog.color = JColorChooser.showDialog(PnlFrame.donutDialog, "Choose A Color", color);
									
						}
					});
					{
						JButton btnFillColor = new JButton("Change Fill Color");
						btnFillColor.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								PnlFrame.donutDialog.innerColor = JColorChooser.showDialog(PnlFrame.donutDialog, "Choose A Color To Fill The Shape", innerColor);
								
							}
						});
						buttonPane.add(btnFillColor);
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
	
	protected void modifyDialog(Donut input) {
		
		textFieldX.setEditable(true);
		textFieldY.setEditable(true);
		textFieldRadius.setEditable(true);
		textFieldInnerRadius.setEditable(true);
		textFieldX.setText(String.valueOf(input.getCenter().getX()));
		textFieldY.setText(String.valueOf(input.getCenter().getY()));
		textFieldRadius.setText(String.valueOf(input.getRadius()));
		textFieldInnerRadius.setText(String.valueOf(input.getInnerRadius()));
		color = input.getColor();
		innerColor = input.getInnerColor();
		setVisible(true);
		
	}

}
