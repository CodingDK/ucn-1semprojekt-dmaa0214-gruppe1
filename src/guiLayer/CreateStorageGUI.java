package guiLayer;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateStorageGUI extends JPanel {
	private JTextField txtStorageName;
	private JTextField txtStreet;
	private JTextField txtPostalCode;
	private JTextField txtCity;
	private JTextField txtPhoneNr;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public CreateStorageGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 30, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Opret Lager");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblStorageName = new JLabel("LagerNavn");
		GridBagConstraints gbc_lblStorageName = new GridBagConstraints();
		gbc_lblStorageName.insets = new Insets(0, 0, 5, 5);
		gbc_lblStorageName.anchor = GridBagConstraints.EAST;
		gbc_lblStorageName.gridx = 0;
		gbc_lblStorageName.gridy = 1;
		add(lblStorageName, gbc_lblStorageName);
		
		txtStorageName = new JTextField();
		GridBagConstraints gbc_txtStorageName = new GridBagConstraints();
		gbc_txtStorageName.insets = new Insets(0, 0, 5, 5);
		gbc_txtStorageName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStorageName.gridx = 1;
		gbc_txtStorageName.gridy = 1;
		add(txtStorageName, gbc_txtStorageName);
		txtStorageName.setColumns(10);
		
		JLabel lblStreet = new JLabel("Gade");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.anchor = GridBagConstraints.EAST;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 2;
		add(lblStreet, gbc_lblStreet);
		
		txtStreet = new JTextField();
		GridBagConstraints gbc_txtStreet = new GridBagConstraints();
		gbc_txtStreet.insets = new Insets(0, 0, 5, 5);
		gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreet.gridx = 1;
		gbc_txtStreet.gridy = 2;
		add(txtStreet, gbc_txtStreet);
		txtStreet.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("PostNr");
		GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
		gbc_lblPostalCode.anchor = GridBagConstraints.EAST;
		gbc_lblPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode.gridx = 0;
		gbc_lblPostalCode.gridy = 3;
		add(lblPostalCode, gbc_lblPostalCode);
		
		txtPostalCode = new JTextField();
		GridBagConstraints gbc_txtPostalCode = new GridBagConstraints();
		gbc_txtPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtPostalCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostalCode.gridx = 1;
		gbc_txtPostalCode.gridy = 3;
		add(txtPostalCode, gbc_txtPostalCode);
		txtPostalCode.setColumns(10);
		
		JLabel lblCity = new JLabel("By");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 4;
		add(lblCity, gbc_lblCity);
		
		txtCity = new JTextField();
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 1;
		gbc_txtCity.gridy = 4;
		add(txtCity, gbc_txtCity);
		txtCity.setColumns(10);
		
		JLabel lblphoneNr = new JLabel("tlf");
		GridBagConstraints gbc_lblphoneNr = new GridBagConstraints();
		gbc_lblphoneNr.anchor = GridBagConstraints.EAST;
		gbc_lblphoneNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblphoneNr.gridx = 0;
		gbc_lblphoneNr.gridy = 5;
		add(lblphoneNr, gbc_lblphoneNr);
		
		txtPhoneNr = new JTextField();
		GridBagConstraints gbc_txtPhoneNr = new GridBagConstraints();
		gbc_txtPhoneNr.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhoneNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhoneNr.gridx = 1;
		gbc_txtPhoneNr.gridy = 5;
		add(txtPhoneNr, gbc_txtPhoneNr);
		txtPhoneNr.setColumns(10);
		
		JButton btnOpret = new JButton("Opret");
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createStorage();
			}
		});
		GridBagConstraints gbc_btnOpret = new GridBagConstraints();
		gbc_btnOpret.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpret.gridx = 0;
		gbc_btnOpret.gridy = 7;
		add(btnOpret, gbc_btnOpret);

	}
	 
	protected void createStorage (){
		String storageName = txtStorageName.getText();
		if (storageName == null || storageName.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
		
		String street = txtStreet.getText();
		if (street == null || street.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
		
		String postalCode = txtPostalCode.getText();
		if (postalCode == null || postalCode.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
		String city = txtCity.getText();
		if (city == null || city.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
		
		String phoneNr = txtPhoneNr.getText();
		if (phoneNr == null || phoneNr.trim().isEmpty()) {
				lblError.setText("feltet m� ikke v�re tomt");
				return;
		}
		
		
		
	}
}
