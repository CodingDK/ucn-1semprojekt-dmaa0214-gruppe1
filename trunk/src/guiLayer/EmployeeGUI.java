package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import personLayer.Employee;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.EmployeeCtr;
import extensions.EmployeeTableModel;
import extensions.JBlinkLabel;
import extensions.JIntegerField;

public class EmployeeGUI extends JPanel {
	private JTable table;
	private ArrayList<Employee> employees;
	private ArrayList<Employee> employees2;
	public JTextField txtName;
	private EmployeeTableModel model;
	private MainGUI parent;
	private JPanel panel_6;
	private JBlinkLabel errLabel;
	public JButton btnFind;

	/**
	 * Create the panel.
	 */
	public EmployeeGUI(MainGUI parent) {
		this.parent = parent;
		employees = new ArrayList<Employee>();
		employees2 = new ArrayList<Employee>();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {562, 250, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		model = new EmployeeTableModel(employees);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2, BorderLayout.NORTH);

		JLabel lblMedarbejder = new JLabel("Medarbejder");
		lblMedarbejder.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedarbejder.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblMedarbejder);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Find medarbejder", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 22, 240, 95);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();

		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(0))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				ColumnSpec.decode("max(49dlu;pref):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),}));

		JButton btnClear = new JButton("Nulstil");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_5.add(btnClear, "1, 2, fill, top");
		btnFind = new JButton("Søg");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCustomer();
			}


		});
		panel_5.add(btnFind, "2, 2, fill, top");
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("100px:grow"),
				ColumnSpec.decode("110px:grow"),},
			new RowSpec[] {
				RowSpec.decode("28px"),}));

		JLabel lblName = new JLabel("Navn/ID");
		panel_4.add(lblName, "1, 1, fill, fill");

		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCustomer();
			}
		});
		panel_4.add(txtName, "2, 1, fill, fill");
		txtName.setColumns(10);
		panel_3.setLayout(gl_panel_3);

		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Opret Medarbejder", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 146, 240, 58);
		panel.add(panel_6);


		JButton btnOpretMedarbejder = new JButton("Opret Medarbejder");
		btnOpretMedarbejder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CreateEmployee();
			}
		});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
				gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 234, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
						.addGap(45)
						.addComponent(btnOpretMedarbejder, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addGap(43))
				);
		gl_panel_6.setVerticalGroup(
				gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
						.addComponent(btnOpretMedarbejder)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panel_6.setLayout(gl_panel_6);

		errLabel = new JBlinkLabel("");
		errLabel.setBounds(10, 6, 240, 16);
		panel.add(errLabel);
		panel_6.setVisible(false);
	}

	private void findCustomer() {
		EmployeeCtr eCtr = new EmployeeCtr();
		String name = txtName.getText();
		if(name.trim().length() > 0){
			employees = eCtr.searchEmployee(name);
		}
		model.refresh(employees);
		model.fireTableDataChanged();
		if(employees.size() == 0){
			errLabel.setText("0 medarbejdere fundet.");
			errLabel.startBlinking(true, true);
		}
	}
	public void setAdmin(boolean admin){
		if(admin){
			panel_6.setVisible(true);
		} else if(!admin){
			panel_6.setVisible(false);
		}
	}

	private void clear(){
		txtName.setText("");
		employees.clear();
		model.fireTableDataChanged();
	}
}
