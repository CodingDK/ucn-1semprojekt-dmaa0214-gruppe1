package uiLayer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import ctrLayer.CustomerCtr;
import extensions.CustomerTableModel;
import personLayer.Customer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

public class Test extends JPanel {
	private JTable table;
	private static final long serialVersionUID = 1L;
	private JPanel searchPanel;
	private JScrollPane tablePane;
	private ArrayList<Customer> c;
	private CustomerTableModel model;
	private JTextField txtCompany;
	private JTextField txtName;
	private JTextField txtTlf;
	
	/**
	 * Create the panel.
	 */
	public Test() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{406, 238, 0};
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
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		tablePanel.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblTest = new JLabel("Kunder");
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
		searchGroupPanel.setBounds(10, 22, 222, 144);
		searchPanel_1.add(searchGroupPanel);
		
		JPanel searchGridPanel = new JPanel();
		GroupLayout gl_searchGroupPanel = new GroupLayout(searchGroupPanel);
		gl_searchGroupPanel.setHorizontalGroup(
			gl_searchGroupPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(searchGridPanel, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
		);
		gl_searchGroupPanel.setVerticalGroup(
			gl_searchGroupPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(searchGridPanel, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
		);
		searchGridPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCompany = new JLabel("Virksomhedsnavn");
		searchGridPanel.add(lblCompany);
		
		txtCompany = new JTextField();
		searchGridPanel.add(txtCompany);
		txtCompany.setColumns(10);
		
		JLabel lblName = new JLabel("Navn");
		searchGridPanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		searchGridPanel.add(txtName);
		
		JLabel lblTlf = new JLabel("Tlf");
		searchGridPanel.add(lblTlf);
		
		txtTlf = new JTextField();
		txtTlf.setColumns(10);
		searchGridPanel.add(txtTlf);
		
		JButton btnClear = new JButton("Nulstil");
		searchGridPanel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
			}
		});
		
		JButton btnFind = new JButton("Søg");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findCustomer();
			}
		});	
		searchGridPanel.add(btnFind);
		searchGroupPanel.setLayout(gl_searchGroupPanel);
		
		
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
