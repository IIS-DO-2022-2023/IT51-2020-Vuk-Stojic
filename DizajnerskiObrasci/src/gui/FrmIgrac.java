package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class FrmIgrac extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JTextField txtUnosIgraca;
	private ButtonGroup btnGroup = new ButtonGroup();
	private JLabel lblIgrac1;
	private JLabel lblIgrac2;
	private JLabel lblIgrac3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIgrac frame = new FrmIgrac();
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
	public FrmIgrac() {
		setTitle("Igrači");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.YELLOW);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Forma za unos igra\u010Da");
		pnlNorth.add(lblNaslov);
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(Color.PINK);
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlCentar.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);
		
		JToggleButton tglbtnIgrac1 = new JToggleButton("Ivanovi\u0107");
		btnGroup.add(tglbtnIgrac1);
		tglbtnIgrac1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblIgrac1.getText());
				if(tglbtnIgrac1.isSelected()) {
					lblIgrac1.setForeground(Color.BLUE);
					lblIgrac2.setForeground(Color.BLACK);
					lblIgrac3.setForeground(Color.BLACK);
				}
				
			}
		});
		GridBagConstraints gbc_tglbtnIgrac1 = new GridBagConstraints();
		gbc_tglbtnIgrac1.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnIgrac1.gridx = 0;
		gbc_tglbtnIgrac1.gridy = 0;
		pnlCentar.add(tglbtnIgrac1, gbc_tglbtnIgrac1);
		
		lblIgrac1 = new JLabel("Branislav Ivanovi\u0107");
		GridBagConstraints gbc_lblIgrac1 = new GridBagConstraints();
		gbc_lblIgrac1.insets = new Insets(0, 0, 5, 5);
		gbc_lblIgrac1.gridx = 1;
		gbc_lblIgrac1.gridy = 0;
		pnlCentar.add(lblIgrac1, gbc_lblIgrac1);
		
		JScrollPane scrPaneListaIgraca = new JScrollPane();
		GridBagConstraints gbc_scrPaneListaIgraca = new GridBagConstraints();
		gbc_scrPaneListaIgraca.gridheight = 3;
		gbc_scrPaneListaIgraca.insets = new Insets(0, 0, 5, 0);
		gbc_scrPaneListaIgraca.fill = GridBagConstraints.BOTH;
		gbc_scrPaneListaIgraca.gridx = 2;
		gbc_scrPaneListaIgraca.gridy = 0;
		pnlCentar.add(scrPaneListaIgraca, gbc_scrPaneListaIgraca);
		
		JList lstIgraci = new JList();
		lstIgraci.setModel(dlm);
		scrPaneListaIgraca.setViewportView(lstIgraci);
		
		JToggleButton tglbtnIgrac2 = new JToggleButton("Mati\u0107");
		btnGroup.add(tglbtnIgrac2);
		tglbtnIgrac2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblIgrac2.getText());
				if(tglbtnIgrac2.isSelected()) {
					lblIgrac1.setForeground(Color.BLACK);
					lblIgrac2.setForeground(Color.BLUE);
					lblIgrac3.setForeground(Color.BLACK);
				}
			}
		});
		GridBagConstraints gbc_tglbtnIgrac2 = new GridBagConstraints();
		gbc_tglbtnIgrac2.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnIgrac2.gridx = 0;
		gbc_tglbtnIgrac2.gridy = 1;
		pnlCentar.add(tglbtnIgrac2, gbc_tglbtnIgrac2);
		
		lblIgrac2 = new JLabel("Nemanja Mati\u0107");
		GridBagConstraints gbc_lblIgrac2 = new GridBagConstraints();
		gbc_lblIgrac2.insets = new Insets(0, 0, 5, 5);
		gbc_lblIgrac2.gridx = 1;
		gbc_lblIgrac2.gridy = 1;
		pnlCentar.add(lblIgrac2, gbc_lblIgrac2);
		
		JToggleButton tglbtnIgrac3 = new JToggleButton("Kolarov");
		btnGroup.add(tglbtnIgrac3);
		tglbtnIgrac3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblIgrac3.getText());
				if(tglbtnIgrac3.isSelected()) {
					lblIgrac1.setForeground(Color.BLACK);
					lblIgrac2.setForeground(Color.BLACK);
					lblIgrac3.setForeground(Color.BLUE);
				}
			}
		});
		GridBagConstraints gbc_tglbtnIgrac3 = new GridBagConstraints();
		gbc_tglbtnIgrac3.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnIgrac3.gridx = 0;
		gbc_tglbtnIgrac3.gridy = 2;
		pnlCentar.add(tglbtnIgrac3, gbc_tglbtnIgrac3);
		
		lblIgrac3 = new JLabel("Aleksandar Kolarov");
		GridBagConstraints gbc_lblIgrac3 = new GridBagConstraints();
		gbc_lblIgrac3.insets = new Insets(0, 0, 5, 5);
		gbc_lblIgrac3.gridx = 1;
		gbc_lblIgrac3.gridy = 2;
		pnlCentar.add(lblIgrac3, gbc_lblIgrac3);
		
	
		JCheckBox chckbxUnosIgraca = new JCheckBox("Unesi igra\u010Da");
		chckbxUnosIgraca.setSelected(true);
		chckbxUnosIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxUnosIgraca.isSelected()) {
					txtUnosIgraca.setVisible(true);
					//txtUnosIgraca.enable();
				}
				else {
					txtUnosIgraca.setVisible(false);
					//txtUnosIgraca.disable();
				}
			}
		});
		chckbxUnosIgraca.setBackground(Color.PINK);
		GridBagConstraints gbc_chckbxUnosIgraca = new GridBagConstraints();
		gbc_chckbxUnosIgraca.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUnosIgraca.gridx = 0;
		gbc_chckbxUnosIgraca.gridy = 3;
		pnlCentar.add(chckbxUnosIgraca, gbc_chckbxUnosIgraca);
		
		txtUnosIgraca = new JTextField();
		txtUnosIgraca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtUnosIgraca.getText());
					txtUnosIgraca.setText("");
				}
			}
		});
		//txtUnosIgraca.setVisible(false);
		GridBagConstraints gbc_txtUnosIgraca = new GridBagConstraints();
		gbc_txtUnosIgraca.insets = new Insets(0, 0, 5, 5);
		gbc_txtUnosIgraca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUnosIgraca.gridx = 1;
		gbc_txtUnosIgraca.gridy = 3;
		pnlCentar.add(txtUnosIgraca, gbc_txtUnosIgraca);
		txtUnosIgraca.setColumns(10);
		
		JLabel lblIgraci = new JLabel("Igraci");
		GridBagConstraints gbc_lblIgraci = new GridBagConstraints();
		gbc_lblIgraci.anchor = GridBagConstraints.EAST;
		gbc_lblIgraci.insets = new Insets(0, 0, 0, 5);
		gbc_lblIgraci.gridx = 0;
		gbc_lblIgraci.gridy = 4;
		pnlCentar.add(lblIgraci, gbc_lblIgraci);
		
		JComboBox cmbIgraci = new JComboBox();
		cmbIgraci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(cmbIgraci.getSelectedItem().toString());
			}
		});
		cmbIgraci.setModel(new DefaultComboBoxModel(new String[] {"Mitrović", "Jović", "Gudelj"}));
		GridBagConstraints gbc_cmbIgraci = new GridBagConstraints();
		gbc_cmbIgraci.insets = new Insets(0, 0, 0, 5);
		gbc_cmbIgraci.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbIgraci.gridx = 1;
		gbc_cmbIgraci.gridy = 4;
		pnlCentar.add(cmbIgraci, gbc_cmbIgraci);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.PINK);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnDodajIgraca = new JButton("Dodaj igrača");
		btnDodajIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgIgrac dlgIgrac = new DlgIgrac();
				dlgIgrac.setVisible(true);
				if(dlgIgrac.isOk) {
					dlm.addElement(dlgIgrac.txtIme.getText() + " " + dlgIgrac.txtPrezime.getText());
				}
			}
		});
		pnlSouth.add(btnDodajIgraca);
		
		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DlgIgrac dlgIgrac = new DlgIgrac();
					String[] split = dlm.getElementAt(lstIgraci.getSelectedIndex()).toString().split(" ");
					if(split.length == 1)
						dlgIgrac.txtPrezime.setText(split[0]);
					else {
						dlgIgrac.txtIme.setText(split[0]);
						dlgIgrac.txtPrezime.setText(split[1]);
					}
					dlgIgrac.setVisible(true);
					System.out.println(dlgIgrac.isOk);
					if(dlgIgrac.isOk) {
						dlm.removeElementAt(lstIgraci.getSelectedIndex());
						dlm.addElement(dlgIgrac.txtIme.getText() + " " + dlgIgrac.txtPrezime.getText());
						
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Morate selektovati igrača.");
				}
				
				
			}
		});
		pnlSouth.add(btnModifikuj);
	}

}
