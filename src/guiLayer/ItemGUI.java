package guiLayer;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import modelLayer.Item;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.ItemCtr;
import extensions.ItemTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ItemGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	public JTextField txtName;
	private ArrayList<Item> items;
	private ItemTableModel model;
	private MainGUI parent;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public ItemGUI(MainGUI mainGUI) {
		this.parent = mainGUI;
		items = new ArrayList<Item>();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 250, 0};
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
		
		JScrollPane scrollPane = new JScrollPane();
		model = new ItemTableModel(items);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setMaxWidth(25);
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblItems = new JLabel("Varer");
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblItems);
		
		JLabel label = new JLabel("?");
		label.setToolTipText("Her ses de søgte varer");
		label.setFont(new Font("SansSerif", Font.BOLD, 12));
		label.setForeground(SystemColor.activeCaption);
		panel_2.add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "S\u00F8g Vare", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(6, 26, 238, 99);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
		);
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JButton btnNewButton = new JButton("Nulstil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		panel_5.add(btnNewButton, "1, 2, fill, top");
		
		JButton btnSg = new JButton("Søg");
		btnSg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchItem();
			}
		});
		panel_5.add(btnSg, "3, 2, fill, top");
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("Vare");
		lblName.setToolTipText("Her indtastes det ønskede vare navn");
		panel_4.add(lblName);
		
		txtName = new JTextField();
		txtName.setToolTipText("Her indtastes det ønskede vare navn");
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchItem();
			}
		});
		panel_4.add(txtName);
		txtName.setColumns(10);
		txtName.requestFocusInWindow();
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblState = new JLabel("");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setBounds(6, 6, 238, 14);
		panel.add(lblState);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Opret Vare", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(6, 137, 238, 64);
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
		);
		
		JButton btnOpretVare = new JButton("Opret Vare");
		btnOpretVare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.createItem();
			}
		});
		panel_7.add(btnOpretVare);
		panel_6.setLayout(gl_panel_6);
		
	}
	
	protected void clear(){
		txtName.setText("");
		items.clear();
		model.refresh(items);
		model.fireTableDataChanged();
	}

	protected void searchItem() {
		ItemCtr iCtr = new ItemCtr();
		String name = txtName.getText();
		if(!name.trim().isEmpty() && name != null){
			items = iCtr.searchItem(name);
		}
		
		model.refresh(items);
		model.fireTableDataChanged();
		
	}
}