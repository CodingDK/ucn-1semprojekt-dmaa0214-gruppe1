package guiLayer;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.ItemCtr;
import extensions.JBlinkLabel;
import extensions.StorageTableModel;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import modelLayer.Storage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StorageGUI extends JPanel {
	public JTextField txtStorageName;
	private JTable table;
	private ArrayList<Storage> s;
	private StorageTableModel model;
	private JBlinkLabel errLabel;
	public JButton btnOpret;

	/**
	 * Create the panel.
	 */
	public StorageGUI() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 250, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblLager = new JLabel("Lager");
		panel_3.add(lblLager);
		lblLager.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		ItemCtr iCtr = new ItemCtr();
		s = iCtr.getAllStorage();
		
		model = new StorageTableModel(s);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 48, 250, 251);
		panel_4.setBorder(new TitledBorder(null, "Opret Lager", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(16, 43, 209, 32);
		panel_4.add(panel_5);
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("110px:grow"),},
			new RowSpec[] {
				RowSpec.decode("30px"),}));
		
		JLabel lblStorageName = new JLabel("Lagernavn");
		panel_5.add(lblStorageName, "1, 1, fill, fill");
		
		txtStorageName = new JTextField();
		panel_5.add(txtStorageName, "2, 1, fill, fill");
		txtStorageName.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(16, 87, 209, 32);
		panel_4.add(panel_6);
		panel_6.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(50dlu;pref):grow"),
				ColumnSpec.decode("max(50dlu;pref):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("27px"),}));
		
		JButton btnNulstil = new JButton("Nulstil");
		btnNulstil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_6.add(btnNulstil, "1, 2, fill, top");
		
		btnOpret = new JButton("Opret");
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createStorage();
			}
		});
		panel_6.add(btnOpret, "2, 2, fill, top");
		
		errLabel = new JBlinkLabel("");
		errLabel.setBounds(16, 131, 209, 16);
		panel_4.add(errLabel);
	}
	
	protected void clear() {
		txtStorageName.setText("");
		s.clear();
	}
	
	protected void clearInput(){
		txtStorageName.setText("");
	}

	private void createStorage() {
		ItemCtr iCtr = new ItemCtr();
		String name = txtStorageName.getText();
		if(name == null || name.trim().isEmpty()){
			errLabel.setText("Navnet må ikke være tomt");
			errLabel.startBlinking(true, true);
		} else{
			iCtr.createStorage(name);
		}
		model.fireTableDataChanged();
		s = iCtr.getAllStorage();
		model.refresh(s);
		clearInput();

	}
}
