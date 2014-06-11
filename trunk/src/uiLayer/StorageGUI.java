package uiLayer;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import modelLayer.Storage;

public class StorageGUI extends JPanel {
	private JTextField txtStreet;
	private JTextField txtStorageName;
	private JTextField txtPostalcode;
	private JTextField txtCity;
	private JTextField txtTlf;
	private JTable table;
	private ArrayList<Storage> s;
	private StorageTableModel model;

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
		
		s = new ArrayList<Storage>();
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
		panel_5.setBounds(16, 43, 209, 150);
		panel_4.add(panel_5);
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("110px:grow"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("30px"),
				RowSpec.decode("30px"),
				RowSpec.decode("30px"),
				RowSpec.decode("30px"),}));
		
		JLabel lblStorageName = new JLabel("Lagernavn");
		panel_5.add(lblStorageName, "1, 1, fill, fill");
		
		txtStorageName = new JTextField();
		panel_5.add(txtStorageName, "2, 1, fill, fill");
		txtStorageName.setColumns(10);
		
		JLabel lblStreet = new JLabel("Gade");
		panel_5.add(lblStreet, "1, 2, fill, fill");
		
		txtStreet = new JTextField();
		panel_5.add(txtStreet, "2, 2, fill, fill");
		txtStreet.setColumns(10);
		
		JLabel lblPostalcode = new JLabel("Postnummer");
		panel_5.add(lblPostalcode, "1, 3, fill, fill");
		
		txtPostalcode = new JTextField();
		txtPostalcode.setColumns(10);
		panel_5.add(txtPostalcode, "2, 3, fill, fill");
		
		JLabel lblCity = new JLabel("By");
		panel_5.add(lblCity, "1, 4, fill, fill");
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		panel_5.add(txtCity, "2, 4, fill, fill");
		
		JLabel lblTlf = new JLabel("Tlf");
		panel_5.add(lblTlf, "1, 5, left, default");
		
		txtTlf = new JTextField();
		panel_5.add(txtTlf, "2, 5, left, top");
		txtTlf.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(16, 197, 209, 32);
		panel_4.add(panel_6);
		panel_6.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(50dlu;pref):grow"),
				ColumnSpec.decode("max(50dlu;pref):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("27px"),}));
		
		JButton btnNulstil = new JButton("Nulstil");
		panel_6.add(btnNulstil, "1, 2, fill, top");
		
		JButton btnOpret = new JButton("Opret");
		panel_6.add(btnOpret, "2, 2, fill, top");

	}
}
