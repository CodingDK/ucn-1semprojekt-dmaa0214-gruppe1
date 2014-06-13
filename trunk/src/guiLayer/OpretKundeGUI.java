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

import personLayer.Customer;
import ctrLayer.CustomerCtr;

import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class OpretKundeGUI extends JPanel {
	private JTextField txtStreet;
	public JTextField txtName;
	private JTextField txtPostCode;
	private JTextField txtPhone;
	private JTextField txtEmail;
	
	private JTextField txtPictureId;
	private JTextField txtCprNr;
	private JTextField txtTown;
	
	private JLabel lblStreet;
	private JLabel lblTown;
	private JLabel lblPostCode;
	private JLabel lblPhoneNr;
	private JLabel lblEmail;
	private JLabel lblPictureId;
	private JLabel lblCpr;
	private JLabel lblName;
	private JLabel lblCompany;
	private JLabel lblCvr;
	private JTextField txtCompany;
	private JTextField txtCvr;
	private JLabel lblNewLabel;
	private boolean business;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public OpretKundeGUI(boolean business) {
		this.business = business;
		setBounds(new Rectangle(0, 0, 0, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 73, 66, 181, 0};
		gridBagLayout.rowHeights = new int[]{29, 28, 28, 28, 28, 28, 28, 35, 0, 0, 0, 0, 28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("Opret Kunde");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblName = new JLabel("Navn");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);

		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.gridx = 3;
		gbc_txtName.gridy = 1;
		add(txtName, gbc_txtName);
		
		
		lblStreet = new JLabel("Gade");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 1;
		gbc_lblStreet.gridy = 2;
		add(lblStreet, gbc_lblStreet);
		
		
		
		txtStreet = new JTextField();
		GridBagConstraints gbc_txtStreet = new GridBagConstraints();
		gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreet.insets = new Insets(0, 0, 5, 0);
		gbc_txtStreet.gridx = 3;
		gbc_txtStreet.gridy = 2;
		add(txtStreet, gbc_txtStreet);
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
		
		txtTown = new JTextField();
		GridBagConstraints gbc_txtTown = new GridBagConstraints();
		gbc_txtTown.insets = new Insets(0, 0, 5, 0);
		gbc_txtTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTown.gridx = 3;
		gbc_txtTown.gridy = 3;
		add(txtTown, gbc_txtTown);
		txtTown.setColumns(10);
		
		lblPostCode = new JLabel("PostNr");
		gbc_lblPostCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostCode.gridx = 1;
		gbc_lblPostCode.gridy = 4;
		add(lblPostCode, gbc_lblPostCode);
		
		txtPostCode = new JTextField();
		GridBagConstraints gbc_txtPostCode = new GridBagConstraints();
		gbc_txtPostCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPostCode.gridx = 3;
		gbc_txtPostCode.gridy = 4;
		add(txtPostCode, gbc_txtPostCode);
		txtPostCode.setColumns(10);
		
		lblPhoneNr = new JLabel("Tlf");
		GridBagConstraints gbc_lblPhoneNr = new GridBagConstraints();
		gbc_lblPhoneNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNr.gridx = 1;
		gbc_lblPhoneNr.gridy = 5;
		add(lblPhoneNr, gbc_lblPhoneNr);
		
		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhone.gridx = 3;
		gbc_txtPhone.gridy = 5;
		add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 6;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnOpret = new JButton("Opret ");
		btnOpret.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				createCustomer();
			}
				
			
		});
		
		lblPictureId = new JLabel("Billed-Id");
		GridBagConstraints gbc_lblPictureId = new GridBagConstraints();
		gbc_lblPictureId.insets = new Insets(0, 0, 5, 5);
		gbc_lblPictureId.gridx = 1;
		gbc_lblPictureId.gridy = 7;
		add(lblPictureId, gbc_lblPictureId);
		
		txtPictureId = new JTextField();
		GridBagConstraints gbc_txtPictureId = new GridBagConstraints();
		gbc_txtPictureId.insets = new Insets(0, 0, 5, 0);
		gbc_txtPictureId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPictureId.gridx = 3;
		gbc_txtPictureId.gridy = 7;
		add(txtPictureId, gbc_txtPictureId);
		txtPictureId.setColumns(10);
		if(!business){
			lblCpr = new JLabel("Cpr-nummer");
			GridBagConstraints gbc_lblCpr = new GridBagConstraints();
			gbc_lblCpr.insets = new Insets(0, 0, 5, 5);
			gbc_lblCpr.gridx = 1;
			gbc_lblCpr.gridy = 8;
			add(lblCpr, gbc_lblCpr);
			
			txtCprNr = new JTextField();
			GridBagConstraints gbc_txtCprNr = new GridBagConstraints();
			gbc_txtCprNr.insets = new Insets(0, 0, 5, 0);
			gbc_txtCprNr.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCprNr.gridx = 3;
			gbc_txtCprNr.gridy = 8;
			add(txtCprNr, gbc_txtCprNr);
			txtCprNr.setColumns(10);
		}
		lblCompany = new JLabel("Firma Navn");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 1;
		gbc_lblCompany.gridy = 9;
		add(lblCompany, gbc_lblCompany);
		
		txtCompany = new JTextField();
		GridBagConstraints gbc_txtCompany = new GridBagConstraints();
		gbc_txtCompany.insets = new Insets(0, 0, 5, 0);
		gbc_txtCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCompany.gridx = 3;
		gbc_txtCompany.gridy = 9;
		add(txtCompany, gbc_txtCompany);
		txtCompany.setColumns(10);
		
		lblCvr = new JLabel("Cvr nummer");
		GridBagConstraints gbc_lblCvr = new GridBagConstraints();
		gbc_lblCvr.insets = new Insets(0, 0, 5, 5);
		gbc_lblCvr.gridx = 1;
		gbc_lblCvr.gridy = 10;
		add(lblCvr, gbc_lblCvr);
		
		txtCvr = new JTextField();
		GridBagConstraints gbc_txtCvr = new GridBagConstraints();
		gbc_txtCvr.insets = new Insets(0, 0, 5, 0);
		gbc_txtCvr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCvr.gridx = 3;
		gbc_txtCvr.gridy = 10;
		add(txtCvr, gbc_txtCvr);
		txtCvr.setColumns(10);
		
		lblError = new JLabel("");
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 4;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 11;
		add(lblError, gbc_lblError);
		GridBagConstraints gbc_btnOpret = new GridBagConstraints();
		gbc_btnOpret.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpret.gridx = 1;
		gbc_btnOpret.gridy = 12;
		add(btnOpret, gbc_btnOpret);
		
		JButton btn = new JButton("Anuller");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.insets = new Insets(0, 0, 0, 5);
		gbc_btn.gridx = 2;
		gbc_btn.gridy = 12;
		add(btn, gbc_btn);
		

	}

	protected void createCustomer() {
		String name = txtName.getText();
		if (name == null || name.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
		
	    
	 String street = txtStreet.getText();
		if (street == null || street.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
		
	    String town = txtTown.getText();
	   
		if (town == null || town.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
	    
	 
	
	    String phone = txtPhone.getText();
	    if (phone == null || phone.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
    
	    String email = txtEmail.getText();
	    if (email == null || email.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
    
	    String pictureId = txtPictureId.getText();
	    if (pictureId == null || pictureId.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
    
	    String cprNr = txtCprNr.getText();
	    if (cprNr == null || cprNr.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
    
	    
	    String company = txtCompany.getText();
	    if (company == null || company.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
    
	    String cvr = txtCvr.getText();
	    if (cvr == null || cvr.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
	}
	
	
	 
	

	
	
	    
	    
	    
		
	}

