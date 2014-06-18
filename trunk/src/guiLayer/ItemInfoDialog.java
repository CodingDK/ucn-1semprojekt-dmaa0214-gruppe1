package guiLayer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import modelLayer.Item;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextArea;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.Color;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import extensions.KeyListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class ItemInfoDialog extends JDialog {
	private final Item i;
	private JTextArea txtDescription;
	private JTextArea txtItem;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtItemInfo;
	private ItemGUI iGUI;
	private JButton btnToSale;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel buttonPane;
	private JPanel panel_4;
	private JPanel panel;
	private JButton btnCancel;
	private JButton btnSave;

	/**
	 * Create the dialog.
	 */
	public ItemInfoDialog(final Item i, Frame parent, final ItemGUI iGUI) {
		super(parent, "Vare Information", true);
		new KeyListener().addEscapeListener(this);
		this.i = i;
		this.iGUI = iGUI;
		setBounds(100, 100, 361, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{346, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{277, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 0;
			contentPanel.add(panel_1, gbc_panel_1);
			panel_1.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("165px"),
					ColumnSpec.decode("max(37dlu;default):grow"),},
				new RowSpec[] {
					RowSpec.decode("272px:grow"),}));
			{
				txtItem = new JTextArea();
				txtItem.setColumns(1);
				txtItem.setEditable(false);
				txtItem.setBackground(new Color(214, 217, 223));
				panel_1.add(txtItem, "1, 1, fill, fill");
			}
			{
				txtItemInfo = new JTextArea();
				txtItemInfo.setEditable(false);
				txtItemInfo.setBackground(new Color(214, 217, 223));
				panel_1.add(txtItemInfo, "2, 1, fill, fill");
			}
		}
		{
			panel_2 = new JPanel();
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(0, 0, 5, 5);
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridx = 1;
			gbc_panel_2.gridy = 0;
			contentPanel.add(panel_2, gbc_panel_2);
		}
		{
			panel_3 = new JPanel();
			GridBagConstraints gbc_panel_3 = new GridBagConstraints();
			gbc_panel_3.insets = new Insets(0, 0, 0, 5);
			gbc_panel_3.fill = GridBagConstraints.BOTH;
			gbc_panel_3.gridx = 0;
			gbc_panel_3.gridy = 1;
			contentPanel.add(panel_3, gbc_panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));
			{
				txtDescription = new JTextArea();
				panel_3.add(txtDescription, BorderLayout.CENTER);
			}
		}
		{
			buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				panel_4 = new JPanel();
				buttonPane.add(panel_4, BorderLayout.WEST);
				{
					btnToSale = new JButton("Tilføj til Salg");
					btnToSale.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							iGUI.saleItem = i;
							setVisible(false);
							dispose();
						}
					});
					panel_4.add(btnToSale);
				}
			}
			{
				panel = new JPanel();
				buttonPane.add(panel, BorderLayout.EAST);
				{
					btnCancel = new JButton("Annuller");
					btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							setVisible(false);
							dispose();
						}
					});
					panel.add(btnCancel);
				}
				{
					btnSave = new JButton("Gem");
					btnSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							i.setDescription(txtDescription.getText());
							setVisible(false);
							dispose();
						}
					});
					panel.add(btnSave);
				}
			}
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnToSale, btnCancel, btnSave}));
		fillTxtArea();
		setVisible(true);
	}

	private void fillTxtArea() {
		NumberFormat money = NumberFormat.getCurrencyInstance();
		String nL = System.getProperty("line.separator");
		txtItem.append("Navn: " + nL);
		txtItemInfo.append(i.getName() + nL);
		txtItem.append("Mængde: " + nL);
		txtItemInfo.append(i.getAmount() + nL);
		txtItem.append("Salgs Pris: " + nL);
		txtItemInfo.append(money.format(i.getSalePrice()) + nL);
		txtItem.append("Indkøbs Pris: " + nL);
		txtItemInfo.append(money.format(i.getPurchasePrice()) + nL);
		txtItem.append("Bulk: " + nL);
		txtItemInfo.append(i.getBulk() + nL);
		txtItem.append("Bulk Pris: " + nL);
		txtItemInfo.append(money.format(i.getBulkSalePrice()) + nL);
		txtItem.append("Lokation: " + nL);
		txtItemInfo.append(i.getLocation() + nL);
		txtItem.append("Lager: " + nL);
		txtItemInfo.append(i.getStorage().getName() + nL);
		txtItem.append("Min Lagerbeholdning: " + nL);
		txtItemInfo.append(i.getMin() + nL);
		txtItem.append("Max Lagerbeholdning: " + nL);
		txtItemInfo.append(i.getMax() + nL);
		txtItem.append("Kategori: " + nL);
		txtItemInfo.append(i.getCategory().getName() + nL);
		
		txtDescription.append(i.getDescription());
	}
	
}
