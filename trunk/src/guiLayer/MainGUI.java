package guiLayer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import personLayer.Customer;
import ctrLayer.Demo;
import extensions.CloseButtonTabbedPane;

public class MainGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	public boolean admin = false;
	private JMenuItem mntmLogin;
	private CloseButtonTabbedPane tabbedPane;
	private SaleGUI sale;
	private ItemGUI item;
	private CustomerGUI customer;
	private OrderGUI order;
	private EmployeeGUI employee;
	private StorageGUI storage;
	private CategoryGUI category;
	
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
					window.setTitle("Vestbjerg Byggecenter A/S");
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
		
		sale = new SaleGUI(this, null);
		item = new ItemGUI(this);
		customer = new CustomerGUI(this);
		order = new OrderGUI();
		employee = new EmployeeGUI(this);
		category = new CategoryGUI();
		storage = new StorageGUI();
		
		tabbedPane.insertTab("Salg", null, sale, null, 0);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_S);
		tabbedPane.insertTab("Varer", null, item, null, 1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_V);
		tabbedPane.insertTab("Kunde", null, customer, null, 2);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_K);
		tabbedPane.insertTab("Ordre", null, order, null, 3);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_O);
		
		makeTabbedPaneSwitcher();
		
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
		mntmLogin.setMnemonic(KeyEvent.VK_L);
		mntmLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); //Event.CTRL_MASK));
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
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help();
			}
		});
		mnHelp.add(mntmHelp);
		
		tabbedPane.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				Component comp = tabbedPane.getSelectedComponent();
				if (comp.equals(item)){
					item.update();
					item.txtName.requestFocusInWindow();
				} else if(comp.equals(category)){
					category.txtName.requestFocusInWindow();
					getRootPane().setDefaultButton(category.btnCreate);
				} else if(comp.equals(sale)){
					sale.btnAddItem.requestFocusInWindow();
					getRootPane().setDefaultButton(sale.btnAddItem);
				} else if(comp.equals(customer)){
					customer.txtName.requestFocusInWindow();
					getRootPane().setDefaultButton(customer.btnFind);
				} else if(comp.equals(employee)){
					employee.txtName.requestFocusInWindow();
					getRootPane().setDefaultButton(employee.btnFind);
				} else if(comp.equals(storage)){
					storage.txtStorageName.requestFocusInWindow();
					getRootPane().setDefaultButton(storage.btnOpret);
				} else if(comp.equals(order)){
					//TODO
					order.txtName.requestFocusInWindow();
					getRootPane().setDefaultButton(order.btnSearch);
					order.update();
				}
			}
			
		});
	}

	private void help() {
		JOptionPane.showMessageDialog(null, "Du er helt alene.. ingen hjælp her :(","Advarsel",JOptionPane.WARNING_MESSAGE);
	}

	private void makeTabbedPaneSwitcher() {
		InputMap im = tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-s");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-v");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_K, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-k");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-o");
		ActionMap am = tabbedPane.getActionMap();
		am.put("ctrl-s", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedIndex(0);
			}
		});
		
		am.put("ctrl-v", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedIndex(1);
			}
		});
		
		am.put("ctrl-k", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedIndex(2);
			}
		});
		
		am.put("ctrl-o", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedIndex(3);
			}
		});
	}

	protected void login() {
		if(!admin){
			new LoginDialog(null, this);
			if(admin){
				grantAccess();
				
			}
		}else if(admin){
			revokeAccess();
		}
	}
	
	protected void grantAccess(){
		mntmLogin.setText("Logud");
		employee.setAdmin(true);
		tabbedPane.insertTab("Medarbejder", null, employee, null, 4);
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_M);
		tabbedPane.insertTab("Lager", null, storage, null, 5);
		tabbedPane.insertTab("Kategori", null, category, "Kategori", 5);
		reDraw();
	}
	
	protected void revokeAccess(){
		mntmLogin.setText("Administrator Login");
		//tabbedPane.remove(Category);
		employee.setAdmin(false);
		admin = false;
		tabbedPane.remove(employee);
		tabbedPane.remove(storage);
		tabbedPane.remove(category);
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
		CreateItemGUI comp = new CreateItemGUI(this, item);
		addPaneToTab(comp, "Opret Vare");
	}

	public void createPrivateCustomer(Component c){
		CreateCustomerGUI comp = new CreateCustomerGUI(false, c, this);
		addPaneToTab(comp, "Opret Privat Kunde");
	}

	public void createPrivateCustomer(SaleGUI sGUI){
		CreateCustomerGUI comp = new CreateCustomerGUI(false, sGUI, this);
		addPaneToTab(comp, "Opret Privat Kunde");
	}

	public void createBusinesssCustomer(Component c){
		CreateCustomerGUI comp = new CreateCustomerGUI(true, c, this);
		addPaneToTab(comp, "Opret Erhvervs Kunde");
	}
	
	public void createBusinesssCustomer(SaleGUI sGUI){
		CreateCustomerGUI comp = new CreateCustomerGUI(true, sGUI, this);
		addPaneToTab(comp, "Opret Erhvervs Kunde");
	}
	
	public void addPaneToTab(Component c, String title){
		tabbedPane.addTab(title, c);
		tabbedPane.setSelectedComponent(c);
	}
	
	public void switchPane(Component c){
		tabbedPane.setSelectedComponent(c);
	}
		
	public void setSelectedToSale(boolean b, Customer selectedCus){
		if(b){
			tabbedPane.setSelectedComponent(sale);
			if (selectedCus != null){
				sale.setCustomer(selectedCus);
			}
		} else {
			tabbedPane.setSelectedComponent(customer);
		}
	}
	
	public void resetSale(){
		tabbedPane.remove(sale);
		sale = new SaleGUI(this, null);
		tabbedPane.insertTab("Salg", null, sale, null, 0);
		tabbedPane.setSelectedComponent(sale);
		reDraw();
	}
}
