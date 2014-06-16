package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Storage;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.CategoryCtr;
import ctrLayer.ItemCtr;
import extensions.ItemTableModel;

public class ItemGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	public JTextField txtName;
	private ArrayList<Item> items;
	private ItemTableModel model;
	private MainGUI parent;
	private JComboBox<Storage> cmbStorage;
	private JComboBox<Category> cmbCategory;
	private ArrayList<Category> categories;
	private ArrayList<Storage> storages;
	private TableRowSorter<ItemTableModel> sorter;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public ItemGUI(MainGUI mainGUI) {
		
		this.parent = mainGUI;
		CategoryCtr cCtr = new CategoryCtr();
		categories = cCtr.getAllCategories();
		ItemCtr iCtr = new ItemCtr();
		storages = iCtr.getAllStorage();
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
		sorter = new TableRowSorter<ItemTableModel>(model);
		table.setRowSorter(sorter);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
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
		
		JLabel lblLager = new JLabel("Lager");
		panel_2.add(lblLager);
		
		cmbStorage = new JComboBox<Storage>();
		cmbStorage.setModel(new DefaultComboBoxModel(storages.toArray()));
		panel_2.add(cmbStorage);
		
		JLabel lblKategori = new JLabel("Kategori");
		panel_2.add(lblKategori);
		
		cmbCategory = new JComboBox<Category>();
		cmbCategory.setModel(new DefaultComboBoxModel(categories.toArray()));
		panel_2.add(cmbCategory);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Søg Vare", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(6, 26, 238, 99);
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
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 214, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
							.addGap(6))))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
		);
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
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
		panel_5.add(btnSg, "2, 2, fill, top");
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
	
	public void update(){
		ItemCtr iCtr = new ItemCtr();
		storages = iCtr.getAllStorage();
		CategoryCtr cCtr = new CategoryCtr();
		categories = cCtr.getAllCategories();
		
		cmbStorage.setModel(new DefaultComboBoxModel(storages.toArray()));
		cmbCategory.setModel(new DefaultComboBoxModel(categories.toArray()));
	}
}
