package guiLayer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import ctrLayer.Demo;

import javax.swing.JMenuBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import extensions.CloseButtonTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
public class MainGUI extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	public boolean admin = false;
	private JMenuItem mntmLogin;
	private CloseButtonTabbedPane tabbedPane;
	private SaleGUI Sale;
	private ItemGUI Item;
	private CustomerGUI Customer;
	private JPanel Order;
	private EmployeeGUI Employee;
	private JPanel Storage;
	private CategoryGUI Category;
	
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
		
		tabbedPane = new CloseButtonTabbedPane();
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		Sale = new SaleGUI(this);
		Item = new ItemGUI(this);
		Customer = new CustomerGUI(this);
		Order = new JPanel();
		Employee = new EmployeeGUI(this);
		Category = new CategoryGUI();
		Storage = new StorageGUI();
		
		tabbedPane.insertTab("Salg", null, Sale, null, 0);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_S);
		
		tabbedPane.insertTab("Varer", null, Item, null, 1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_V);
		tabbedPane.insertTab("Kunde", null, Customer, null, 2);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_K);
		tabbedPane.insertTab("Ordre", null, Order, null, 3);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_O);
		tabbedPane.insertTab("Medarbejder", null, Employee, null, 4);
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_M);
		//tabbedPane.addTab("Kategori", null, Category, null);
		tabbedPane.insertTab("Lager", null, Storage, null, 5);
		tabbedPane.insertTab("Kategori", null, Category, "Kategori", 5);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Fil");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Gem");
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Hent");
		mnFile.add(mntmLoad);
		
		JMenuItem mntmInsertTestData = new JMenuItem("Indsæt Test Data");
		mntmInsertTestData.setMnemonic(KeyEvent.VK_D);
		mntmInsertTestData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mntmInsertTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Demo().runDemo();
			}
		});
		mnFile.add(mntmInsertTestData);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
	
		mntmLogin = new JMenuItem("Administrator Login");
		mntmLogin.setMnemonic(KeyEvent.VK_A);
		mntmLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); //Event.CTRL_MASK));
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		mnFile.add(mntmLogin);
		
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Hjælp");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Hjælp");
		mnHelp.add(mntmHelp);
		
		tabbedPane.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				Component comp = tabbedPane.getSelectedComponent();
				if (comp.equals(Item)){
					Item.txtName.requestFocusInWindow();
				} else if(comp.equals(Category)){
					Category.txtName.requestFocusInWindow();
				} else if(comp.equals(Sale)){
					Sale.btnAddItem.requestFocusInWindow();
				} else if(comp.equals(Customer)){
					Customer.txtName.requestFocusInWindow();
				}
			}
		});
	}

	protected void login() {
		if(!admin){
			LoginDialog dialog = new LoginDialog(null, this);
			if(admin){
				grantAccess();
			}
		}else if(admin){
			revokeAccess();
		}
	}
	
	protected void grantAccess(){
		mntmLogin.setText("Logud");
		Employee.setAdmin(true);
		reDraw();
	}
	
	protected void revokeAccess(){
		mntmLogin.setText("Administrator Login");
		//tabbedPane.remove(Category);
		Employee.setAdmin(false);
		admin = false;
		reDraw();
	}
	
	public void setAdmin(boolean flag){
		this.admin = flag;
	}
	
	protected void reDraw(){
		revalidate();
		repaint();
	}
	
	public void createItem(){
		CreateItemGUI item = new CreateItemGUI();
		tabbedPane.addTab("Opret Vare", null, item, null);
		tabbedPane.setSelectedComponent(item);
		item.txtName.requestFocusInWindow();
	}
	
	public void createPrivateCustomer(){
		OpretKundeGUI item = new OpretKundeGUI(false);
		tabbedPane.addTab("Opret Privat Kunde", item);
		tabbedPane.setSelectedComponent(item);
		item.txtName.requestFocusInWindow();		
	}
	
	public void createBusinesssCustomer(){
		OpretKundeGUI item = new OpretKundeGUI(true);
		tabbedPane.addTab("Opret Erhvervs Kunde", item);
		tabbedPane.setSelectedComponent(item);
		item.txtName.requestFocusInWindow();		
	}
	
	public void cancelSale(){
		tabbedPane.remove(Sale);
		Sale = new SaleGUI(this);
		tabbedPane.insertTab("Salg", null, Sale, null, 0);
		tabbedPane.setSelectedComponent(Sale);
		reDraw();
	}

	public void keyPressed(KeyEvent arg0) {
		KeyStroke k = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.META_DOWN_MASK);
		if(arg0.equals(k)){
			tabbedPane.setSelectedComponent(Sale);
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
