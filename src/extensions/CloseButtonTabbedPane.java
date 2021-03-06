package extensions;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CloseButtonTabbedPane extends JTabbedPane {
	private int previousTabIndex;
	private int currentTabIndex = 0;
	private JTabbedPane tabbedPane = this;
	private static final long serialVersionUID = 1L;
	
	public CloseButtonTabbedPane() {
		addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				previousTabIndex = currentTabIndex;
				currentTabIndex = tabbedPane.getSelectedIndex();
			}
		});
	}
	
	public void goToPrev() {
		setSelectedIndex(previousTabIndex);
	}
	
	@Override
	public void addTab(String title, Icon icon, Component component, String tip) {
		super.addTab(title, icon, component, tip);
		int count = getTabCount() - 1;
		setTabComponentAt(count, new CloseButtonTab(component, title, icon));
	}
	
	@Override
	public void addTab(String title, Icon icon, Component component) {
		addTab(title, icon, component, null);
	}
	
	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}
	
	public class CloseButtonTab extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public CloseButtonTab(final Component tab, String title, Icon icon) {
			setOpaque(false);
			FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
			setLayout(flowLayout);
			setVisible(true);
			
			JLabel jLabel = new JLabel(title);
			jLabel.setIcon(icon);
			add(jLabel);
			
			JButton button = new JButton("  X  ");
			button.setMargin(new Insets(0, 0, 0, 0));
			button.setBorder(BorderFactory.createLineBorder(new Color(214, 217, 223, 100), 1));
			button.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					CloseButtonTabbedPane tabbedPane = (CloseButtonTabbedPane) getParent().getParent();
					tabbedPane.goToPrev();
					tabbedPane.remove(tab);
				}
				
				public void mousePressed(MouseEvent e) {}
				
				public void mouseReleased(MouseEvent e) {}
				
				public void mouseEntered(MouseEvent e) {
					JButton button = (JButton) e.getSource();
					button.setBorder(BorderFactory.createLineBorder(new Color(214, 217, 223, 100), 1));
				}
				
				public void mouseExited(MouseEvent e) {
					JButton button = (JButton) e.getSource();
					button.setBorder(BorderFactory.createLineBorder(new Color(214, 217, 223, 100), 1));
				}
			});
			add(button);
		}
	}
}
