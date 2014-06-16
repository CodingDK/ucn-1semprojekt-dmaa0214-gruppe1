package guiLayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import ctrLayer.ItemCtr;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStorageDialog extends JDialog {

	private static final long serialVersionUID = 1;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStorageName;
	private String name;

	
	/**
	 * Create the dialog.
	 */
	public UpdateStorageDialog(Frame parent, int id, String name) {
		super(parent, name, true);
		this.name = name;
		setBounds(100, 100, 368, 98);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("110px"),
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
				RowSpec.decode("30px"),}));
		{
			JLabel lblStorageName = new JLabel("Lagernavn");
			lblStorageName.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblStorageName, "1, 1, left, default");
		}
		{
			txtStorageName = new JTextField();
			contentPanel.add(txtStorageName, "2, 1, fill, default");
			txtStorageName.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					JButton cancelButton = new JButton("Annuller");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							setVisible(false); 
						    dispose();
						}
					});
					JButton okButton = new JButton("Gem");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							saveStorage();
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
			
			setVisible(true);
		}
	}


	protected void saveStorage() {
		if(txtStorageName.getText() != null && !txtStorageName.getText().trim().isEmpty() ){
			ItemCtr iCtr = new ItemCtr();
			iCtr.updateStorage(iCtr.findStorage(name), txtStorageName.getText() );
		}
		setVisible(false);
		dispose();
	}

}
