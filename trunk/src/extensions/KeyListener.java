
package extensions;

import guiLayer.MainGUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;

public class KeyListener {

	private boolean done;
	public KeyListener() {
		// TODO Auto-generated constructor stub
		this.done = false;
	}

	public void addEscapeListener(final JDialog dialog) {
		ActionListener escListener = new ActionListener() {
			
	        public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false); 
				dialog.dispose();
	        }
	    };
	    dialog.getRootPane().registerKeyboardAction(escListener,
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);
		
	}
	
	public void addEscapeListenerToTab(final Component creator, final MainGUI mainGUI, final Component tab){
		ActionListener escListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!done){
					int tabIndex = mainGUI.getSelectedTab();
					mainGUI.switchPane(creator);
					((JPanel) tab).getParent().remove(tabIndex);
					done = true;
				}
	        }
	    };
	    mainGUI.getRootPane().registerKeyboardAction(escListener,
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

}
