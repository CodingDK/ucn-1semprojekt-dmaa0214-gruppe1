package guiLayer;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.CategoryCtr;
import exceptionLayer.CategoryExistException;
import exceptionLayer.MainCategoryException;
import extensions.CategoryTableModel;
import extensions.JBlinkLabel;

import javax.swing.LayoutStyle.ComponentPlacement;

import modelLayer.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

public class CategoryGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> categories;
	private JTextField txtName;
	private CategoryTableModel model;
	private JTable table;
	private JBlinkLabel lblState;
	
	/**
	 * Create the panel.
	 */
	public CategoryGUI() {
		CategoryCtr cCtr = new CategoryCtr();
		categories = cCtr.getAllCategories();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{833, 250, 0};
		gridBagLayout.rowHeights = new int[]{0, 10, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblKategorier = new JLabel("Kategorier");
		lblKategorier.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblKategorier);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		model = new CategoryTableModel(categories);
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	System.out.println(e.getButton());
		    	if(e.getButton() == MouseEvent.BUTTON3 || e.isControlDown()){
			        int r = table.rowAtPoint(e.getPoint());
			        if (r >= 0 && r < table.getRowCount()) {
			            table.setRowSelectionInterval(r, r);
			        } else {
			            table.clearSelection();
			        }
	
			        final int rowindex = table.getSelectedRow();
			        if (rowindex < 0)
			            return;
			        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
			        	JPopupMenu popupMenu = new JPopupMenu();
			    		JMenuItem mntmDelete = new JMenuItem("Slet");
			    		mntmDelete.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent arg0) {
			    				String name = (String) table.getValueAt(rowindex, 1);
			    				removeCategory(name);
			    			}
			    		});
			    		JMenuItem mntmUpdate = new JMenuItem("Ret Kategori");
			    		mntmUpdate.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent arg0) {
			    				int id = (Integer) table.getValueAt(rowindex, 0);
			    				String name = (String) table.getValueAt(rowindex, 1);
			    				updateCategory(id, name);
			    			}
			    		});
			    		popupMenu.add(mntmDelete);
			    		popupMenu.add(mntmUpdate);
			    		popupMenu.show(e.getComponent(), e.getX(), e.getY());
			       }
		    	}
		    }
		});
		table.getColumnModel().getColumn(0).setMaxWidth(25);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Opret Kategori", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_3.setBounds(0, 25, 250, 106);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(16)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addGap(6))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("63px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("58px:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("28px"),}));
		
		JButton btnClear = new JButton("Nulstil");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear();
			}
		});
		panel_5.add(btnClear, "1, 2, fill, top");
		
		JButton btnCreate = new JButton("Opret");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createCategory();
			}
		});
		panel_5.add(btnCreate, "3, 2, fill, top");
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("70px"),
				ColumnSpec.decode("111px:grow"),},
			new RowSpec[] {
				RowSpec.decode("30px"),}));
		
		JLabel lblName = new JLabel("Kategori");
		panel_4.add(lblName, "1, 1, fill, fill");
		
		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createCategory();
			}
		});
		panel_4.add(txtName, "2, 1, fill, fill");
		txtName.setColumns(10);
		panel_3.setLayout(gl_panel_3);
		
		lblState = new JBlinkLabel("");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setBounds(0, 6, 250, 16);
		panel_1.add(lblState);
		model.fireTableDataChanged();
	}
	protected void createCategory() {
		CategoryCtr cCtr = new CategoryCtr();
		if(txtName.getText() != null && !txtName.getText().trim().isEmpty()){
			try {
				cCtr.createCategory(txtName.getText());
				categories = cCtr.getAllCategories();
				model.refresh(categories);
				model.fireTableDataChanged();
				lblState.setText(txtName.getText() + " er oprettet");
				lblState.startBlinking(true, false);
				Clear();
			} catch (CategoryExistException e) {
				lblState.setText(e.getMessage());
				lblState.startBlinking(true, true);
			}
		}else{
			lblState.setText("Kategoriens navn kan ikke være tomt");
			lblState.startBlinking(true, true);
		}
		
	}
	
	protected void Clear() {
		txtName.setText("");
	}
	
	protected void removeCategory(String name) {
		try {
			CategoryCtr cCtr = new CategoryCtr();
			cCtr.removeCategory(cCtr.findCategory(name));
			categories = cCtr.getAllCategories();
			model.refresh(categories);
			model.fireTableDataChanged();
			lblState.setText(name + " er slettet");
			lblState.startBlinking(true, false);
		} catch (MainCategoryException e) {
			lblState.setText(e.getMessage());
			lblState.startBlinking(true, true);
		}
	}
	
	protected void updateCategory(int id, String name) {
		if(!name.equals("Alle")){
			JDialog update = new UpdateCategoryDialog(null, id, name);
			CategoryCtr cCtr = new CategoryCtr();
			model.refresh(cCtr.getAllCategories());
			model.fireTableDataChanged();
		}else{
			lblState.setText(name + " kan ikke ændres");
			lblState.startBlinking(true, true);
		}
	}
}
