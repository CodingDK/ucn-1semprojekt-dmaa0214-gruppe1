package guiLayer;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class OpretKundeGUI extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtOpretKunde;
	
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_2;
	
	private JLabel lblStreet;
	private JLabel lblTown;
	private JLabel lblPostCode;
	private JLabel lblPhoneNr;
	private JLabel lblEmail;
	private JLabel lblPictureId;
	private JLabel lblCpr;
	private JLabel lblName;

	/**
	 * Create the panel.
	 */
	public OpretKundeGUI() {
		setBounds(new Rectangle(0, 0, 0, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 73, 66, 181, 0};
		gridBagLayout.rowHeights = new int[]{29, 28, 28, 28, 28, 28, 28, 35, 0, 28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtOpretKunde = new JTextField();
		txtOpretKunde.setBackground(SystemColor.menu);
		txtOpretKunde.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOpretKunde.setText("Opret Kunde");
		GridBagConstraints gbc_txtOpretKunde = new GridBagConstraints();
		gbc_txtOpretKunde.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOpretKunde.insets = new Insets(0, 0, 5, 0);
		gbc_txtOpretKunde.gridx = 3;
		gbc_txtOpretKunde.gridy = 0;
		add(txtOpretKunde, gbc_txtOpretKunde);
		txtOpretKunde.setColumns(10);
		
		lblName = new JLabel("Navn");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		
		
		lblStreet = new JLabel("Gade");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 1;
		gbc_lblStreet.gridy = 2;
		add(lblStreet, gbc_lblStreet);
		
		
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		GridBagConstraints gbc_lblPostCode = new GridBagConstraints();
		gbc_lblPostCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostCode.gridx = 1;
		gbc_lblPostCode.gridy = 4;
		
		lblTown = new JLabel("By");
		GridBagConstraints gbc_lblTown = new GridBagConstraints();
		gbc_lblTown.insets = new Insets(0, 0, 5, 5);
		gbc_lblTown.gridx = 1;
		gbc_lblTown.gridy = 3;
		add(lblTown, gbc_lblTown);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 3;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblPostCode = new JLabel("PostNr");
		gbc_lblPostCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostCode.gridx = 1;
		gbc_lblPostCode.gridy = 4;
		add(lblPostCode, gbc_lblPostCode);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 4;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblPhoneNr = new JLabel("Tlf");
		GridBagConstraints gbc_lblPhoneNr = new GridBagConstraints();
		gbc_lblPhoneNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNr.gridx = 1;
		gbc_lblPhoneNr.gridy = 5;
		add(lblPhoneNr, gbc_lblPhoneNr);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 5;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 6;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnOpret = new JButton("Opret ");
		btnOpret.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		lblPictureId = new JLabel("Billed-Id");
		GridBagConstraints gbc_lblPictureId = new GridBagConstraints();
		gbc_lblPictureId.insets = new Insets(0, 0, 5, 5);
		gbc_lblPictureId.gridx = 1;
		gbc_lblPictureId.gridy = 7;
		add(lblPictureId, gbc_lblPictureId);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 7;
		add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		lblCpr = new JLabel("Cpr-nummer");
		GridBagConstraints gbc_lblCpr = new GridBagConstraints();
		gbc_lblCpr.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpr.gridx = 1;
		gbc_lblCpr.gridy = 8;
		add(lblCpr, gbc_lblCpr);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 8;
		add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		GridBagConstraints gbc_btnOpret = new GridBagConstraints();
		gbc_btnOpret.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpret.gridx = 1;
		gbc_btnOpret.gridy = 9;
		add(btnOpret, gbc_btnOpret);
		
		JButton btnAnuller = new JButton("Anuller");
		btnAnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAnuller = new GridBagConstraints();
		gbc_btnAnuller.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnuller.gridx = 2;
		gbc_btnAnuller.gridy = 9;
		add(btnAnuller, gbc_btnAnuller);
		

	}
}
