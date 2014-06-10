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

import personLayer.Private;
import ctrLayer.CustomerCtr;

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
					CustomerCtr cCtr = new CustomerCtr();
					cCtr.createPrivateCustomer("Bjarne", "12345678", "Lærkevej 2", "bjarne@ft.dk", "Aalborg", "9000", "121248-3010", "43432535");
					cCtr.createBusinessCustomer("Kis", "72691867", "Sofiendalsvej 60", "kbha@ucn.dk", "Aalborg", "9000", "UCN A/S", "33556063");
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
		this.setBounds(100, 100, 1280, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Sale = new JPanel();
		tabbedPane.addTab("Salg", null, Sale, null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_S);
		
		JPanel Item = new JPanel();
		tabbedPane.addTab("Varer", null, Item, null);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_V);
		
		JPanel Customer = new CustomerGUI();
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