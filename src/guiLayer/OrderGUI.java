package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import modelLayer.Sale;
import personLayer.Customer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.CustomerCtr;
import ctrLayer.SaleCtr;
import extensions.JBlinkLabel;
import extensions.JTextFieldLimit;
import extensions.OrderTableModel;

public class OrderGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private OrderTableModel model;
	private ArrayList<Sale> sales;
	public JTextField txtName;
	private JTextField txtID;
	public JButton btnSearch;
	private JComboBox<String> comboBox;
	private JBlinkLabel lblState;
	private MainGUI parent;
	
	/**
	 * Create the panel.
	 */
	public OrderGUI(MainGUI parent) {
		this.parent = parent;
		sales = new ArrayList<Sale>();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {555, 121, 0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[] {1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ordreoversigt");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		model = new OrderTableModel(sales);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseListenerTable(e);
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Find kunde", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_6 = new JPanel();
		
		lblState = new JBlinkLabel("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(6)
												.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
										.addComponent(lblState, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(75, Short.MAX_VALUE))
				);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		String[] options = {"Parkeret salg", "Afsluttet salg", "Alle salg", "Søgeresultat"};
		comboBox.setModel(new DefaultComboBoxModel<String>(options));
		
		panel_6.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(100, Short.MAX_VALUE))
				);
		gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		
		btnSearch = new JButton("Søg");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCustomer();
			}
		});
		
		JButton btnClear = new JButton("Nulstil");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInput();
			}
		});
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
				new RowSpec[] {
						RowSpec.decode("28px"),}));
		panel_5.add(btnClear, "1, 1, fill, fill");
		panel_5.add(btnSearch, "2, 1, fill, fill");
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Kundenavn");
		panel_4.add(lblName, "2, 2, right, default");
		
		txtName = new JTextField();
		txtName.setDocument(new JTextFieldLimit(100, false, false));
		panel_4.add(txtName, "4, 2, fill, default");
		txtName.setColumns(10);
		
		JLabel lblKundeId = new JLabel("Kunde ID");
		panel_4.add(lblKundeId, "2, 4, right, default");
		
		txtID = new JTextField();
		txtID.setDocument(new JTextFieldLimit(10, true, false));
		panel_4.add(txtID, "4, 4, fill, top");
		txtID.setColumns(10);
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(gl_panel_1);
		
		update();
	}
	
	public void update() {
		int i = comboBox.getSelectedIndex();
		SaleCtr sCtr = new SaleCtr();
		if (i == 0) {
			sales = sCtr.getParkedSales();
		} else if (i == 1) {
			sales = sCtr.getSales();
			ArrayList<Sale> sales1 = new ArrayList<Sale>();
			for (Sale s : sales) {
				if (s.isDone()) {
					sales1.add(s);
				}
				sales = sales1;
			}
		} else {
			sales = sCtr.getSales();
		}
		model.refresh(sales);
		model.fireTableDataChanged();
	}
	
	private void clearInput() {
		txtID.setText("");
		txtName.setText("");
		comboBox.setSelectedIndex(0);
	}
	
	private void mouseListenerTable(MouseEvent e) {
		Point p = e.getPoint();
		int rowNumber = table.rowAtPoint(p);
		table.setRowSelectionInterval(rowNumber, rowNumber);
		if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
			int rowindex = table.getSelectedRow();
			Sale sko = sales.get(table.convertRowIndexToModel(rowindex));
			if (!sko.isDone()) {
				parent.setSelectedToSale(true, sko);
			}
		}
	}
	
	private void searchCustomer() {
		comboBox.setSelectedIndex(3);
		String name = txtName.getText();
		String strID = txtID.getText();
		
		SaleCtr sCtr = new SaleCtr();
		sales = sCtr.getSales();
		ArrayList<Sale> sales1 = new ArrayList<Sale>();
		CustomerCtr cCtr = new CustomerCtr();
		ArrayList<Customer> customers = cCtr.searchBusiness(name);
		customers.addAll(cCtr.searchCustomer(name));
		if (name != null && !name.trim().isEmpty()) {
			for (Sale s : sales) {
				Customer c = s.getCustomer();
				if (customers.contains(c)) {
					sales1.add(s);
				}
			}
		}
		boolean found = false;
		int i = 0;
		if (strID != null & !strID.trim().isEmpty()) {
			while (!found && i < sales.size()) {
				Sale s = sales.get(i);
				int id = Integer.parseInt(strID);
				if (id != 0) {
					if (s.getId() == id) {
						sales1.add(s);
						found = true;
					}
				}
				i++;
			}
		}
		sales = sales1;
		lblState.setText(sales.size() + " ordre fundet");
		if (sales.size() <= 0) {
			lblState.startBlinking(true, true);
		} else {
			lblState.startBlinking(true, false);
		}
		model.refresh(sales);
		model.fireTableDataChanged();
	}
}
