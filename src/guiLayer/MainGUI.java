package guiLayer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
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

import modelLayer.Help;
import modelLayer.Item;
import modelLayer.Sale;
import personLayer.Customer;
import ctrLayer.Demo;
import ctrLayer.HelpCtr;
import extensions.CloseButtonTabbedPane;

import javax.swing.JButton;

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
		this.setLocationByPlatform(true);
		
		tabbedPane = new CloseButtonTabbedPane();
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		sale = new SaleGUI(this, null);
		item = new ItemGUI(this);
		customer = new CustomerGUI(this);
		order = new OrderGUI(this);
		employee = new EmployeeGUI(this);
		category = new CategoryGUI(this);
		storage = new StorageGUI(this);
		
		tabbedPane.insertTab("Salg", null, sale, null, 0);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_S);
		tabbedPane.insertTab("Varer", null, item, null, 1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_V);
		tabbedPane.insertTab("Kunde", null, customer, null, 2);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_K);
		tabbedPane.insertTab("Ordre", null, order, null, 3);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_O);
		tabbedPane.insertTab("Medarbejder", null, employee, null, 4);
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_M);
		
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
		mntmInsertTestData.setMnemonic(KeyEvent.VK_F2);
		mntmInsertTestData.setAccelerator(KeyStroke.getKeyStroke("F2"));
		mntmInsertTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Demo().runDemo();
			}
		});
		mnFile.add(mntmInsertTestData);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
	
		mntmLogin = new JMenuItem("Administrator Login");
		mntmLogin.setMnemonic(KeyEvent.VK_F3);
		mntmLogin.setAccelerator(KeyStroke.getKeyStroke("F3")); 
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		mnFile.add(mntmLogin);
		
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_F12);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke("F12"));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Hjælp");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Hjælp");
		mntmHelp.setMnemonic(KeyEvent.VK_F1);
		mntmHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help();
			}
		});
		mnHelp.add(mntmHelp);
		getRootPane().setDefaultButton(sale.btnAddItem);
		
		tabbedPane.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				Component comp = tabbedPane.getSelectedComponent();
				if (comp.equals(item)){
					item.update();
					item.txtName.requestFocusInWindow();
					getRootPane().setDefaultButton(item.btnSearch);
				} else if(comp.equals(category)){
					category.txtName.requestFocusInWindow();
					getRootPane().setDefaultButton(category.btnCreate);
				} else if(comp.equals(sale)){
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
					order.txtName.requestFocusInWindow();
					getRootPane().setDefaultButton(order.btnSearch);
					order.update();
				}
			}
			
		});
	}
	
	public int getSelectedTab(){
		return tabbedPane.getSelectedIndex();
	}

	private void help() {
		try {
			HelpCtr hCtr = new HelpCtr();
			String pane = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
			Help h = hCtr.getHelp(pane);
			if(h != null){
				JOptionPane.showMessageDialog(this, h.getHelp(),h.getName(),JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

	private void makeTabbedPaneSwitcher() {
		InputMap im = tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-s");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-v");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_K, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-k");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-o");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_M, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-m");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-l");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "ctrl-t");
		
		ActionMap am = tabbedPane.getActionMap();
		
		am.put("ctrl-s", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedComponent(sale);
			}
		});
		
		am.put("ctrl-v", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedComponent(item);
			}
		});
		
		am.put("ctrl-k", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedComponent(customer);
			}
		});
		
		am.put("ctrl-o", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedComponent(order);
			}
		});
		
		am.put("ctrl-m", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				tp.setSelectedComponent(employee);
			}
		});
		
		am.put("ctrl-l", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				if(admin){
					tp.setSelectedComponent(storage);
				}
			}
		});
		
		am.put("ctrl-t", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				CloseButtonTabbedPane tp = (CloseButtonTabbedPane)e.getSource();
				if(admin){
					tp.setSelectedComponent(category);
				}
			}
		});
	}

	protected void login() {
		if(!admin){
			JDialog login = new LoginDialog(null, this);
            login.setLocationRelativeTo(this);
            login.setVisible(true);
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
		tabbedPane.insertTab("Lager", null, storage, null, 5);
		tabbedPane.setMnemonicAt(5, KeyEvent.VK_L);
		tabbedPane.insertTab("Kategori", null, category, "Kategori", 6);
		tabbedPane.setMnemonicAt(6, KeyEvent.VK_T);
		reDraw();
	}
	
	protected void revokeAccess(){
		mntmLogin.setText("Administrator Login");
		//tabbedPane.remove(Category);
		employee.setAdmin(false);
		admin = false;
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
		CreateItemGUI comp = new CreateItemGUI(this, item, null);
		addPaneToTab(comp, "Opret Vare");
	}
	
	public void updateItem(Item updateItem){
		CreateItemGUI comp = new CreateItemGUI(this, item, updateItem);
		addPaneToTab(comp, "Ret Vare");
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
	
	public void createEmployee(Component e){
		CreateEmployeeGUI comp = new CreateEmployeeGUI(e, this);
		addPaneToTab(comp, "Opret medarbejder");
		//CreateEmployee comp = new CreateEmployee(e, this);
		//addPaneToTab(comp, "Opret medarbejder");

	}
	
	public void addPaneToTab(Component c, String title){
		tabbedPane.addTab(title, c);
		tabbedPane.setSelectedComponent(c);
	}
	
	public void switchPane(Component c){
		tabbedPane.setSelectedComponent(c);
	}
		
	public void setSelectedToSale(boolean b, Object selected){
		if(selected instanceof Customer || selected == null){
			Customer selectedCus = (Customer) selected;
			if(b){
				tabbedPane.setSelectedComponent(sale);
				if (selectedCus != null){
					sale.setCustomer(selectedCus);
				}
			} else {
				tabbedPane.setSelectedComponent(customer);
			}
		}else if(selected instanceof Sale){
			int choice = sale.parkSale();
			if(choice == 3){
				Sale selectedSale = (Sale) selected;
				if(!selectedSale.isDone()){
					tabbedPane.remove(sale);
					sale = new SaleGUI(this, selectedSale);
					tabbedPane.insertTab("Salg", null, sale, null, 0);
					tabbedPane.setSelectedComponent(sale);
				}
			}
		}
	}
	
	public void resetSale(){
		tabbedPane.remove(sale);
		sale = new SaleGUI(this, null);
		tabbedPane.insertTab("Salg", null, sale, null, 0);
		tabbedPane.setSelectedComponent(sale);
		reDraw();
	}

	public void addToSale(Item i) {
		sale.addItem(i);
		tabbedPane.setSelectedComponent(sale);
	}
}
