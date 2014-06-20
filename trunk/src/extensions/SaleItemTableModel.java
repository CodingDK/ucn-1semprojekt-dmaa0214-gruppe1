package extensions;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import modelLayer.Item;
import modelLayer.PartSale;

public class SaleItemTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<PartSale> partSales;
	private final boolean[] canEdit = new boolean[] {
			false, false, true, false, false
	};
	private NumberFormat money;
	
	public SaleItemTableModel(ArrayList<PartSale> ps) {
		partSales = ps;
		money = NumberFormat.getCurrencyInstance();
	}
	
	public void refresh(ArrayList<PartSale> ps) {
		partSales = ps;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public int getRowCount() {
		return partSales.size();
	}
	
	public Object getValueAt(int rowIndex, int collIndex) {
		PartSale ps = partSales.get(rowIndex);
		Object value = null;
		if (collIndex == 0) {
			Item item = ps.getItem();
			value = item.getId();
		} else if (collIndex == 1) {
			Item item = ps.getItem();
			value = item.getName();
		} else if (collIndex == 2) {
			
			value = ps.getAmount();
		} else if (collIndex == 3) {
			Item item = ps.getItem();
			value = money.format(item.getSalePrice());
		} else if (collIndex == 4) {
			Item item = ps.getItem();
			String totalPrice = "" + money.format(item.getSalePrice() * ps.getAmount());
			value = totalPrice;
		}
		return value;
	}
	
	@Override
	public String getColumnName(int collIndex) {
		
		String value = "??";
		
		if (collIndex == 0) {
			value = "Varenr.";
		} else if (collIndex == 1) {
			value = "Varenavn";
		} else if (collIndex == 2) {
			value = "Stk.";
		} else if (collIndex == 3) {
			value = "Stk. pris";
		} else if (collIndex == 4) {
			value = "Total";
		}
		
		return value;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		PartSale ps = partSales.get(rowIndex);
		try
		{
			String value1 = (String) value;
			int newAmount = Integer.parseInt(value1);
			if (value1.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Antal kan ikke være tomt", "Advarsel", JOptionPane.ERROR_MESSAGE);
			}
			if (newAmount <= 0) {
				JOptionPane.showMessageDialog(null, "Antal skal være større end 0", "Advarsel", JOptionPane.ERROR_MESSAGE);
			} else {
				int oldAmount = ps.getAmount();
				Item item = ps.getItem();
				int addedAmount = newAmount - oldAmount;
				int availableAmount = item.getAmount() - item.getReserved();
				if (availableAmount - addedAmount < 0) {
					JOptionPane.showMessageDialog(null, "Der er kun " + (availableAmount + oldAmount) + " af " + item.getName() + " ledige på lageret.", "Advarsel", JOptionPane.ERROR_MESSAGE);
					
				} else {
					item.addReserved(addedAmount);
					ps.addAmount(addedAmount);
					fireTableRowsUpdated(rowIndex, rowIndex);
				}
			}
			
			//fireTableCellUpdated(rowIndex, columnIndex);
		} catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Der kan kun tastes tal", "Advarsel", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
