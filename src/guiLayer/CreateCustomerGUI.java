package guiLayer;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personLayer.Business;
import personLayer.Customer;
import personLayer.Private;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.CustomerCtr;
import extensions.JBlinkLabel;
import extensions.JTextFieldLimit;
import extensions.KeyListener;

public class CreateCustomerGUI extends JPanel {
	
	private boolean business;
	private boolean isUpdate = false;
	private Component creator;
	private Customer updateCust;
	private JBlinkLabel lblError;
	private JTextField txtCvr;
	private JTextField txtPhone;
	private JTextField txtPictureID;
	private JLabel label;
	private JLabel lblCompany;
	private JLabel lblCpr;
	private JLabel lblCvr;
	private JLabel lblEmail;
	private JLabel lblName;
	private JLabel lblPhoneNr;
	private JLabel lblPictureID;
	private JLabel lblPostCode;
	private JLabel lblStreet;
	private JLabel lblTown;
	private JPanel companyPanel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel privatePanel;
	private JTextField txtCity;
	private JTextField txtCompany;
	private JTextField txtCpr1;
	private JTextField txtCpr2;
	private JTextField txtEmail;
	private JTextField txtPostCode;
	private JTextField txtStreet;
	private MainGUI mainGUI;
	public JButton btnOpret;
	public JTextField txtName;
	
	/**
	 * @wbp.parser.constructor
	 */
	public CreateCustomerGUI(boolean business, Component creator, MainGUI parent) {
		mainGUI = parent;
		this.creator = creator;
		this.business = business;
		buildPanel();
	}
	
	public CreateCustomerGUI(Customer updateCust, Component creator, MainGUI parent) {
		mainGUI = parent;
		this.creator = creator;
		if (updateCust != null) {
			if (updateCust instanceof Business) {
				business = true;
			} else {
				business = false;
			}
			isUpdate = true;
			this.updateCust = updateCust;
			buildPanel();
			insertUpdateDate();
			txtCpr1.setEditable(false);
			txtCpr2.setEditable(false);
		} else {
			getParent().remove(this);
		}
	}
	
