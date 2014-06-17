package guiLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import personLayer.Customer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.CustomerCtr;
import extensions.CustomerTableModel;

public class CustomerGUI extends JPanel {
	private JTable table;
	private static final long serialVersionUID = 1L;
	private JPanel searchPanel;
	private JScrollPane tablePane;
	private ArrayList<Customer> c;
	private CustomerTableModel model;
	private JTextField txtCompany;
	public JTextField txtName;
	private JTextField txtTlf;
	private MainGUI parent;
	private JPopupMenu popupMenu;
	public JButton btnFind;
	
	/**
	 * Create the panel.
	 */
	public CustomerGUI(MainGUI mainGUI) {
		this.parent = mainGUI;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{562, 250, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel tablePanel = new JPanel();
		GridBagConstraints gbc_tablePanel = new GridBagConstraints();
		gbc_tablePanel.insets = new Insets(0, 0, 0, 5);
		gbc_tablePanel.fill = GridBagConstraints.BOTH;
		gbc_tablePanel.gridx = 0;
		gbc_tablePanel.gridy = 0;
		add(tablePanel, gbc_tablePanel);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		c = new ArrayList<Customer>();
		model = new CustomerTableModel(c);
		table = new JTable(model);
//		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		
		//added
		popupMenu = new JPopupMenu();
		//addPopup(tablePanel, popupMenu);
		JMenuItem mntmDelete = new JMenuItem("Slet");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowindex = table.getSelectedRow();
				int id = (Integer) table.getValueAt(rowindex, 0);
				removePerson(id);
			}
		});
		JMenuItem mntmUpdate = new JMenuItem("Ret Kundeoplysninger");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowindex = table.getSelectedRow();
				int id = (Integer) table.getValueAt(rowindex, 0);
				updateCustomer(id);
			}
		});
		popupMenu.add(mntmDelete);
		popupMenu.add(mntmUpdate);
		//table.setComponentPopupMenu(popupMenu);

		table.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	mouseListenerTable(e);
		    }
		});
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		tablePanel.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblTest = new JLabel("Kunder");
		lblTest.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblTest);
		
		JPanel searchPanel_1 = new JPanel();
		searchPanel_1.setLayout(null);
		GridBagConstraints gbc_searchPanel_1 = new GridBagConstraints();
		gbc_searchPanel_1.fill = GridBagConstraints.BOTH;
		gbc_searchPanel_1.gridx = 1;
		gbc_searchPanel_1.gridy = 0;
		add(searchPanel_1, gbc_searchPanel_1);
		
		JPanel searchGroupPanel = new JPanel();
		searchGroupPanel.setBorder(new TitledBorder(null, "Find kunde", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		searchGroupPanel.setBounds(10, 22, 240, 162);
		searchPanel_1.add(searchGroupPanel);
		
		JPanel searchGridPanel = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout gl_searchGroupPanel = new GroupLayout(searchGroupPanel);
		gl_searchGroupPanel.setHorizontalGroup(
			gl_searchGroupPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
				.addGroup(gl_searchGroupPanel.createSequentialGroup()
					.addGap(6)
					.addComponent(searchGridPanel, GroupLayout.PREFERRED_SIZE, 222, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_searchGroupPanel.setVerticalGroup(
			gl_searchGroupPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_searchGroupPanel.createSequentialGroup()
					.addComponent(searchGridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JButton btnClear = new JButton("Nulstil");
		panel.add(btnClear, "1, 2, fill, top");
		
		JButton btnFind = new JButton("Søg");
		panel.add(btnFind, "3, 2, fill, top");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCustomer();
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
			}
		});
		searchGridPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				ColumnSpec.decode("55dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),}));
		
		JLabel lblCompany = new JLabel("Virksomhed");
		searchGridPanel.add(lblCompany, "1, 1, fill, fill");
		
		txtCompany = new JTextField();
//		txtCompany.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				if(KeyEvent.VK_ENTER == arg0.getKeyCode()){
//					findCustomer();
//				}
//			}
//		});
		searchGridPanel.add(txtCompany, "2, 1, fill, fill");
		txtCompany.setColumns(10);
		
		JLabel lblName = new JLabel("Navn");
		searchGridPanel.add(lblName, "1, 2, fill, fill");
		
		txtName = new JTextField();
//		txtName.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				if(KeyEvent.VK_ENTER == arg0.getKeyCode()){
//					findCustomer();
//				}
//			}
//		});
		txtName.setColumns(10);
		searchGridPanel.add(txtName, "2, 2, fill, fill");
		
		JLabel lblTlf = new JLabel("Tlf");
		searchGridPanel.add(lblTlf, "1, 3, fill, fill");
		
		txtTlf = new JTextField();
		txtTlf.setColumns(10);
		//TODO Spørg Lau
		txtTlf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(KeyEvent.VK_ENTER == arg0.getKeyCode()){
					findCustomer();
				}
			}
		});
		searchGridPanel.add(txtTlf, "2, 3, fill, fill");
		searchGroupPanel.setLayout(gl_searchGroupPanel);	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Opret Kunde", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 184, 234, 58);
		searchPanel_1.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
		);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("fill:default:grow"),}));
		
		JButton btnPrivate = new JButton("Privat");
		btnPrivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.createPrivateCustomer(CustomerGUI.this);
			}
		});
		panel_2.add(btnPrivate, "1, 1");
		JButton btnBusiness = new JButton("Erhverv");
		btnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.createBusinesssCustomer(CustomerGUI.this);
			}
		});
		panel_2.add(btnBusiness, "2, 1");
		panel_1.setLayout(gl_panel_1);
		//this.getRootPane().setDefaultButton(btnFind);
	}
	
	private void mouseListenerTable(MouseEvent e) {
		Point p = e.getPoint();
		int rowNumber = table.rowAtPoint(p);
		table.setRowSelectionInterval(rowNumber, rowNumber);
		if(SwingUtilities.isRightMouseButton(e)){
			//System.out.println(rowNumber);
			popupMenu.show(table, e.getX(), e.getY());
		} 
		else if(SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2){
			CustomerCtr cCtr = new CustomerCtr();
			int rowindex = table.getSelectedRow();
			int id = (Integer) table.getValueAt(rowindex, 0);
			Customer c = cCtr.findCustomer(id);
			parent.setSelectedToSale(true, c);
			//System.out.println("venstre klik!");
		}
	}

	protected void clearSearch() {
		txtCompany.setText("");
		txtName.setText("");
		txtTlf.setText("");

		c.clear();

		model.refresh(c);
		model.fireTableDataChanged();
	}

	private void findCustomer() {
		ArrayList<Customer> nameArray = new ArrayList<Customer>();
		ArrayList<Customer> phoneArray = new ArrayList<Customer>();
		ArrayList<Customer> temp1Array = new ArrayList<Customer>();
		ArrayList<Customer> temp2Array = new ArrayList<Customer>();

		CustomerCtr cCtr = new CustomerCtr();
		String company = txtCompany.getText();
		String name = txtName.getText();
		String phone = txtTlf.getText();

		c.clear();

		if(company != null && !company.trim().isEmpty()){
			c.addAll(cCtr.searchBusiness(company));
		}
		if(name != null && !name.trim().isEmpty()){
			nameArray = cCtr.searchCustomer(name);
			if(c.size() != 0){
				for(Customer cust : nameArray){
					if(c.contains(cust)){
						temp1Array.add(cust);
					}
				}
				c = temp1Array;
			} else{
				c = nameArray;
			}
		}
		if(phone != null && !phone.trim().isEmpty()){
			phoneArray = cCtr.searchCustomer(phone);
			if(c.size() != 0){
				for(Customer cust : phoneArray){
					if(c.contains(cust)){
						temp2Array.add(cust);
					}
				}
				c = temp2Array;
			} else{
				c = phoneArray;
			}
		}

		
//		if(phone != null && !phone.trim().isEmpty()){
//			c = cCtr.searchCustomer(phone);
//		} else if(name != null && !name.trim().isEmpty()){
//			c = cCtr.searchCustomer(name);
//		} else if(company != null && !company.trim().isEmpty()){
//			c = cCtr.searchBusiness(company);
//		} 
		
//		if(c != null && !c.isEmpty()){
//			txtCompany.setText("");
//			txtName.setText("");
//			txtTlf.setText("");
//		}
		
	    model.refresh(c);
	    model.fireTableDataChanged();
	}
	
	private void removePerson(int id) {
		CustomerCtr cCtr = new CustomerCtr();
		cCtr.removeCustomer(id);
		
		boolean removed = false;
		int i = 0;
		while(i < c.size() && !removed){
			Customer customer = c.get(i);
			if(customer.getId() == id){
				c.remove(customer);
				removed = true;
			}
			i++;
		}
		
		model.refresh(c);
		model.fireTableDataChanged();
		
	}
	
	private void updateCustomer(int id) {
		Customer updateCust = null;
		
		int i = 0;
		boolean found = false;
		while(i < c.size() && !found){
			Customer customer = c.get(i);
			if(customer.getId() == id){
				updateCust = customer;
				found = true;
			}
			i++;
		}
		
		if(updateCust != null){
			if(parent != null){
				CreateCustomerGUI cGUI = new CreateCustomerGUI(updateCust, this, parent);
				parent.addPaneToTab(cGUI, "Ret Kunde");
			}
		}
	}
}
