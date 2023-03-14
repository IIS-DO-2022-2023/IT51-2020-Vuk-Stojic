package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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

public class SortDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldUpperLeftX;
	protected JTextField textFieldWidth;
	protected JTextField textFieldUpperLeftY;
	protected JTextField textFieldHeight;
	protected boolean isOk = false;
	protected boolean error = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SortDialog dialog = new SortDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SortDialog() {
		setTitle("IT 51-2020 Vuk Stojic");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
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
			JLabel lblUpperLeft = new JLabel("Upper Left [X, Y]:");
			GridBagConstraints gbc_lblUpperLeft = new GridBagConstraints();
			gbc_lblUpperLeft.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeft.gridx = 1;
			gbc_lblUpperLeft.gridy = 2;
			contentPanel.add(lblUpperLeft, gbc_lblUpperLeft);
		}
		{
			textFieldUpperLeftX = new JTextField();
			textFieldUpperLeftX.setToolTipText("Coordinate X");
			GridBagConstraints gbc_textFieldUpperLeftX = new GridBagConstraints();
			gbc_textFieldUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldUpperLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpperLeftX.gridx = 3;
			gbc_textFieldUpperLeftX.gridy = 2;
			contentPanel.add(textFieldUpperLeftX, gbc_textFieldUpperLeftX);
			textFieldUpperLeftX.setColumns(10);
		}
		{
			textFieldUpperLeftY = new JTextField();
			textFieldUpperLeftY.setToolTipText("Coordinate Y");
			GridBagConstraints gbc_textFieldUpperLeftY = new GridBagConstraints();
			gbc_textFieldUpperLeftY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUpperLeftY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpperLeftY.gridx = 4;
			gbc_textFieldUpperLeftY.gridy = 2;
			contentPanel.add(textFieldUpperLeftY, gbc_textFieldUpperLeftY);
			textFieldUpperLeftY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.gridwidth = 2;
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 3;
			gbc_textFieldWidth.gridy = 3;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.gridwidth = 2;
			gbc_textFieldHeight.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 3;
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
							
							int checkX = Integer.parseInt(textFieldUpperLeftX.getText());
							int checkY = Integer.parseInt(textFieldUpperLeftY.getText());
							int checkWidth = Integer.parseInt(textFieldWidth.getText());
							int checkHeight = Integer.parseInt(textFieldHeight.getText());
							
							if(checkWidth <= 0 || checkHeight <= 0) {
								
								throw new IllegalArgumentException();
								
							}
							
							
							}catch (Exception badInput){
							
							JOptionPane.showMessageDialog(null, "You need to enter a NUMBER for both the coordinates and the width and height values"
									+ ", AND the width and height values cannot be 0 or negative!");
							error = true;
							
						}
						
						if (!error) {
							isOk = true;
							setVisible(false);
						}
						
						error = false;
						
					}
				});
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
