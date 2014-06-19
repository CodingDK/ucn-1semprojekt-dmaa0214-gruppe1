package guiLayer;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ctrLayer.EmployeeCtr;
import exceptionLayer.AlreadyExistException;
import extensions.JBlinkLabel;
import extensions.JTextFieldLimit;
import extensions.KeyListener;
import extensions.SpaceDocument;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import extensions.JIntegerField;
import personLayer.Employee;

public class CreateEmployeeGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JBlinkLabel lblState;
	private MainGUI parent;
	private Component creator;
	public JTextField txtName;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtTlf;
	private JTextField txtEmail;
	private JTextField txtEmpNr;
	private JTextField txtPostalCode;
	private JTextField txtCpr1;
	private JTextField txtCpr2;
	private JTextField txtPassword;
	private JCheckBox chkAdmin;
	private Employee updateEmp;
	public AbstractButton btnCreate;
	private JLabel lblPassword;
	private JLabel lblCprnr;
	private JLabel label;
	
	/**
	 * Create the panel.
	 */
	public CreateEmployeeGUI(Component e, MainGUI mainGUI) {
		this.creator = e;
		this.parent = mainGUI;
		buildPanel();
		btnCreate.setText("Opret");
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public CreateEmployeeGUI(Component e, MainGUI mainGUI, Employee employee) {
		updateEmp = employee;
		this.creator = e;
		this.parent = mainGUI;
		buildPanel();
		lblPassword.setVisible(false);
		txtPassword.setVisible(false);
		txtCpr1.setVisible(false);
		txtCpr2.setVisible(false);
		lblCprnr.setVisible(false);
		label.setVisible(false);
		btnCreate.setText("Ret");
		txtName.setText(employee.getName());
		txtStreet.setText(employee.getStreet());
		txtCity.setText(employee.getCity());
		txtTlf.setText(employee.getPhoneNr());
		txtEmail.setText(employee.getEmail());
		txtEmpNr.setText(employee.getEmployeeNr());
		txtPostalCode.setText(employee.getPostCode());
		chkAdmin.setSelected(employee.getAdmin());
	}
	
	public void buildPanel() {
		new KeyListener().addEscapeListenerToTab(creator, parent, this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {411, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[] {0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {1.0, Double.MIN_VALUE};
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
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:156px:grow"),
				ColumnSpec.decode("156px:grow"),},
				new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("28px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("28px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("28px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("28px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("28px"),
						FormFactory.DEFAULT_ROWSPEC,
						RowSpec.decode("default:grow"),}));
		
		JLabel lblNavn = new JLabel("Navn");
		lblNavn.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNavn, "2, 2, left, default");
		
		txtName = new JTextField();
		txtName.setDocument(new SpaceDocument());
		panel.add(txtName, "3, 2, fill, default");
		txtName.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		panel.add(lblAdresse, "2, 4, left, default");
		
		txtStreet = new JTextField();
		txtStreet.setDocument(new SpaceDocument());
		panel.add(txtStreet, "3, 4, fill, default");
		txtStreet.setColumns(10);
		
		JLabel lblPostnummer = new JLabel("Postnummer");
		panel.add(lblPostnummer, "2, 6, left, default");
		
		txtPostalCode = new JIntegerField();
		panel.add(txtPostalCode, "3, 6, fill, default");
		txtPostalCode.setColumns(10);
		
		JLabel lblY = new JLabel("By");
		panel.add(lblY, "2, 8, left, default");
		
		txtCity = new JTextField();
		txtCity.setDocument(new SpaceDocument());
		panel.add(txtCity, "3, 8, fill, default");
		txtCity.setColumns(10);
		
		JLabel lblTlfNr = new JLabel("Tlf nr");
		panel.add(lblTlfNr, "2, 10, left, default");
		
		txtTlf = new JIntegerField();
		panel.add(txtTlf, "3, 10, fill, default");
		txtTlf.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		panel.add(lblEmail, "2, 12, left, default");
		
		txtEmail = new JTextField();
		txtEmail.setDocument(new SpaceDocument(false));
		panel.add(txtEmail, "3, 12, fill, default");
		txtEmail.setColumns(10);
		
		lblCprnr = new JLabel("Cprnr");
		panel.add(lblCprnr, "2, 14, left, default");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "3, 14, fill, fill");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("88px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormFactory.DEFAULT_ROWSPEC,}));
		
		txtCpr1 = new JTextField();
		txtCpr1.setDocument(new JTextFieldLimit(6, true));
		txtCpr1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txtCpr1.getText().length() > 5) {
					txtCpr2.requestFocusInWindow();
				}
			}
		});
		panel_2.add(txtCpr1, "1, 1, fill, default");
		txtCpr1.setColumns(10);
		
		label = new JLabel("-");
		panel_2.add(label, "3, 1, right, default");
		
		txtCpr2 = new JTextField();
		txtCpr2.setDocument(new JTextFieldLimit(4, true));
		txtCpr2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE && txtCpr2.getText().length() == 0) {
					txtCpr1.requestFocusInWindow();
				}
			}
		});
		panel_2.add(txtCpr2, "5, 1, fill, default");
		txtCpr2.setColumns(10);
		
		JLabel lblMedarbejderNummer = new JLabel("Medarbejder nummer");
		panel.add(lblMedarbejderNummer, "2, 16, left, default");
		
		txtEmpNr = new JIntegerField();
		panel.add(txtEmpNr, "3, 16, fill, default");
		txtEmpNr.setColumns(10);
		
		JLabel lblAdmin = new JLabel("Admin");
		panel.add(lblAdmin, "2, 18, left, default");
		
		chkAdmin = new JCheckBox("");
		chkAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chkAdmin.isSelected()) {
					txtPassword.setEnabled(true);
				} else if (!chkAdmin.isSelected()) {
					txtPassword.setText("");
					txtPassword.setEnabled(false);
				}
			}
		});
		panel.add(chkAdmin, "3, 18, center, default");
		
		lblPassword = new JLabel("Kodeord");
		panel.add(lblPassword, "2, 20, left, default");
		
		txtPassword = new JPasswordField();
		txtPassword.setEnabled(false);
		panel.add(txtPassword, "3, 20, fill, default");
		txtPassword.setColumns(10);
		
		lblState = new JBlinkLabel("");
		panel.add(lblState, "2, 21, 2, 1, center, default");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "2, 22, 2, 1, fill, fill");
		JButton btnAnnuller = new JButton("Annuller");
		btnAnnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.switchPane(creator);
				getParent().remove(CreateEmployeeGUI.this);
			}
		});
		
		btnCreate = new JButton();
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(updateEmp == null){
					createEmployee();
				} else {
					updateEmployee();
				}
			}
		});
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
				new RowSpec[] {
						RowSpec.decode("28px"),}));
		panel_1.add(btnCreate, "1, 1, fill, fill");
		panel_1.add(btnAnnuller, "3, 1, fill, fill");
	}
	
	protected void createEmployee() {
		if(validdateField()){
			String name = txtName.getText();
			String street  = txtStreet.getText();
			String postalCode = txtPostalCode.getText();
			String city = txtCity.getText();
			String tlf = txtTlf.getText();
			String eMail = txtEmail.getText();
			String cpr = txtCpr1.getText() + "-" + txtCpr2.getText();
			String empNr = txtEmpNr.getText();
			String password;
			boolean admin;
			if(chkAdmin.isSelected()){
				admin = true;
				password = txtPassword.getText();
			} else  {
				admin = false;	
				password = null;			
			}
			
			EmployeeCtr eCtr = new EmployeeCtr();
			try {
				Employee e = eCtr.createEmployee(empNr, name, tlf, street, eMail, city, postalCode, cpr, password, admin);
				parent.switchPane(creator);
				getParent().remove(this);
			} catch (AlreadyExistException e) {
				lblState.setText(e.getMessage());
				lblState.startBlinking(true, true);
			}
						
		}		
	}
	
	protected void updateEmployee(){
		
		if(validdateUpdate() ){
			String name = txtName.getText();
			String street  = txtStreet.getText();
			String postalCode = txtPostalCode.getText();
			String city = txtCity.getText();
			String tlf = txtTlf.getText();
			String eMail = txtEmail.getText();
			String empNr = txtEmpNr.getText();
			boolean admin;
			if(chkAdmin.isSelected()){
				admin = true;
			} else  {
				admin = false;			
			}
		EmployeeCtr eCtr = new EmployeeCtr();
		
		eCtr.updateEmployee(updateEmp.getId(), empNr, name, tlf, street, eMail, city, postalCode, admin);	
		} else {
			lblState.setText("Medarbejderen er ikke rettet");
			lblState.startBlinking(true, true);
		}
		parent.switchPane(creator);
		getParent().remove(this);
	}
	
	private boolean validdateField() {
		String name = txtName.getText();
		if (name == null || name.trim().isEmpty()) {
			lblState.setText("Navn må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String street = txtStreet.getText();
		if (street == null || street.trim().isEmpty()) {
			lblState.setText("Gade må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String postalCode = txtPostalCode.getText();
		if (postalCode == null || postalCode.trim().isEmpty()) {
			lblState.setText("Postnummer må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String city = txtCity.getText();
		if (city == null || city.trim().isEmpty()) {
			lblState.setText("By må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String tlf = txtTlf.getText();
		if (tlf == null || tlf.trim().isEmpty()) {
			lblState.setText("Telefonnummeret må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String eMail = txtEmail.getText();
		if (eMail == null || eMail.trim().isEmpty()) {
			lblState.setText("E-mail må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		
		if (txtCpr1.getText().length() != 6 || txtCpr2.getText().length() != 4) {
			lblState.setText("Cprnr er ikke udfyldt korrekt");
			lblState.startBlinking(true, true);
			return false;
		}
		String empNr = txtEmpNr.getText();
		if (empNr == null || empNr.trim().isEmpty()) {
			lblState.setText("Medarbejdernummeret må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		return true;
	}
	
	private boolean validdateUpdate() {
		String name = txtName.getText();
		if (name == null || name.trim().isEmpty()) {
			lblState.setText("Navn må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String street = txtStreet.getText();
		if (street == null || street.trim().isEmpty()) {
			lblState.setText("Gade må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String postalCode = txtPostalCode.getText();
		if (postalCode == null || postalCode.trim().isEmpty()) {
			lblState.setText("Postnummer må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String city = txtCity.getText();
		if (city == null || city.trim().isEmpty()) {
			lblState.setText("By må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String tlf = txtTlf.getText();
		if (tlf == null || tlf.trim().isEmpty()) {
			lblState.setText("Telefonnummeret må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String eMail = txtEmail.getText();
		if (eMail == null || eMail.trim().isEmpty()) {
			lblState.setText("E-mail må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		String empNr = txtEmpNr.getText();
		if (empNr == null || empNr.trim().isEmpty()) {
			lblState.setText("Medarbejdernummeret må ikke være tomt");
			lblState.startBlinking(true, true);
			return false;
		}
		return true;
	}
}