	private void buildPanel() {
		
		new KeyListener().addEscapeListenerToTab(creator, mainGUI, this);
		setBounds(new Rectangle(0, 0, 0, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {318, 145, 0};
		gridBagLayout.rowHeights = new int[] {5, 0};
		gridBagLayout.columnWeights = new double[] {0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("156px:grow"),
				ColumnSpec.decode("156px:grow"),},
				new RowSpec[] {
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
						RowSpec.decode("21px"),
						RowSpec.decode("32px:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),}));
		
		lblName = new JLabel("Navn");
		panel_1.add(lblName, "2, 2, fill, fill");
		
		txtName = new JTextField();
		txtName.setDocument(new JTextFieldLimit(100, false, false));
		panel_1.add(txtName, "3, 2, fill, fill");
		
		lblStreet = new JLabel("Gade");
		panel_1.add(lblStreet, "2, 4, left, fill");
		
		txtStreet = new JTextField();
		txtStreet.setDocument(new JTextFieldLimit(100, false, false));
		panel_1.add(txtStreet, "3, 4, fill, fill");
		txtStreet.setColumns(10);
		
		lblTown = new JLabel("By");
		panel_1.add(lblTown, "2, 6, fill, fill");
		
		txtCity = new JTextField();
		txtCity.setDocument(new JTextFieldLimit(100, false, false));
		panel_1.add(txtCity, "3, 6, fill, fill");
		txtCity.setColumns(10);
		
		lblPostCode = new JLabel("PostNr");
		panel_1.add(lblPostCode, "2, 8, fill, fill");
		
		txtPostCode = new JTextField();
		txtPostCode.setDocument(new JTextFieldLimit(6, true, false));
		panel_1.add(txtPostCode, "3, 8, fill, fill");
		txtPostCode.setColumns(10);
		
		lblPhoneNr = new JLabel("Tlf");
		panel_1.add(lblPhoneNr, "2, 10, fill, fill");
		
		txtPhone = new JTextField();
		txtPhone.setDocument(new JTextFieldLimit(8, true, false));
		panel_1.add(txtPhone, "3, 10, fill, fill");
		txtPhone.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		panel_1.add(lblEmail, "2, 12, fill, fill");
		
		txtEmail = new JTextField();
		txtEmail.setDocument(new JTextFieldLimit(100, false, true));
		panel_1.add(txtEmail, "3, 12, fill, fill");
		txtEmail.setColumns(10);
		
		privatePanel = new JPanel();
		panel_1.add(privatePanel, "2, 14, 2, 3, fill, fill");
		privatePanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("156px"),
				ColumnSpec.decode("156px:grow"),},
				new RowSpec[] {
						RowSpec.decode("28px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("28px:grow"),}));
		
		lblPictureID = new JLabel("Billed-Id");
		privatePanel.add(lblPictureID, "1, 1, fill, fill");
		
		txtPictureID = new JTextField();
		txtPictureID.setDocument(new JTextFieldLimit(9, true, false));
		txtPictureID.setColumns(10);
		privatePanel.add(txtPictureID, "2, 1, fill, fill");
		
		lblCpr = new JLabel("Cpr-nummer");
		privatePanel.add(lblCpr, "1, 3, fill, fill");
		
		panel_3 = new JPanel();
		privatePanel.add(panel_3, "2, 3, fill, fill");
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("88px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormFactory.DEFAULT_ROWSPEC,}));
		
		txtCpr1 = new JTextField();
		txtCpr1.setDocument(new JTextFieldLimit(6, true, false));
		txtCpr1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txtCpr1.getText().length() > 5) {
					txtCpr2.requestFocusInWindow();
				}
			}
		});
		panel_3.add(txtCpr1, "1, 1, fill, default");
		txtCpr1.setColumns(10);
		
		label = new JLabel("-");
		panel_3.add(label, "3, 1, right, default");
		
		txtCpr2 = new JTextField();
		txtCpr2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE && txtCpr2.getText().length() == 0) {
					txtCpr1.requestFocusInWindow();
				}
			}
		});
		txtCpr2.setDocument(new JTextFieldLimit(4, true, false));
		panel_3.add(txtCpr2, "5, 1, fill, default");
		txtCpr2.setColumns(10);
		
		companyPanel = new JPanel();
		panel_1.add(companyPanel, "2, 18, 2, 3, fill, fill");
		companyPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("156px"),
				ColumnSpec.decode("156px"),},
				new RowSpec[] {
						RowSpec.decode("28px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("28px"),}));
		
		lblCompany = new JLabel("Firma Navn");
		companyPanel.add(lblCompany, "1, 1, fill, fill");
		
		txtCompany = new JTextField();
		txtCompany.setDocument(new JTextFieldLimit(100, false, false));
		txtCompany.setColumns(10);
		companyPanel.add(txtCompany, "2, 1, fill, fill");
		
		lblCvr = new JLabel("Cvr nummer");
		companyPanel.add(lblCvr, "1, 3, fill, fill");
		
		txtCvr = new JTextField();
		txtCvr.setDocument(new JTextFieldLimit(12, true, false));
		txtCvr.setColumns(10);
		companyPanel.add(txtCvr, "2, 3, fill, fill");
		
		lblError = new JBlinkLabel("");
		panel_1.add(lblError, "2, 21, 2, 1, center, center");
		
		panel = new JPanel();
		panel_1.add(panel, "2, 22, 2, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
				new RowSpec[] {
						RowSpec.decode("fill:28px"),}));
		
		btnOpret = new JButton();
		if (isUpdate) {
			btnOpret.setText("Ret");
		} else {
			btnOpret.setText("Opret");
		}
		panel.add(btnOpret, "1, 1, fill, fill");
		
		JButton btn = new JButton("Anuller");
		panel.add(btn, "3, 1, fill, fill");
		
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!isUpdate) {
					createCustomer();
				} else if (isUpdate) {
					updateCustomer();
				}
			}
			
		});
		
		customerType(business);
		
	}
	
	protected void cancel() {
		int tabIndex = mainGUI.getSelectedTab();
		mainGUI.switchPane(creator);
		getParent().remove(tabIndex);
	}
	
	protected void updateCustomer() {
		validateFields();
		String name = txtName.getText();
		String street = txtStreet.getText();
		String phone = txtPhone.getText();
		String email = txtEmail.getText();
		String city = txtCity.getText();
		String post = txtPostCode.getText();
		
		if (!business) {
			CustomerCtr cCtr = new CustomerCtr();
			String pictureId = txtPictureID.getText();
			cCtr.updateCustomer(updateCust.getId(), name, phone, street, email, city, post, pictureId, null, null);
		} else if (business) {
			CustomerCtr cCtr = new CustomerCtr();
			String company = txtCompany.getText();
			String cvr = txtCvr.getText();
			cCtr.updateCustomer(updateCust.getId(), name, phone, street, email, city, post, null, company, cvr);
		}
		
		mainGUI.switchPane(creator);
		getParent().remove(this);
	}
	
	protected void createCustomer() {
		if (validateFields()) {
			String name = txtName.getText();
			String street = txtStreet.getText();
			String phone = txtPhone.getText();
			String email = txtEmail.getText();
			String city = txtCity.getText();
			String post = txtPostCode.getText();
			
			if (!business) {
				CustomerCtr cCtr = new CustomerCtr();
				String cpr = txtCpr1.getText() + "-" + txtCpr2.getText();
				String pictureId = txtPictureID.getText();
				Customer c = cCtr.createPrivateCustomer(name, phone, street, email, city, post, cpr, pictureId);
				if (creator instanceof SaleGUI) {
					SaleGUI sGUI = (SaleGUI) creator;
					sGUI.setCustomer(c);
				}
			} else if (business) {
				CustomerCtr cCtr = new CustomerCtr();
				String company = txtCompany.getText();
				String cvr = txtCvr.getText();
				Customer c = cCtr.createBusinessCustomer(name, phone, street, email, city, post, company, cvr);
				
				if (creator instanceof SaleGUI) {
					SaleGUI sGUI = (SaleGUI) creator;
					sGUI.setCustomer(c);
				}
			}
			
			mainGUI.switchPane(creator);
			getParent().remove(this);
		}
	}
	
	private boolean validateFields() {
		String pictureId = null;
		String company = null;
		String cvr = null;
		String errorMsg = " må ikke være tomt";
		String name = txtName.getText();
		if (name == null || name.trim().isEmpty()) {
			lblError.setText("Navn" + errorMsg);
			lblError.startBlinking(true, true);
			return false;
		}
		
		String street = txtStreet.getText();
		if (street == null || street.trim().isEmpty()) {
			lblError.setText("Gade" + errorMsg);
			lblError.startBlinking(true, true);
			return false;
		}
		
		String town = txtCity.getText();
		
		if (town == null || town.trim().isEmpty()) {
			lblError.setText("By" + errorMsg);
			lblError.startBlinking(true, true);
			return false;
		}
		
		String post = txtPostCode.getText();
		
		if (post == null || post.trim().isEmpty()) {
			lblError.setText("Post nr" + errorMsg);
			lblError.startBlinking(true, true);
			return false;
		}
		
		String phone = txtPhone.getText();
		if (phone == null || phone.trim().isEmpty()) {
			lblError.setText("Tlf nr" + errorMsg);
			lblError.startBlinking(true, true);
			return false;
		}
		
		String email = txtEmail.getText();
		if (email == null || email.trim().isEmpty()) {
			lblError.setText("Email" + errorMsg);
			lblError.startBlinking(true, true);
			return false;
		}
		
		if (business) {
			company = txtCompany.getText();
			if (company == null || company.trim().isEmpty()) {
				lblError.setText("Virksomhedsnavn" + errorMsg);
				lblError.startBlinking(true, true);
				return false;
			}
			
			cvr = txtCvr.getText();
			if (cvr == null || cvr.trim().isEmpty()) {
				lblError.setText("CVR" + errorMsg);
				lblError.startBlinking(true, true);
				return false;
			}
		}
		
		return true;
	}
	
	private void customerType(boolean business) {
		if (business) {
			companyPanel.setVisible(true);
			privatePanel.setVisible(false);
		} else if (!business) {
			companyPanel.setVisible(false);
			privatePanel.setVisible(true);
		}
	}
	
	private void insertUpdateDate() {
		txtName.setText(updateCust.getName());
		txtStreet.setText(updateCust.getStreet());
		txtCity.setText(updateCust.getCity());
		txtPostCode.setText(updateCust.getPostCode());
		txtPhone.setText(updateCust.getPhoneNr());
		txtEmail.setText(updateCust.getEmail());
		if (updateCust instanceof Business) {
			Business b = (Business) updateCust;
			txtCompany.setText(b.getCompany());
			txtCvr.setText(b.getCvrNr());
		} else if (updateCust instanceof Private) {
			Private p = (Private) updateCust;
			txtPictureID.setText(p.getPictureID());
			String[] cpr = p.getCpr().split("-");
			txtCpr1.setText(cpr[0]);
			txtCpr2.setText(cpr[1]);
		}
	}
}
