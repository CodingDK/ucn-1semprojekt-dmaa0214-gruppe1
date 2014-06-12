package guiLayer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.CategoryCtr;
import ctrLayer.ItemCtr;
import extensions.JDoubleField;
import extensions.JIntegerField;

import javax.swing.JComboBox;
import javax.swing.JButton;

import modelLayer.Category;
import modelLayer.Storage;

public class CreateItemGUI extends JPanel {
	private JIntegerField txtAmount;
	private JDoubleField txtSalePrice;
	private JDoubleField txtPurchasePrice;
	private JIntegerField txtBulk;
	private JDoubleField txtBulkPrice;
	private JTextField txtLocation;
	private JIntegerField txtMax;
	private JIntegerField txtMin;
	public JTextField txtName;
	
	/**
	 * Create the panel.
	 */
	public CreateItemGUI() {
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
				RowSpec.decode("28px:grow"),}));
		
		JLabel lblName = new JLabel("Navn");
		panel_2.add(lblName, "2, 1, fill, fill");
		
		txtName = new JTextField();
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
		txtLocation.setColumns(10);
		panel_2.add(txtLocation, "4, 7, fill, fill");
		
		JLabel lblStorage = new JLabel("Lager");
		panel_2.add(lblStorage, "2, 8, left, fill");
		
		JComboBox<Storage> cmbStorage = new JComboBox<Storage>();
		ItemCtr iCtr = new ItemCtr();
		ArrayList<Storage> stors = iCtr.getAllStorage();
		cmbStorage.setModel(new DefaultComboBoxModel(stors.toArray()));
		panel_2.add(cmbStorage, "4, 8, fill, default");
		
		JLabel lblMax = new JLabel("Max Lagerbeholdning");
		panel_2.add(lblMax, "2, 9, fill, fill");
		
		txtMax = new JIntegerField();
		txtMax.setColumns(10);
		panel_2.add(txtMax, "4, 9, fill, fill");
		
		JLabel lblMin = new JLabel("Min Lagerbeholdning");
		panel_2.add(lblMin, "2, 10, fill, fill");
		
		txtMin = new JIntegerField();
		txtMin.setColumns(10);
		panel_2.add(txtMin, "4, 10, fill, fill");
		
		JLabel lblCategory = new JLabel("Kategori");
		panel_2.add(lblCategory, "2, 11, left, fill");
		
		JComboBox<Category> cmbCategory = new JComboBox<Category>();
		CategoryCtr cCtr = new CategoryCtr();
		ArrayList<Category> cats = cCtr.getAllCategories();
		cmbCategory.setModel(new DefaultComboBoxModel(cats.toArray()));
		panel_2.add(cmbCategory, "4, 11, fill, default");
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "2, 12, 3, 1, fill, fill");
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnClear = new JButton("Nulstil");
		panel_4.add(btnClear, "2, 2");
		
		JButton btnOpret = new JButton("Opret");
		panel_4.add(btnOpret, "4, 2");
		
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
	
}
