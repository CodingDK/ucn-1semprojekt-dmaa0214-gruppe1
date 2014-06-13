package guiLayer;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;

import java.awt.GridLayout;

import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.CategoryCtr;
import ctrLayer.SaleCtr;
import extensions.SaleItemTableModel;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelLayer.Item;
import modelLayer.PartSale;
import modelLayer.Sale;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SaleGUI extends JPanel {
	private JLabel txtSubtotal;
	private JLabel txtMoms;
	private JLabel txtTotal;
	private JTable table;
	private ArrayList<PartSale> partSales;
	private SaleItemTableModel model;
	private SaleCtr saleCtr;
	public JButton btnAddItem;
	private MainGUI mainGUI;

	/**
	 * Create the panel.
	 */
	public SaleGUI(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		partSales = new ArrayList<PartSale>();
		saleCtr = new SaleCtr();
		saleCtr.createSale();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{360, 250, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		
		JLabel lblVarer = new JLabel("Varer");
		lblVarer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVarer.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_2.add(lblVarer);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.WEST);
		
		btnAddItem = new JButton("Tilføj Vare");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeAddItem();
			}
		});
		panel_6.add(btnAddItem);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel_10.add(panel_5);
		FormLayout fl_panel_5 = new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("50px"),
				ColumnSpec.decode("80px"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("30px"),
				RowSpec.decode("30px"),});
		panel_5.setLayout(fl_panel_5);
		
		JLabel lblSubtotal = new JLabel("Subtotal: ");
		lblSubtotal.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblSubtotal, "1, 1, fill, fill");
		
		txtSubtotal = new JLabel();
		txtSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSubtotal.setText("0 ,-");
		lblSubtotal.setLabelFor(txtSubtotal);
		panel_5.add(txtSubtotal, "2, 1, fill, fill");
		
		JLabel lblMoms = new JLabel("Moms: ");
		lblMoms.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblMoms, "1, 2, fill, fill");
		
		txtMoms = new JLabel();
		txtMoms.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoms.setLabelFor(txtMoms);
		txtMoms.setText("0 ,-");
		panel_5.add(txtMoms, "2, 2, fill, fill");
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setToolTipText("");
		panel_5.add(lblTotal, "1, 3, fill, fill");
		
		txtTotal = new JLabel();
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setLabelFor(txtTotal);
		txtTotal.setText("0 ,-");
		panel_5.add(txtTotal, "2, 3, fill, fill");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		model = new SaleItemTableModel(partSales);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Kunde", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(6, 23, 238, 171);
		panel_1.add(panel_4);
		
		JPanel panel_7 = new JPanel();
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(21)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton bntFind = new JButton("Find Kunde");
		panel_8.add(bntFind);
		
		JButton btnCreate = new JButton("Opret kunde");
		panel_8.add(btnCreate);
		panel_7.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("60px"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("18px"),
				RowSpec.decode("18px"),
				RowSpec.decode("18px"),
				RowSpec.decode("18px"),}));
		
		JLabel lblName = new JLabel("Navn: ");
		panel_7.add(lblName, "1, 2, fill, fill");
		
		JLabel txtName = new JLabel("Bjarne Nielsen");
		lblName.setLabelFor(txtName);
		panel_7.add(txtName, "2, 2, fill, fill");
		
		JLabel lblPhone = new JLabel("TLF nr.: ");
		panel_7.add(lblPhone, "1, 3, fill, fill");
		
		JLabel txtPhone = new JLabel("12345678");
		lblPhone.setLabelFor(txtPhone);
		panel_7.add(txtPhone, "2, 3, fill, fill");
		
		JLabel lblCustomerNr = new JLabel("Kunde nr.: ");
		panel_7.add(lblCustomerNr, "1, 4, fill, fill");
		
		JLabel txtCustomerNr = new JLabel("25151564");
		lblCustomerNr.setLabelFor(txtCustomerNr);
		panel_7.add(txtCustomerNr, "2, 4, fill, fill");
		
		JLabel lblCredit = new JLabel("Kredit: ");
		panel_7.add(lblCredit, "1, 5, fill, fill");
		
		JLabel label_5 = new JLabel("0 ,-");
		lblCredit.setLabelFor(label_5);
		panel_7.add(label_5, "2, 5, fill, fill");
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(128, 304, 116, 115);
		panel_1.add(panel_9);
		panel_9.setLayout(new GridLayout(3, 0, 0, 12));
		
		JButton button = new JButton("Nulstil");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSale();
			}
		});
		panel_9.add(button);
		
		JButton button_1 = new JButton("Parker");
		panel_9.add(button_1);
		
		JButton button_2 = new JButton("Udfør");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FinishSale();
			}
		});
		panel_9.add(button_2);

	}
	
	private void FinishSale() {
		JFrame frame = new JFrame();
		String[] options = new String[2];
		options[0] = new String("Nulstil");
		options[1] = new String("Annuller");
		int choice = JOptionPane.showOptionDialog(frame.getContentPane(),"Er du sikker på du vil nulstille salget?","Nulstil Salg", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
		if(choice == 1){ // annuller
			
			System.out.println(choice);
		} else { //nulstil
			
		}
	}

	private void cancelSale() {
		JFrame frame = new JFrame();
		String[] options = new String[2];
		options[0] = new String("Nulstil");
		options[1] = new String("Annuller");
		int choice = JOptionPane.showOptionDialog(frame.getContentPane(),"Er du sikker på du vil nulstille salget?","Nulstil Salg", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
		System.out.println(choice);
		if(choice == 0){
			
			saleCtr.cancelSale();
			mainGUI.cancelSale();
		}
	}

	private void makeAddItem(){
		JDialog addDialog = new SaleAddItem(null, saleCtr);
		
		partSales = saleCtr.getSale().getPartSales();
		model.refresh(partSales);
		model.fireTableDataChanged();
		updatePrices();
	}
	
	private void updatePrices(){
		double subtotal = 0;
		double moms = 0;
		for(PartSale ps : partSales){
			Item i = ps.getItem();
			subtotal += i.getSalePrice()*ps.getAmount();
		}
		moms = subtotal*0.25;
		txtSubtotal.setText(subtotal + " ,-");
		txtMoms.setText(moms + " ,-");
		txtTotal.setText(subtotal+moms + " ,-");
	}
}
