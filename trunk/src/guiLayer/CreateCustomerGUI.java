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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class CreateCustomerGUI extends JPanel {
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
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public CreateCustomerGUI(boolean business) {
		this.business = business;
		setBounds(new Rectangle(0, 0, 0, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{155, 164, 66, 0};
		gridBagLayout.rowHeights = new int[]{29, 28, 28, 28, 28, 28, 28, 28, 0, 0, 0, 0, 28, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("Opret Kunde");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblName = new JLabel("Navn");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
				txtName = new JTextField();
				GridBagConstraints gbc_txtName = new GridBagConstraints();
				gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtName.insets = new Insets(0, 0, 5, 5);
				gbc_txtName.gridx = 1;
				gbc_txtName.gridy = 1;
				add(txtName, gbc_txtName);
		
		
		lblStreet = new JLabel("Gade");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 2;
		add(lblStreet, gbc_lblStreet);
		
		
		
		txtStreet = new JTextField();
		GridBagConstraints gbc_txtStreet = new GridBagConstraints();
		gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreet.insets = new Insets(0, 0, 5, 5);
		gbc_txtStreet.gridx = 1;
		gbc_txtStreet.gridy = 2;
		add(txtStreet, gbc_txtStreet);
		
		lblTown = new JLabel("By");
		GridBagConstraints gbc_lblTown = new GridBagConstraints();
		gbc_lblTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTown.insets = new Insets(0, 0, 5, 5);
		gbc_lblTown.gridx = 0;
		gbc_lblTown.gridy = 3;
		add(lblTown, gbc_lblTown);
		
		txtTown = new JTextField();
		GridBagConstraints gbc_txtTown = new GridBagConstraints();
		gbc_txtTown.insets = new Insets(0, 0, 5, 5);
		gbc_txtTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTown.gridx = 1;
		gbc_txtTown.gridy = 3;
		add(txtTown, gbc_txtTown);
		txtTown.setColumns(10);
		GridBagConstraints gbc_lblPostCode = new GridBagConstraints();
		gbc_lblPostCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPostCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostCode.gridx = 0;
		gbc_lblPostCode.gridy = 4;
		
		lblPostCode = new JLabel("PostNr");
		gbc_lblPostCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostCode.gridx = 0;
		gbc_lblPostCode.gridy = 4;
		add(lblPostCode, gbc_lblPostCode);
		
		txtPostCode = new JTextField();
		GridBagConstraints gbc_txtPostCode = new GridBagConstraints();
		gbc_txtPostCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtPostCode.gridx = 1;
		gbc_txtPostCode.gridy = 4;
		add(txtPostCode, gbc_txtPostCode);
		txtPostCode.setColumns(10);
		
		lblPhoneNr = new JLabel("Tlf");
		GridBagConstraints gbc_lblPhoneNr = new GridBagConstraints();
		gbc_lblPhoneNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNr.gridx = 0;
		gbc_lblPhoneNr.gridy = 5;
		add(lblPhoneNr, gbc_lblPhoneNr);
		
		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone.gridx = 1;
		gbc_txtPhone.gridy = 5;
		add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 6;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		lblPictureId = new JLabel("Billed-Id");
		GridBagConstraints gbc_lblPictureId = new GridBagConstraints();
		gbc_lblPictureId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPictureId.insets = new Insets(0, 0, 5, 5);
		gbc_lblPictureId.gridx = 0;
		gbc_lblPictureId.gridy = 7;
		add(lblPictureId, gbc_lblPictureId);
			//if(!business){
				lblCpr = new JLabel("Cpr-nummer");
				GridBagConstraints gbc_lblCpr = new GridBagConstraints();
				gbc_lblCpr.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblCpr.insets = new Insets(0, 0, 5, 5);
				gbc_lblCpr.gridx = 0;
				gbc_lblCpr.gridy = 8;
				add(lblCpr, gbc_lblCpr);
		//}
		
		txtPictureId = new JTextField();
		GridBagConstraints gbc_txtPictureId = new GridBagConstraints();
		gbc_txtPictureId.insets = new Insets(0, 0, 5, 5);
		gbc_txtPictureId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPictureId.gridx = 1;
		gbc_txtPictureId.gridy = 7;
		add(txtPictureId, gbc_txtPictureId);
		txtPictureId.setColumns(10);
		
		txtCprNr = new JTextField();
		GridBagConstraints gbc_txtCprNr = new GridBagConstraints();
		gbc_txtCprNr.insets = new Insets(0, 0, 5, 5);
		gbc_txtCprNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCprNr.gridx = 1;
		gbc_txtCprNr.gridy = 8;
		add(txtCprNr, gbc_txtCprNr);
		txtCprNr.setColumns(10);
		lblCompany = new JLabel("Firma Navn");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 9;
		add(lblCompany, gbc_lblCompany);
		
		txtCompany = new JTextField();
		GridBagConstraints gbc_txtCompany = new GridBagConstraints();
		gbc_txtCompany.insets = new Insets(0, 0, 5, 5);
		gbc_txtCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCompany.gridx = 1;
		gbc_txtCompany.gridy = 9;
		add(txtCompany, gbc_txtCompany);
		txtCompany.setColumns(10);
		
		lblCvr = new JLabel("Cvr nummer");
		GridBagConstraints gbc_lblCvr = new GridBagConstraints();
		gbc_lblCvr.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCvr.insets = new Insets(0, 0, 5, 5);
		gbc_lblCvr.gridx = 0;
		gbc_lblCvr.gridy = 10;
		add(lblCvr, gbc_lblCvr);
		
		txtCvr = new JTextField();
		GridBagConstraints gbc_txtCvr = new GridBagConstraints();
		gbc_txtCvr.insets = new Insets(0, 0, 5, 5);
		gbc_txtCvr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCvr.gridx = 1;
		gbc_txtCvr.gridy = 10;
		add(txtCvr, gbc_txtCvr);
		txtCvr.setColumns(10);
		
		lblError = new JLabel("");
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblError.gridwidth = 3;
		gbc_lblError.insets = new Insets(0, 0, 5, 0);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 11;
		add(lblError, gbc_lblError);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 12;
		add(panel, gbc_panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JButton btnOpret = new JButton("Opret ");
		panel.add(btnOpret, "1, 2, fill, fill");
		
		JButton btn = new JButton("Anuller");
		panel.add(btn, "3, 2, fill, fill");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOpret.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				createCustomer();
			}
				
			
		});
		

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

