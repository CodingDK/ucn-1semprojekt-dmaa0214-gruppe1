package uiLayer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.AbstractTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import ctrLayer.CustomerCtr;
import personLayer.Customer;

public class CustomerGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel searchPane;
	private JScrollPane tablePane;
	private JTable table;
	private JTextField txtCompany;
	private JTextField txtName;
	private JTextField txtTlf;
	private ArrayList<Customer> c;
	private CustomerTableModel model;

	/**
	 * Create the panel.
	 */
	public CustomerGUI() {
		setLayout(null);
		
		makeTablePane();
		add(tablePane);
		
		makeSearchPane();
		add(searchPane);
	}
	
	private void makeSearchPane() {
		searchPane = new JPanel();
		searchPane.setBorder(new TitledBorder(null, "Find kunde", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPane.setBounds(520, 23, 304, 132);
		JLabel lblVirksomhedsnavn = new JLabel("Virksomhedsnavn");
		
		txtCompany = new JTextField();
		txtCompany.setColumns(10);
		
		JLabel lblNavn = new JLabel("Navn");
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblTlfN = new JLabel("Tlf");
		
		txtTlf = new JTextField();
		txtTlf.setColumns(10);
		
		JButton btnClear = new JButton("Nulstil");
		
		JButton btnFind = new JButton("Søg");
		GroupLayout gl_searchPane = new GroupLayout(searchPane);
		gl_searchPane.setHorizontalGroup(
			gl_searchPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPane.createSequentialGroup()
					.addComponent(lblVirksomhedsnavn, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtCompany, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_searchPane.createSequentialGroup()
					.addComponent(lblNavn, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_searchPane.createSequentialGroup()
					.addComponent(lblTlfN, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtTlf, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_searchPane.createSequentialGroup()
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
		);
		gl_searchPane.setVerticalGroup(
			gl_searchPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPane.createSequentialGroup()
					.addGroup(gl_searchPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVirksomhedsnavn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCompany, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_searchPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNavn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_searchPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTlfN, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTlf, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_searchPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
		);
		searchPane.setLayout(gl_searchPane);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCustomer();
			}
		});		
	}

	private void makeTablePane() {
		c = new ArrayList<Customer>();
		model = new CustomerTableModel(c);
		table = new JTable(model);
		tablePane = new JScrollPane();
		tablePane.setBounds(20, 25, 480, 226);
		tablePane.setViewportView(table);
	}

	private void findCustomer() {
		CustomerCtr cCtr = new CustomerCtr();
		String phone = txtTlf.getText();
		String name = txtName.getText();
		String company = txtCompany.getText();
		
		if(phone != null && !phone.trim().isEmpty()){
			c = cCtr.searchCustomer(phone);
		} else if(name != null && !name.trim().isEmpty()){
			c = cCtr.searchCustomer(name);
		} else if(company != null && !company.trim().isEmpty()){
			c = cCtr.searchCustomer(company);
		} 
	    model.refresh(c);
	    model.fireTableDataChanged();
	}
}
