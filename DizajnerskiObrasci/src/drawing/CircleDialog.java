package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldX;
	protected JTextField textFieldRadius;
	protected JTextField textFieldY;
	protected boolean isOk = false;
	private boolean error = false;
	protected Color color = Color.black;
	protected Color innerColor = new Color(0f, 0f, 0f, 0f);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CircleDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
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
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 2;
			gbc_textFieldRadius.gridy = 3;
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
							
							if(checkRadius <= 0 || checkX < 0 || checkY < 0) {
								
								throw new IllegalArgumentException();
								
							}
							
							
							}catch (Exception badInput){
							
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
							
							PnlFrame.circleDialog.color = JColorChooser.showDialog(PnlFrame.circleDialog, "Choose A Color", color);
							
						}
					});
					{
						JButton btnChangeFill = new JButton("Change Fill Color");
						btnChangeFill.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								PnlFrame.circleDialog.innerColor = JColorChooser.showDialog(PnlFrame.circleDialog, "Choose A Color To Fill The Shape", innerColor);
								
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

}
