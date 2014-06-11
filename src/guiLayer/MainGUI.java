package guiLayer;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import ctrLayer.CustomerCtr;
import ctrLayer.Demo;

import javax.swing.JMenuBar;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private boolean admin = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		this.setBounds(100, 100, 900, 515);
		this.setMinimumSize(new Dimension(900, 515));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Sale = new SaleGUI();
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
		
		JPanel Login = new JPanel();
		tabbedPane.addTab("Login", null, Login, null);
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_L);
	
		JPanel Employee = new JPanel();
		tabbedPane.addTab("Medarbejder", null, Employee, null);
		tabbedPane.setMnemonicAt(5, KeyEvent.VK_M);
		
		JPanel Category = new CategoryGUI();
		tabbedPane.addTab("Kategori", null, Category, null);
		
		JPanel Storage = new StorageGUI();
		tabbedPane.addTab("Lager", null, Storage, null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Fil");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Gem");
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Hent");
		mnFile.add(mntmLoad);
		
		JMenuItem mntmInsertTestData = new JMenuItem("Indsæt Test Data");
		mntmInsertTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Demo().runDemo();
			}
		});
		mnFile.add(mntmInsertTestData);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmLogin = new JMenuItem("Administrator Login");
		mnFile.add(mntmLogin);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Hjælp");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Hjælp");
		mnHelp.add(mntmHelp);
	}
}
