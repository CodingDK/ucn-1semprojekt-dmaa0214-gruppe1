package guiLayer;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import personLayer.Employee;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.EmployeeCtr;
import extensions.JBlinkLabel;
import extensions.KeyListener;

public class LoginDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmployee;
	private JTextField txtPassword;
	private MainGUI main;
	private JBlinkLabel lblError;
	
	/**
	 * Create the dialog.
	 */
	public LoginDialog(Frame parent, final MainGUI main) {
		super(parent, "Login", true);
		this.main = main;
		if (main == null) {
			close();
		}
		new KeyListener().addEscapeListener(this);
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("137px:grow"),
				ColumnSpec.decode("137px:grow"),},
				new RowSpec[] {
						RowSpec.decode("fill:25px"),
						RowSpec.decode("fill:25px"),}));
		{
			JLabel lblEmployee = new JLabel("Medarbejder Nummer");
			contentPanel.add(lblEmployee, "1, 1, fill, fill");
		}
		{
			txtEmployee = new JTextField();
			contentPanel.add(txtEmployee, "2, 1, fill, fill");
			txtEmployee.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Kodeord");
			contentPanel.add(lblPassword, "1, 2, fill, fill");
		}
		{
			txtPassword = new JPasswordField();
			contentPanel.add(txtPassword, "2, 2, fill, fill");
			txtPassword.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						login();
					}
				});
				buttonPane.setLayout(new FormLayout(new ColumnSpec[] {
						ColumnSpec.decode("left:30px"),
						ColumnSpec.decode("60px:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("60px:grow"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("30px"),},
						new RowSpec[] {
								FormFactory.LINE_GAP_ROWSPEC,
								RowSpec.decode("max(2dlu;default):grow"),
								FormFactory.RELATED_GAP_ROWSPEC,
								RowSpec.decode("23px"),}));
				{
					lblError = new JBlinkLabel("");
					lblError.setText(" ");
					lblError.setHorizontalAlignment(SwingConstants.CENTER);
					buttonPane.add(lblError, "1, 2, 6, 1");
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton, "2, 4, fill, top");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuller");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton, "4, 4, fill, top");
			}
		}
	}
	
	protected void login() {
		EmployeeCtr eCtr = new EmployeeCtr();
		String empNr = txtEmployee.getText();
		String password = txtPassword.getText();
		Employee e = eCtr.findEmployee(empNr);
		if (e != null) {
			if (e.getAdmin()) {
				if (e.getPassword().equals(password)) {
					main.setAdmin(true);
					close();
				} else {
					lblError.setText("Kodeordet er forkert");
					lblError.startBlinking(true, true);
					return;
				}
			} else {
				lblError.setText("Denne medarbejder har ikke administrator rettigheder");
				lblError.startBlinking(true, true);
				return;
			}
		} else {
			lblError.setText("Medarbejder findes ikke");
			lblError.startBlinking(true, true);
			return;
		}
		
	}
	
	private void close() {
		setVisible(false);
		dispose();
	}
	
}
