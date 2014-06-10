package uiLayer;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private boolean admin = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
					MainGUI window = new MainGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Sale = new JPanel();
		tabbedPane.addTab("Salg", null, Sale, null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_S);
		
		JPanel Item = new JPanel();
		tabbedPane.addTab("Varer", null, Item, null);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_V);
		
		JPanel Customer = new JPanel();
		tabbedPane.addTab("Kunde", null, Customer, null);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_K);
		
		JPanel Order = new JPanel();
		tabbedPane.addTab("Ordre", null, Order, null);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_O);
		
		if(admin){
			JPanel Employee = new JPanel();
			tabbedPane.addTab("Medarbejder", null, Employee, null);
			tabbedPane.setMnemonicAt(4, KeyEvent.VK_M);
		}
	}
	
}
