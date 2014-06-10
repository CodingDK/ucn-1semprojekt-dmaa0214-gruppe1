package uiLayer;

import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import ctrLayer.CustomerCtr;
import personLayer.Customer;

public class CustomerGUI extends JPanel {
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
		c = new ArrayList<Customer>();
		model = new CustomerTableModel();
		table = new JTable(model);		
		table.setBounds(51, 103, 480, 226);
		add(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Find kunde", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(555, 101, 304, 132);
		add(panel);
		
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblVirksomhedsnavn, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtCompany, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNavn, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblTlfN, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtTlf, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVirksomhedsnavn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCompany, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNavn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTlfN, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTlf, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCustomer();
			}
		});

	}
	
	protected void findCustomer() {
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
		model.fireTableDataChanged();
		
	}

	public class CustomerTableModel extends AbstractTableModel{

		private static final long serialVersionUID = 1L;
		ArrayList<Customer> customers = c;

		public int getColumnCount() {
			return 6;
		}

		public int getRowCount() {
			return customers.size();
		}

		public Object getValueAt(int rowIndex, int collIndex) {
			Customer c  = customers.get(rowIndex);
			Object value = null;
			if(collIndex == 0){
				value = c.getName();
			} else if(collIndex == 1){
				value = c.getStreet();
			} else if(collIndex == 2){
				value = c.getCity();
			} else if(collIndex == 3){
				value = c.getPostCode();
			} else if(collIndex == 4){
				value = c.getPhoneNr();
			} else if(collIndex == 5){
				value = c.getEmail();
			} 
			return value;
		}	
		
		public String getColumName(int collIndex){
			String value = null;
			if(collIndex == 0){
				value = "Navn";
			} else if(collIndex == 1){
				value = "Gade";
			} else if(collIndex == 2){
				value = "By";
			} else if(collIndex == 3){
				value = "Postnummer";
			} else if(collIndex == 4){
				value = "Tlf nr";
			} else if(collIndex == 5){
				value = "E-mail";
			} 
			return value;
		}
	}
}
