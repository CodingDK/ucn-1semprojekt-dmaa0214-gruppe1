package guiLayer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personLayer.Customer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.CustomerCtr;
import extensions.JBlinkLabel;
import extensions.JIntegerField;
import extensions.JTextFieldLimit;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateCustomerGUI extends JPanel {
	public JTextField txtName;
	private JTextField txtPostCode;
	private JIntegerField txtPhone;
	private JTextField txtEmail;
	private JTextField txtTown;
	
	private JLabel lblStreet;
	private JLabel lblTown;
	private JLabel lblPostCode;
	private JLabel lblPhoneNr;
	private JLabel lblEmail;
	private JLabel lblName;
	private boolean business;
	private JPanel panel;
	private JPanel panel_1;
	private JBlinkLabel lblError;
	private JTextField txtStreet;
	private JPanel panel_2;
	private JPanel privatePanel;
	private JLabel lblPictureID;
	private JIntegerField txtPictureID;
	private JLabel lblCpr;
	private JPanel companyPanel;
	private JTextField txtCompany;
	private JIntegerField txtCvr;
	private JLabel lblCvr;
	private JLabel lblCompany;
	private SaleGUI saleGUI;
	private JPanel panel_3;
	private JTextField txtCpr2;
	private JTextField txtCpr1;
	private JLabel label;
	private Customer updateCust;
	
	public CreateCustomerGUI(boolean business, SaleGUI saleGUI) {
		this.saleGUI = saleGUI;
		this.business = business;
		buildPanel();
	}
	
	public CreateCustomerGUI(boolean business, Customer updateCust) {
		if(updateCust != null){
			this.saleGUI = saleGUI;
			this.business = business;
			this.updateCust = updateCust;
			buildPanel();
		}else{
			getParent().remove(this);
		}
	}
	
	/**
	 * Create the panel.
	 */
	public CreateCustomerGUI(boolean business) {
		this.business = business;
		buildPanel();
	}
	
	private void buildPanel() {
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
						FormFactory.PREF_ROWSPEC,
						RowSpec.decode("32px:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),}));
		
		lblName = new JLabel("Navn");
		panel_1.add(lblName, "2, 2, fill, fill");
		
		txtName = new JTextField();
		panel_1.add(txtName, "3, 2, fill, fill");
		
		lblStreet = new JLabel("Gade");
		panel_1.add(lblStreet, "2, 4, left, fill");
		
		txtStreet = new JTextField();
		panel_1.add(txtStreet, "3, 4, fill, fill");
		txtStreet.setColumns(10);
		
		lblTown = new JLabel("By");
		panel_1.add(lblTown, "2, 6, fill, fill");
		
		txtTown = new JTextField();
		panel_1.add(txtTown, "3, 6, fill, fill");
		txtTown.setColumns(10);
		
		lblPostCode = new JLabel("PostNr");
		panel_1.add(lblPostCode, "2, 8, fill, fill");
		
		txtPostCode = new JTextField();
		panel_1.add(txtPostCode, "3, 8, fill, fill");
		txtPostCode.setColumns(10);
		
		lblPhoneNr = new JLabel("Tlf");
		panel_1.add(lblPhoneNr, "2, 10, fill, fill");
		
		txtPhone = new JIntegerField();
		panel_1.add(txtPhone, "3, 10, fill, fill");
		txtPhone.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		panel_1.add(lblEmail, "2, 12, fill, fill");
		
		txtEmail = new JTextField();
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
		
		txtPictureID = new JIntegerField();
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
		txtCpr1.setDocument(new JTextFieldLimit(6));
		txtCpr1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(txtCpr1.getText().length() > 5){
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
				if(arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE && txtCpr2.getText().length() == 0){
					txtCpr1.requestFocusInWindow();
				}
			}
		});
		txtCpr2.setDocument(new JTextFieldLimit(4));
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
		txtCompany.setColumns(10);
		companyPanel.add(txtCompany, "2, 1, fill, fill");
		
		lblCvr = new JLabel("Cvr nummer");
		companyPanel.add(lblCvr, "1, 3, fill, fill");
		
		txtCvr = new JIntegerField();
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
		
		JButton btnOpret = new JButton("Opret ");
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
			public void actionPerformed(ActionEvent e) {}
		});
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createCustomer();
			}
			
		});
		
		customerType(business);
		
	}
	
	protected void createCustomer() {
		String cprNr = null;
		String pictureId = null;
		String company = null;
		String cvr = null;
		String cprNr2 = null;
		String errorMsg = " må ikke være tomt";
		String name = txtName.getText();
		if (name == null || name.trim().isEmpty()) {
			lblError.setText("Navn" + errorMsg);
			lblError.startBlinking(true, true);
			return;
		}
		
		String street = txtStreet.getText();
		if (street == null || street.trim().isEmpty()) {
			lblError.setText("Gade" + errorMsg);
			lblError.startBlinking(true, true);
			return;
		}
		
		String town = txtTown.getText();
		
		if (town == null || town.trim().isEmpty()) {
			lblError.setText("By" + errorMsg);
			lblError.startBlinking(true, true);
			return;
		}
		
		String post = txtPostCode.getText();
		
		if (post == null || post.trim().isEmpty()) {
			lblError.setText("Post nr" + errorMsg);
			lblError.startBlinking(true, true);
			return;
		}
		
		String phone = txtPhone.getText();
		if (phone == null || phone.trim().isEmpty()) {
			lblError.setText("Tlf nr" + errorMsg);
			lblError.startBlinking(true, true);
			return;
		}
		
		String email = txtEmail.getText();
		if (email == null || email.trim().isEmpty()) {
			lblError.setText("Email" + errorMsg);
			lblError.startBlinking(true, true);
			return;
		}
		if (!business) {
			pictureId = txtPictureID.getText();
			if (pictureId == null || pictureId.trim().isEmpty()) {
				lblError.setText("Billede ID" + errorMsg);
				lblError.startBlinking(true, true);
				return;
			}
			
			cprNr = txtCpr1.getText();
			if (cprNr == null || cprNr.trim().isEmpty()) {
				lblError.setText("Cpr nr" + errorMsg);
				lblError.startBlinking(true, true);
				return;
			}
			
			cprNr2 = txtCpr2.getText();
			if (cprNr2 == null || cprNr2.trim().isEmpty()) {
				lblError.setText("Cpr nr" + errorMsg);
				lblError.startBlinking(true, true);
				return;
			}
		}
		
		if (business) {
			company = txtCompany.getText();
			if (company == null || company.trim().isEmpty()) {
				lblError.setText("Virksomhedsnavn" + errorMsg);
				lblError.startBlinking(true, true);
				return;
			}
			
			cvr = txtCvr.getText();
			if (cvr == null || cvr.trim().isEmpty()) {
				lblError.setText("CVR" + errorMsg);
				lblError.startBlinking(true, true);
				return;
			}
		}
		
		if (!business) {
			CustomerCtr cCtr = new CustomerCtr();
			String cpr = cprNr + "-" + cprNr2;
			Customer c = cCtr.createPrivateCustomer(name, phone, street, email, town, post, cpr, pictureId);
			
			if (saleGUI != null) {
				saleGUI.setCustomer(c);
			}
		} else if (business) {
			CustomerCtr cCtr = new CustomerCtr();
			Customer c = cCtr.createBusinessCustomer(name, phone, street, email, town, post, company, cvr);
			
			if (saleGUI != null) {
				saleGUI.setCustomer(c);
			}
		}
		getParent().remove(this);
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
	
	private void insertUpdateDate(){
		
	}
	
}
