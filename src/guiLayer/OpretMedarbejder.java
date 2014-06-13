package guiLayer;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class OpretMedarbejder extends JPanel {
	private JTextField txtName;
	private JTextField txtStreet;
	private JTextField txtTown;
	private JTextField txtPostalCode;
	private JTextField txtCprNr;
	private JTextField txtEmployeeNr;
	private JTextField txtPassWord;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public OpretMedarbejder() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Opret Medarbejder");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblName = new JLabel("Navn");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 1;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblStreet = new JLabel("Gade");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.anchor = GridBagConstraints.EAST;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 2;
		add(lblStreet, gbc_lblStreet);
		
		txtStreet = new JTextField();
		GridBagConstraints gbc_txtStreet = new GridBagConstraints();
		gbc_txtStreet.insets = new Insets(0, 0, 5, 0);
		gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreet.gridx = 2;
		gbc_txtStreet.gridy = 2;
		add(txtStreet, gbc_txtStreet);
		txtStreet.setColumns(10);
		
		JLabel lblBy = new JLabel("By");
		GridBagConstraints gbc_lblBy = new GridBagConstraints();
		gbc_lblBy.anchor = GridBagConstraints.EAST;
		gbc_lblBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblBy.gridx = 0;
		gbc_lblBy.gridy = 3;
		add(lblBy, gbc_lblBy);
		
		txtTown = new JTextField();
		GridBagConstraints gbc_txtTown = new GridBagConstraints();
		gbc_txtTown.insets = new Insets(0, 0, 5, 0);
		gbc_txtTown.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTown.gridx = 2;
		gbc_txtTown.gridy = 3;
		add(txtTown, gbc_txtTown);
		txtTown.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("PostNr");
		GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
		gbc_lblPostalCode.anchor = GridBagConstraints.EAST;
		gbc_lblPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode.gridx = 0;
		gbc_lblPostalCode.gridy = 4;
		add(lblPostalCode, gbc_lblPostalCode);
		
		txtPostalCode = new JTextField();
		GridBagConstraints gbc_txtPostalCode = new GridBagConstraints();
		gbc_txtPostalCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPostalCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostalCode.gridx = 2;
		gbc_txtPostalCode.gridy = 4;
		add(txtPostalCode, gbc_txtPostalCode);
		txtPostalCode.setColumns(10);
		
		JLabel lblCprNr = new JLabel("CprNr");
		GridBagConstraints gbc_lblCprNr = new GridBagConstraints();
		gbc_lblCprNr.anchor = GridBagConstraints.EAST;
		gbc_lblCprNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblCprNr.gridx = 0;
		gbc_lblCprNr.gridy = 5;
		add(lblCprNr, gbc_lblCprNr);
		
		txtCprNr = new JTextField();
		GridBagConstraints gbc_txtCprNr = new GridBagConstraints();
		gbc_txtCprNr.insets = new Insets(0, 0, 5, 0);
		gbc_txtCprNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCprNr.gridx = 2;
		gbc_txtCprNr.gridy = 5;
		add(txtCprNr, gbc_txtCprNr);
		txtCprNr.setColumns(10);
		
		JLabel lblEmploeeNr = new JLabel("MedarbejderNr");
		GridBagConstraints gbc_lblEmploeeNr = new GridBagConstraints();
		gbc_lblEmploeeNr.anchor = GridBagConstraints.EAST;
		gbc_lblEmploeeNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmploeeNr.gridx = 0;
		gbc_lblEmploeeNr.gridy = 6;
		add(lblEmploeeNr, gbc_lblEmploeeNr);
		
		txtEmployeeNr = new JTextField();
		GridBagConstraints gbc_txtEmployeeNr = new GridBagConstraints();
		gbc_txtEmployeeNr.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmployeeNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmployeeNr.gridx = 2;
		gbc_txtEmployeeNr.gridy = 6;
		add(txtEmployeeNr, gbc_txtEmployeeNr);
		txtEmployeeNr.setColumns(10);
		
		JLabel lblPassword = new JLabel("Kodeord");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 7;
		add(lblPassword, gbc_lblPassword);
		
		txtPassWord = new JTextField();
		GridBagConstraints gbc_txtPassWord = new GridBagConstraints();
		gbc_txtPassWord.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassWord.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassWord.gridx = 2;
		gbc_txtPassWord.gridy = 7;
		add(txtPassWord, gbc_txtPassWord);
		txtPassWord.setColumns(10);
		
		JButton btnOpret = new JButton("Opret");
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createEmployee();
			}
		});
		GridBagConstraints gbc_btnOpret = new GridBagConstraints();
		gbc_btnOpret.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpret.gridx = 0;
		gbc_btnOpret.gridy = 10;
		add(btnOpret, gbc_btnOpret);

	}
	
	    protected void createEmployee() {
	    	
	    
		String name = txtName.getText();
		if (name == null || name.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
	
		String street= txtStreet.getText();
		if (street== null || street.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
		String town = txtTown.getText();
		if (town == null || town.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
		String cprNr = txtCprNr.getText();
		if (cprNr == null || cprNr.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	}
		String employeeNr = txtEmployeeNr.getText();
		if (employeeNr == null || employeeNr.trim().isEmpty()) {
			lblError.setText("feltet m� ikke v�re tomt");
			return;
	
	}
	}
    }
	    
	


