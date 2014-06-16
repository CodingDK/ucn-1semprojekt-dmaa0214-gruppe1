package guiLayer;

import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import ctrLayer.SaleCtr;
import modelLayer.Sale;
import extensions.OrderTableModel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class OrderGUI extends JPanel {
	private JTable table;
	private OrderTableModel model;
	private ArrayList<Sale> sales;

	/**
	 * Create the panel.
	 */
	public OrderGUI() {
		SaleCtr sCtr = new SaleCtr();

		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				SaleCtr sCtr = new SaleCtr();
				sales = sCtr.getSales();
				model.refresh(sales);
				model.fireTableDataChanged();
			}
		});
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{382, 121, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
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
		
		JLabel lblNewLabel = new JLabel("Ordreoversigt");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		sales = sCtr.getSales();
		model = new OrderTableModel(sales);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane.setViewportView(table);
	
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		model.refresh(sales);
		model.fireTableDataChanged();

	}

}
