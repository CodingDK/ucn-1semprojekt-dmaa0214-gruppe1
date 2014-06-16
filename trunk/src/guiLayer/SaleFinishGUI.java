package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrLayer.SaleCtr;
import exceptionLayer.SaleNotCreatedException;
import extensions.JIntegerField;

public class SaleFinishGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SaleCtr saleCtr;
	private JPanel panel_1;
	private JIntegerField txtEmployeeNr;
	private JLabel lblEmployeeNrStatus;
	private JLabel lblEmployeeNr;
	private JButton btnCredit;
	private JPanel panel;
	private JLabel lblEndSale;
	private boolean done;

	/**
	 * Create the dialog.
	 */
	public SaleFinishGUI(Frame f, SaleCtr sCtr) {
		super(f, "Afslut salg", true);
		done = false;
		this.saleCtr = sCtr;
		setResizable(false);
		setBounds(100, 100, 321, 147);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel);
			{
				lblEndSale = new JLabel("Afslut salg");
				lblEndSale.setFont(new Font("Tahoma", Font.BOLD, 14));
				panel.add(lblEndSale);
			}
		}
		{
			panel_1 = new JPanel();
			contentPanel.add(panel_1);
			{
				lblEmployeeNr = new JLabel("Sælger nummer:");
				panel_1.add(lblEmployeeNr);
			}
			{
				txtEmployeeNr = new JIntegerField();
				txtEmployeeNr.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						checkEmployeeNr();
					}
					@Override
					public void focusGained(FocusEvent arg0) {
						lblEmployeeNrStatus.setText("");
					}
				});
				lblEmployeeNr.setLabelFor(txtEmployeeNr);
				txtEmployeeNr.setColumns(10);
				panel_1.add(txtEmployeeNr);
			}
			{
				lblEmployeeNrStatus = new JLabel("");
				panel_1.add(lblEmployeeNrStatus);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bntCash = new JButton("Kontant");
				bntCash.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						finishCashSale();
					}
				});
				bntCash.setActionCommand("OK");
				buttonPane.add(bntCash);
				getRootPane().setDefaultButton(bntCash);
			}
			{
				JButton bntCancel = new JButton("Annuller");
				bntCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false); 
					    dispose();
					}
				});
				{
					btnCredit = new JButton("Kredit");
					btnCredit.setEnabled(false);
					btnCredit.setActionCommand("OK");
					buttonPane.add(btnCredit);
				}
				bntCancel.setActionCommand("Cancel");
				buttonPane.add(bntCancel);
			}
		}
		setVisible(true);
	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	private void checkEmployeeNr() {
		//check employeeNr before finish the Sale
	}

	private void finishCashSale() {
		String employeeNr = txtEmployeeNr.getText();
		try {
			saleCtr.finishSale(employeeNr);
			JOptionPane.showMessageDialog(null, "Kontant salg fuldført");
			setVisible(false);
			done = true;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			txtEmployeeNr.requestFocus();
		} catch (SaleNotCreatedException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
