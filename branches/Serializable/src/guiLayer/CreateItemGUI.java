package guiLayer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelLayer.Category;
import modelLayer.Item;
import modelLayer.Storage;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.CategoryCtr;
import ctrLayer.ItemCtr;
import extensions.JBlinkLabel;
import extensions.JDoubleField;
import extensions.JIntegerField;
import extensions.KeyListener;
import extensions.SpaceDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class CreateItemGUI extends JPanel {
	private JIntegerField txtAmount;
	private JDoubleField txtSalePrice;
	private JDoubleField txtPurchasePrice;
	private JIntegerField txtBulk;
	private JDoubleField txtBulkPrice;
	private JTextField txtLocation;
	private JIntegerField txtMin;
	private JIntegerField txtMax;
	public JTextField txtName;
	private JComboBox<Storage> cmbStorage;
	private JComboBox<Category> cmbCategory;
	private MainGUI mainGUI;
	private ItemGUI iGUI;
	private JBlinkLabel lblState;
	private Item item;
	private boolean isUpdate;
	private JButton btnCreate;
	
	/**
	 * Create the panel.
	 */
	public CreateItemGUI(MainGUI parent, ItemGUI iGUI, Item item) {
		this.mainGUI = parent;
		this.iGUI = iGUI;
		makePanels();
		if(item != null){
			this.item = item;
			isUpdate =  true;
			txtAmount.setText("" + item.getAmount());
			txtBulk.setText(item.getBulk() + "");
			txtBulkPrice.setText(item.getBulkSalePrice() + "");
			txtLocation.setText(item.getLocation());
			txtMin.setText(item.getMin() + "");
			txtMax.setText(item.getMax() + "");
			txtName.setText(item.getName());
			txtPurchasePrice.setText(item.getPurchasePrice() + "");
			txtSalePrice.setText(item.getSalePrice() + "");
			cmbCategory.setSelectedItem(item.getCategory());
			cmbStorage.setSelectedItem(item.getStorage());
			btnCreate.setText("Ret");
		}else{
			isUpdate = false;
		}
		new KeyListener().addEscapeListenerToTab(iGUI, mainGUI, this);
	}
	
	protected void makePanels(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{296, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("155px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("164px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				RowSpec.decode("28px"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JLabel lblName = new JLabel("Navn");
		panel_2.add(lblName, "2, 1, left, fill");
		
		txtName = new JTextField();
		txtName.setDocument(new SpaceDocument());
		txtName.setColumns(10);
		panel_2.add(txtName, "4, 1, fill, fill");
		
		JLabel lblAmount = new JLabel("Mængde");
		panel_2.add(lblAmount, "2, 2, fill, fill");
		
		txtAmount = new JIntegerField();
		txtAmount.setColumns(10);
		panel_2.add(txtAmount, "4, 2, fill, fill");
		
		JLabel lblSalePrice = new JLabel("Salgs Pris");
		panel_2.add(lblSalePrice, "2, 3, fill, fill");
		
		txtSalePrice = new JDoubleField();
		txtSalePrice.setColumns(10);
		panel_2.add(txtSalePrice, "4, 3, fill, fill");
		
		JLabel lblPurchasePrice = new JLabel("Indkøbs Pris");
		panel_2.add(lblPurchasePrice, "2, 4, fill, fill");
		
		txtPurchasePrice = new JDoubleField();
		txtPurchasePrice.setColumns(10);
		panel_2.add(txtPurchasePrice, "4, 4, fill, fill");
		
		JLabel lblBulk = new JLabel("Bulk");
		panel_2.add(lblBulk, "2, 5, fill, fill");
		
		txtBulk = new JIntegerField();
		txtBulk.setColumns(10);
		panel_2.add(txtBulk, "4, 5, fill, fill");
		
		JLabel lblBulkPrice = new JLabel("Bulk Pris");
		panel_2.add(lblBulkPrice, "2, 6, fill, fill");
		
		txtBulkPrice = new JDoubleField();
		txtBulkPrice.setColumns(10);
		panel_2.add(txtBulkPrice, "4, 6, fill, fill");
		
		JLabel lblLocation = new JLabel("Lokation");
		panel_2.add(lblLocation, "2, 7, fill, fill");
		
		txtLocation = new JTextField();
		txtLocation.setDocument(new SpaceDocument());
		txtLocation.setColumns(10);
		panel_2.add(txtLocation, "4, 7, fill, fill");
		
		JLabel lblStorage = new JLabel("Lager");
		panel_2.add(lblStorage, "2, 8, left, fill");
		
		cmbStorage = new JComboBox<Storage>();
		ItemCtr iCtr = new ItemCtr();
		ArrayList<Storage> stors = iCtr.getAllStorage();
		cmbStorage.setModel(new DefaultComboBoxModel(stors.toArray()));
		panel_2.add(cmbStorage, "4, 8, fill, default");
		
		JLabel lblMax = new JLabel("Min Lagerbeholdning");
		panel_2.add(lblMax, "2, 9, fill, fill");
		
		txtMin = new JIntegerField();
		txtMin.setColumns(10);
		panel_2.add(txtMin, "4, 9, fill, fill");
		
		JLabel lblMin = new JLabel("Max Lagerbeholdning");
		panel_2.add(lblMin, "2, 10, fill, fill");
		
		txtMax = new JIntegerField();
		txtMax.setColumns(10);
		panel_2.add(txtMax, "4, 10, fill, fill");
		
		JLabel lblCategory = new JLabel("Kategori");
		panel_2.add(lblCategory, "2, 11, left, fill");
		
		cmbCategory = new JComboBox<Category>();
		CategoryCtr cCtr = new CategoryCtr();
		ArrayList<Category> cats = cCtr.getAllCategories();
		cmbCategory.setModel(new DefaultComboBoxModel(cats.toArray()));
		panel_2.add(cmbCategory, "4, 11, fill, default");
		
		lblState = new JBlinkLabel("");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblState, "2, 12, 3, 1");
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "2, 13, 3, 1, fill, fill");
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JButton btnClear = new JButton("Nulstil");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		panel_4.add(btnClear, "2, 2");
		
		btnCreate = new JButton("Opret");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createItem();
			}
		});
		
		JButton btnAnnuller = new JButton("Annuller");
		btnAnnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainGUI.switchPane(iGUI);
				getParent().remove(CreateItemGUI.this);
			}
		});
		panel_4.add(btnAnnuller, "4, 2");
		panel_4.add(btnCreate, "6, 2");
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblOpretVare = new JLabel("Opret Vare");
		lblOpretVare.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblOpretVare);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
	}

	protected void createItem() {
		ItemCtr iCtr = new ItemCtr();
		
		String name = txtName.getText().trim();
		if(name == null && name.length() >= 1){
			lblState.setText("Navnet må ikke være tomt");
			lblState.startBlinking(true, true);
			return;
		}
		
		int amount = 0;
		try{
			amount = Integer.parseInt(txtAmount.getText());
			if(amount < 0){
				lblState.setText("Mængden kan ikke være et negativt tal");
				lblState.startBlinking(true, true);
				return;
			}
		}catch(NumberFormatException e){
			lblState.setText("Mængden skal være et gyldigt tal");
			lblState.startBlinking(true, true);
			return;
		}
		
		int reserved = 0;
		
		double salePrice = 0;
		try{
			salePrice = Double.parseDouble(txtSalePrice.getText());
			if(salePrice < 0){
				lblState.setText("Salgs prisen kan ikke være et negativt tal");
				lblState.startBlinking(true, true);
				return;
			}
		}catch(NumberFormatException e){
			lblState.setText("Salgs prisen skal være et gyldigt tal");
			lblState.startBlinking(true, true);
			return;
		}
		
		double purchasePrice = 0;
		try{
			purchasePrice = Double.parseDouble(txtPurchasePrice.getText());
			if(purchasePrice < 0){
				lblState.setText("Købs prisen kan ikke være et negativt tal");
				lblState.startBlinking(true, true);
				return;
			}
		}catch(NumberFormatException e){
			lblState.setText("Købs prisen skal være et gyldigt tal");
			lblState.startBlinking(true, true);
			return;
		}
		
		double bulkSalePrice = 0;
		try{
			bulkSalePrice = Double.parseDouble(txtBulkPrice.getText());
			if(bulkSalePrice < 0){
				lblState.setText("Bulk salgs prisen kan ikke være et negativt tal");
				lblState.startBlinking(true, true);
				return;
			}
		}catch(NumberFormatException e){
			lblState.setText("Bulk salgs prisen skal være et gyldigt tal");
			lblState.startBlinking(true, true);
			return;
		}
		
		int bulk = Integer.parseInt(txtBulk.getText());
		if(bulk < 0){
			lblState.setText("Bulk skal være større eller det samme som 0");
			lblState.startBlinking(true, true);
			return;
		}
		
		String location = txtLocation.getText().trim();
		if(location == null && location.length() >= 1){
			lblState.setText("Lokationen må ikke være tomt");
			lblState.startBlinking(true, true);
			return;
		}
		
		Storage storage = (Storage) cmbStorage.getSelectedItem();
		if(storage == null){
			lblState.setText("Der skal vælges et gyldigt Lager");
			lblState.startBlinking(true, true);
			return;
		}
		
		int max = 0;
		try{
			max = Integer.parseInt(txtMax.getText());
			if(max < 0){
				lblState.setText("Max kan ikke være et negativt tal");
				lblState.startBlinking(true, true);
				return;
			}
		}catch(NumberFormatException e){
			lblState.setText("Max skal være et gyldigt tal");
			lblState.startBlinking(true, true);
			return;
		}
		
		int min = 0;
		try{
			min = Integer.parseInt(txtMin.getText());
			if(min < 0){
				lblState.setText("Min kan ikke være et negativt tal");
				lblState.startBlinking(true, true);
				return;
			}else if(min >= max){
				lblState.setText("Min kan ikke være større eller det samme som maks");
				lblState.startBlinking(true, true);
				return;
			}
		}catch(NumberFormatException e){
			lblState.setText("Min skal være et gyldigt tal");
			lblState.startBlinking(true, true);
			return;
		}
		
		Category category = (Category) cmbCategory.getSelectedItem();
		if(category == null){
			lblState.setText("Der skal vælges en gyldig Kategori");
			lblState.startBlinking(true, true);
			return;
		}
		if(!isUpdate){
			iCtr.createItem(name, amount, reserved, salePrice, purchasePrice, bulkSalePrice, bulk, location, storage, max, min, category);
		}else if(isUpdate){
			iCtr.updateItem(item.getId(), name, amount, reserved, salePrice, purchasePrice, bulkSalePrice, bulk, location, storage, max, min, category);
		}
		done();
	}

	protected void clear() {
		txtAmount.setText("");
		txtBulk.setText("");
		txtBulkPrice.setText("");
		txtLocation.setText("");
		txtMin.setText("");
		txtMax.setText("");
		txtName.setText("");
		txtPurchasePrice.setText("");
		txtSalePrice.setText("");
		cmbCategory.setSelectedIndex(0);
		cmbStorage.setSelectedIndex(0);
	}
	
	protected void done(){
		mainGUI.switchPane(iGUI);
		getParent().remove(this);
	}
	
}
