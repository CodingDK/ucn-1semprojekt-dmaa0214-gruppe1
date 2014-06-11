package guiLayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.CategoryCtr;

import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCategory extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCategory;
	private String name;
	
	/**
	 * Create the dialog.
	 */
	public UpdateCategory(Frame parent, int id, String name) {
		super(parent, name, true);
	    if (parent != null) {
	      Dimension parentSize = parent.getSize(); 
	      Point p = parent.getLocation(); 
	      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
	    }
		this.name = name;
		setBounds(100, 100, 286, 152);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblTitle = new JLabel("#" + id + " - " + name);
				lblTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
				panel.add(lblTitle);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("77px"),
					ColumnSpec.decode("183px"),},
				new RowSpec[] {
					RowSpec.decode("36px"),}));
			{
				JLabel lblCategory = new JLabel("Kategori");
				panel.add(lblCategory, "1, 1, center, fill");
			}
			{
				txtCategory = new JTextField();
				panel.add(txtCategory, "2, 1, fill, fill");
				txtCategory.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("Gem");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveCategory();
					}
				});
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton btnCancel = new JButton("Annuller");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false); 
					    dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		
		setVisible(true);
	}

	protected void saveCategory() {
		if(txtCategory.getText() != null && !txtCategory.getText().trim().isEmpty()){
			CategoryCtr cCtr = new CategoryCtr();
			cCtr.updateCategory(cCtr.findCategory(name), txtCategory.getText());
		}
		
		setVisible(false);
		dispose();
	}
	
	
}
