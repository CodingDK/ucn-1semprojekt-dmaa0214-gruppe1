package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import modelLayer.Storage;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.ItemCtr;
import exceptionLayer.StorageExistException;
import extensions.JBlinkLabel;
import extensions.StorageTableModel;

public class StorageGUI extends JPanel {
	
	private static final long serialVersionUID = 1;
	
	public JTextField txtStorageName;
	private JTable table;
	private ArrayList<Storage> storages;
	private StorageTableModel model;
	public JButton btnOpret;
	private JBlinkLabel lblState;

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
		storages = iCtr.getAllStorage();
		
		model = new StorageTableModel(storages);
		table = new JTable(model);
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	if(e.getButton() == MouseEvent.BUTTON3){
			        int r = table.rowAtPoint(e.getPoint());
			        if (r >= 0 && r < table.getRowCount()) {
			            table.setRowSelectionInterval(r, r);
			        } else {
			            table.clearSelection();
			        }
	
			        final int rowindex = table.getSelectedRow();
			        if (rowindex < 0)
			            return;
			        if (e.getComponent() instanceof JTable ) {
			        	JPopupMenu popupMenu = new JPopupMenu();
			    		JMenuItem mntmDelete = new JMenuItem("Slet");
			    		mntmDelete.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent arg0) {
			    				String name = (String) table.getValueAt(rowindex, 1);
			    				removeStorage(name);
			    			}
			    		});
			    		JMenuItem mntmUpdate = new JMenuItem("Ret Lager");
			    		mntmUpdate.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent arg0) {
			    				int id = (Integer) table.getValueAt(rowindex, 0);
			    				String name = (String) table.getValueAt(rowindex, 1);
			    				updateStorage(id, name);
			    			}
			    		});
			    		popupMenu.add(mntmDelete);
			    		popupMenu.add(mntmUpdate);
			    		popupMenu.show(e.getComponent(), e.getX(), e.getY());
			       }
		    	}
		    }
		});

		table.getColumnModel().getColumn(0).setMaxWidth(35);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 26, 250, 103);
		panel_4.setBorder(new TitledBorder(null, "Opret Lager", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(16, 18, 209, 32);
		panel_4.add(panel_5);
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("75px"),
				ColumnSpec.decode("110px:grow"),},
			new RowSpec[] {
				RowSpec.decode("30px"),}));
		
		JLabel lblStorageName = new JLabel("Lagernavn");
		panel_5.add(lblStorageName, "1, 1, fill, fill");
		
		txtStorageName = new JTextField();
		panel_5.add(txtStorageName, "2, 1, fill, fill");
		txtStorageName.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(16, 50, 209, 32);
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
		
		lblState = new JBlinkLabel("");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setBounds(0, 6, 250, 16);
		panel_2.add(lblState);
	}
	
	protected void clear() {
		txtStorageName.setText("");
		storages.clear();
	}
	
	protected void clearInput(){
		txtStorageName.setText("");
	}

	private void createStorage() {
		ItemCtr iCtr = new ItemCtr();
		String txtName = txtStorageName.getText();
		if(txtName == null || txtName.trim().isEmpty() ){		
			lblState.setText("Navnet må ikke være tomt");
			lblState.startBlinking(true, true);
		} else {
			try{
				iCtr.createStorage(txtName);
				model.fireTableDataChanged();
				storages = iCtr.getAllStorage();
				model.refresh(storages);
				clearInput();
				lblState.setText(txtName + " er oprettet");
				lblState.startBlinking(true, false);
			} catch (StorageExistException e){
				lblState.setText(e.getMessage());
				lblState.startBlinking(true, true);
			}
		} 
	}
		
		
		
		
	private void removeStorage(String name) {
		ItemCtr iCtr = new ItemCtr();
		if(!name.equals("Ukendt") ){
			iCtr.removeStorage(iCtr.findStorage(name) );
			model.refresh(storages);
			model.fireTableDataChanged();
			lblState.setText(name + " er nu slettet");
			lblState.startBlinking(true, false);
		} else{
			lblState.setText(name + " kan ikke slettes");
			lblState.startBlinking(true, true);
		}
	}
	
	protected void updateStorage(int id, String name) {
		if(!name.equals("Ukendt") ){
			new UpdateStorageDialog(null, id, name);
			ItemCtr iCtr = new ItemCtr();
			model.refresh(iCtr.getAllStorage() );
			model.fireTableDataChanged();
		} else{
			lblState.setText(name + " kan ikke ændres");
			lblState.startBlinking(true, true);
		}
		
	}	
}
