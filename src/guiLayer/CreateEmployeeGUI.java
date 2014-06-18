package guiLayer;

import javax.swing.JPanel;
import java.awt.Component;
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

import ctrLayer.EmployeeCtr;
import extensions.JBlinkLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.GridLayout;
import javax.swing.SwingConstants;



public class CreateEmployeeGUI extends JPanel {
	private JBlinkLabel lblError;
	private MainGUI parent;
	private Component creator;
	private JTextField txtName;
	private JTextField txtStreet;
	private JTextField txtPostalCode;
	private JTextField txtCity;
	private JTextField txtTlf;
	private JTextField txtEmail;
	private JTextField txtCpr;
	private JTextField txtEmpNr;
	private EmployeeGUI eGUI;
	



	/**
	 * Create the panel.
	 */
	public CreateEmployeeGUI(Component e, MainGUI mainGUI) {
		this.creator = creator;
		this.parent = parent;
		this.eGUI = eGUI;
		buildPanel();
	}
	
	public void buildPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{411, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("center:default:grow"),
				ColumnSpec.decode("max(78dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNavn = new JLabel("Navn");
		lblNavn.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNavn, "1, 1, right, default");
		
		txtName = new JTextField();
		panel.add(txtName, "2, 1, fill, default");
		txtName.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		panel.add(lblAdresse, "1, 2, right, default");
		
		txtStreet = new JTextField();
		panel.add(txtStreet, "2, 2, fill, default");
		txtStreet.setColumns(10);
		
		JLabel lblPostnummer = new JLabel("Postnummer");
		panel.add(lblPostnummer, "1, 3, right, default");
		
		txtPostalCode = new JTextField();
		panel.add(txtPostalCode, "2, 3, fill, default");
		txtPostalCode.setColumns(10);
		
		JLabel lblY = new JLabel("By");
		panel.add(lblY, "1, 4, right, default");
		
		txtCity = new JTextField();
		panel.add(txtCity, "2, 4, fill, default");
		txtCity.setColumns(10);
		
		JLabel lblTlfNr = new JLabel("Tlf nr");
		panel.add(lblTlfNr, "1, 5, right, default");
		
		txtTlf = new JTextField();
		panel.add(txtTlf, "2, 5, fill, default");
		txtTlf.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		panel.add(lblEmail, "1, 6, right, default");
		
		txtEmail = new JTextField();
		panel.add(txtEmail, "2, 6, fill, default");
		txtEmail.setColumns(10);
		
		JLabel lblCprnr = new JLabel("Cprnr");
		panel.add(lblCprnr, "1, 7, right, default");
		
		txtCpr = new JTextField();
		panel.add(txtCpr, "2, 7, fill, default");
		txtCpr.setColumns(10);
		
		JLabel lblMedarbejderNummer = new JLabel("Medarbejder nummer");
		panel.add(lblMedarbejderNummer, "1, 8, right, default");
		
		txtEmpNr = new JTextField();
		panel.add(txtEmpNr, "2, 8, fill, default");
		txtEmpNr.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "1, 10, 2, 1, fill, fill");
		JButton btnAnnuller = new JButton("Annuller");
		btnAnnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parent.switchPane(eGUI);
				getParent().remove(CreateEmployeeGUI.this);
			}
		});
		
		JButton btnCreate = new JButton("Opret");
		btnCreate = new JButton("Opret");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createEmployee();
			}
		});
		panel_1.add(btnCreate);
		panel_1.add(btnAnnuller);
	}

		
	

		

	
	
	

	
	protected void createEmployee() {
		EmployeeCtr eCtr = new EmployeeCtr();
	}

			private boolean validdateField(){
				String name = txtName.getText();
				if (name == null || name.trim().isEmpty()) {
					lblError.setText("Navn må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				String street= txtStreet.getText();
				if (street== null || street.trim().isEmpty()) {
					lblError.setText("Gade må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				String postalCode = txtPostalCode.getText();
				if (postalCode == null || postalCode.trim().isEmpty()) {
					lblError.setText("Postnummer må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				String city = txtCity.getText();
				if (city == null || city.trim().isEmpty()) {
					lblError.setText("By må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				String tlf = txtTlf.getText();
				if (tlf == null || tlf.trim().isEmpty()) {
					lblError.setText("Telefonnummeret må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				String eMail = txtEmail.getText();
				if (eMail == null || eMail.trim().isEmpty()) {
					lblError.setText("E-mail må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				String cpr = txtCpr.getText();
				if (cpr == null || cpr.trim().isEmpty()) {
					lblError.setText("Cprnr må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				String empNr = txtEmpNr.getText();
				if (empNr == null || empNr.trim().isEmpty()) {
					lblError.setText("Medarbejdernummeret må ikke være tomt");
					lblError.startBlinking(true, true);
					return false;
				}
				return true;
			}
	}





