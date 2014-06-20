package guiLayer;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.ItemCont;
import modelLayer.Storage;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.*;

import ctrLayer.CategoryCtr;
import ctrLayer.ItemCtr;
import extensions.ItemTableModel;
import extensions.JBlinkLabel;
import extensions.SpaceDocument;

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
	private List<RowFilter<ItemTableModel,Object>> filters;
	private RowFilter<ItemTableModel, Object> rowFilterCompound;
	private RowFilter<ItemTableModel, Object> rfCategory;
	private RowFilter<ItemTableModel, Object> rfStorage;
	private JPopupMenu popupMenu;
	public JButton btnSearch;
	public Item saleItem;
	private JPanel panel_6;
	private JMenuItem mntmDelete;
	private JBlinkLabel lblState;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public ItemGUI(MainGUI mainGUI) {
		this.parent = mainGUI;
		filters = new ArrayList<RowFilter<ItemTableModel,Object>>();
		CategoryCtr cCtr = new CategoryCtr();
		categories = cCtr.getAllCategories();
		ItemCtr iCtr = new ItemCtr();
		storages = new ArrayList<Storage>();
		Storage st = new Storage("Alle");
		storages.add(st);
		storages.addAll(iCtr.getAllStorage());
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
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		
		table.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	mouseListenerTable(e);
		    }
		});
		
		popupMenu = new JPopupMenu();
		mntmDelete = new JMenuItem("Slet Vare");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowindex = table.getSelectedRow();
				int id = (Integer) table.getValueAt(rowindex, 0);
				removeItem(id);
			}
		});
		
		JMenuItem mntmUpdate = new JMenuItem("Ret Vare");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowindex = table.getSelectedRow();
				int id = (Integer) table.getValueAt(rowindex, 0);
				updateItem(id);
			}
		});
		
		popupMenu.add(mntmDelete);
		popupMenu.add(mntmUpdate);
		
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
		cmbStorage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(items.size() <= 0 || items == null){
					showAll();
				}
				changeFiltering();
			}
		});
		cmbStorage.setModel(new DefaultComboBoxModel(storages.toArray()));
		panel_2.add(cmbStorage);
		
		JLabel lblKategori = new JLabel("Kategori");
		panel_2.add(lblKategori);
		
		cmbCategory = new JComboBox<Category>();
		cmbCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(items.size() <= 0 || items == null){
					showAll();
				}
				changeFiltering();
			}
		});
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
		panel_3.setBounds(6, 38, 238, 99);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
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
		
		btnSearch = new JButton("Søg");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchItem();
			}
		});
		panel_5.add(btnSearch, "2, 2, fill, top");
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("Varenavn");
		lblName.setToolTipText("Her indtastes det ønskede vare navn");
		panel_4.add(lblName);
		
		txtName = new JTextField();
		txtName.setDocument(new JTextFieldLimit(100, false, false));
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
		
		lblState = new JBlinkLabel("");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setBounds(6, 6, 238, 14);
		panel.add(lblState);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Opret Vare", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(6, 149, 238, 64);
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
		
		panel_6.setVisible(false);
		mntmDelete.setVisible(false);
	}

	protected void updateItem(int id) {
		ItemCtr iCtr = new ItemCtr();
		Item i = iCtr.getItem(id);
		parent.updateItem(i);
	}

	protected void removeItem(int id) {
		ItemCtr iCtr = new ItemCtr();
		Item i = iCtr.getItem(id);
		iCtr.removeItem(i);
		items.remove(i);
		
		model.refresh(items);
		model.fireTableDataChanged();
	}

	protected void showAll() {
		for(Category c : categories){
			ItemCont iCont = ItemCont.getInstance(c);
			items.addAll(iCont.getAll());
		}
		
		model.refresh(items);
		model.fireTableDataChanged();
	}

	protected void changeFiltering() {
		ArrayList<RowFilter<ItemTableModel,Object>> filters = new ArrayList<RowFilter<ItemTableModel,Object>>();
		RowFilter<ItemTableModel, Object> rfCategory = null;
		RowFilter<ItemTableModel, Object> rfStorage = null;
		if(!cmbStorage.getSelectedItem().toString().equals("Alle")){
			rfStorage = RowFilter.regexFilter(cmbStorage.getSelectedItem().toString(), 6);
		}
		
		if(!cmbCategory.getSelectedItem().toString().equals("Alle")){
			rfCategory = RowFilter.regexFilter(cmbCategory.getSelectedItem().toString(), 7);
		}
		if(rfCategory != null){
			filters.add(rfCategory);
		}
		if(rfStorage != null){
			filters.add(rfStorage);
		}

		if(filters.size() > 0){
			RowFilter<ItemTableModel, Object> rowFilterCompound = RowFilter.andFilter(filters);
			TableRowSorter<ItemTableModel> sorter = new TableRowSorter<ItemTableModel>(model);
			sorter.setRowFilter(rowFilterCompound);
			table.setRowSorter(sorter);
		}else if(filters.isEmpty()){
			table.setRowSorter(null);
		}

		model.refresh(items);
		model.fireTableDataChanged();
	}

	protected void clear(){
		txtName.setText("");
		cmbCategory.setSelectedIndex(0);
		cmbStorage.setSelectedIndex(0);
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
		
		lblState.setText(items.size() + " varer fundet.");
		if(items.size() <= 0){
			lblState.startBlinking(true, true);
		}else{
			lblState.startBlinking(true, false);
		}
		
		model.refresh(items);
		model.fireTableDataChanged();
		
	}
	
	public void update(){
		ItemCtr iCtr = new ItemCtr();
		storages = new ArrayList<Storage>();
		Storage st = new Storage("Alle");
		storages.add(st);
		storages.addAll(iCtr.getAllStorage());
		CategoryCtr cCtr = new CategoryCtr();
		categories = cCtr.getAllCategories();
		
		cmbStorage.setModel(new DefaultComboBoxModel(storages.toArray()));
		cmbCategory.setModel(new DefaultComboBoxModel(categories.toArray()));
	}
	
	private void mouseListenerTable(MouseEvent e) {
		Point p = e.getPoint();
		int rowNumber = table.rowAtPoint(p);
		table.setRowSelectionInterval(rowNumber, rowNumber);
		if(SwingUtilities.isRightMouseButton(e)){
			popupMenu.show(table, e.getX(), e.getY());
		} else if(SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2){
			int rowindex = table.getSelectedRow();
			int id = (Integer) table.getValueAt(rowindex, 0);
			ItemCtr iCtr = new ItemCtr();
			JDialog itemInfo = new ItemInfoDialog(iCtr.getItem(id), parent, this);
			itemInfo.setLocationRelativeTo(parent);
			itemInfo.setVisible(true);
			if(saleItem != null){
				parent.addToSale(saleItem);
				saleItem = null;
			}
		}
	}
	
	public void setAdmin(boolean admin){
		if(admin){
			panel_6.setVisible(true);
			mntmDelete.setVisible(true);
		} else if(!admin){
			panel_6.setVisible(false);
			mntmDelete.setVisible(false);
		}
	}
}
