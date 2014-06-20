package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelLayer.Item;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.ItemCtr;
import ctrLayer.SaleCtr;
import exceptionLayer.NotEnoughItemsException;
import exceptionLayer.SaleNotCreatedException;
import extensions.JTextFieldLimit;
import extensions.KeyListener;

public class SaleAddItem extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtItemNr;
	private JTextField txtAmont;
	private JLabel lblAmount;
	private JLabel lblItemNr;
	private JLabel lblItemNrStatus;
	private JLabel lblAmountStatus;
	private Item item;
	private SaleCtr saleCtr;
	
	/**
	 * Create the dialog.
	 */
	public SaleAddItem(Frame f, SaleCtr sCtr) {
		super(f, "Tilføj vare", true);
		
		new KeyListener().addEscapeListener(this);
		item = null;
		saleCtr = sCtr;
		setResizable(false);
		setBounds(100, 100, 321, 147);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("90px"),
					ColumnSpec.decode("80px"),
					ColumnSpec.decode("140px"),},
					new RowSpec[] {
							RowSpec.decode("28px"),
							RowSpec.decode("11px"),
							RowSpec.decode("28px"),}));
			{
				lblItemNr = new JLabel("Vare nummer: ");
				lblItemNr.setLabelFor(lblItemNr);
				panel.add(lblItemNr, "2, 1, fill, fill");
			}
			{
				txtItemNr = new JTextField();
				txtItemNr.setDocument(new JTextFieldLimit(10, true, false));
				txtItemNr.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						checkItemNr();
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						lblItemNrStatus.setText("");
						lblAmountStatus.setText("");
					}
				});
				panel.add(txtItemNr, "3, 1, fill, fill");
				txtItemNr.setColumns(10);
			}
			{
				lblItemNrStatus = new JLabel("");
				panel.add(lblItemNrStatus, "4, 1, fill, fill");
			}
			{
				lblAmount = new JLabel("Antal: ");
				panel.add(lblAmount, "2, 3, fill, fill");
			}
			{
				txtAmont = new JTextField();
				txtAmont.setDocument(new JTextFieldLimit(10, true, false));
				txtAmont.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						checkAmount();
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						//lblAmountStatus.setText("");
					}
				});
				lblAmount.setLabelFor(txtAmont);
				txtAmont.setColumns(10);
				panel.add(txtAmont, "3, 3, fill, fill");
			}
			{
				lblAmountStatus = new JLabel("");
				panel.add(lblAmountStatus, "4, 3, fill, fill");
			}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bntAdd = new JButton("Tilføj");
				bntAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addItem();
					}
				});
				bntAdd.setActionCommand("OK");
				buttonPane.add(bntAdd);
				getRootPane().setDefaultButton(bntAdd);
			}
			{
				JButton bntCancel = new JButton("Annuller");
				bntCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				bntCancel.setActionCommand("Cancel");
				buttonPane.add(bntCancel);
			}
		}
	}
	
	private void addItem() {
		if (checkAmount() && checkItemNr()) {
			int amount = Integer.parseInt(txtAmont.getText());
			try {
				saleCtr.addItem(item, amount);
				setVisible(false);
				dispose();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (NotEnoughItemsException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (SaleNotCreatedException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		else if (!checkItemNr()) {
			JOptionPane.showMessageDialog(this, "Varenummer blev ikke fundet", "Fejl", JOptionPane.ERROR_MESSAGE);
		}
		else if (!checkAmount()) {
			JOptionPane.showMessageDialog(this, "Antal er ikke muligt", "Fejl", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Hov.. Du glemte vist noget", "Fejl", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean checkAmount() {
		boolean ret = false;
		String strAmount = txtAmont.getText();
		
		//int amount = Integer.parseInt(strAmount);
		if (!strAmount.isEmpty() && Integer.parseInt(strAmount) > 0) {
			
			if (item != null) {
				int amount = Integer.parseInt(strAmount);
				int aviAmount = item.getAmount() - item.getReserved();
				if (aviAmount - amount < 0) {
					lblAmountStatus.setText("Kun " + aviAmount + " på lager");
				} else {
					lblAmountStatus.setText("Antal er muligt");
					ret = true;
				}
			} else {
				lblAmountStatus.setText("Vælg vare først!");
			}
		} else {
			lblAmountStatus.setText("Vælg antal større end 0");
		}
		return ret;
		
	}
	
	private boolean checkItemNr() {
		boolean ret = false;
		String strItemNr = txtItemNr.getText();
		item = null;
		
		if (!strItemNr.isEmpty()) {
			ItemCtr iCtr = new ItemCtr();
			int itemNr = Integer.parseInt(strItemNr);
			Item retItem = iCtr.getItem(itemNr);
			if (retItem != null) {
				item = retItem;
				lblItemNrStatus.setText(item.getName());
				ret = true;
			} else {
				lblItemNrStatus.setText("Varenr. ikke fundet");
			}
		} else {
			lblItemNrStatus.setText("Varenr. er tomt");
		}
		return ret;
	}
	
}
