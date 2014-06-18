
package extensions;

import guiLayer.MainGUI;

import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class KeyListener {
	private boolean done;
	
	public KeyListener() {
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
				Component[] components = mainGUI.getTabbedPane().getComponents();
				ArrayList<Component> cont = new ArrayList<Component>(Arrays.asList(components));
				if(cont.contains(tab)){
					mainGUI.switchPane(creator);
					((JPanel) tab).getParent().remove(tab);
				}
	        }
	    };
	    mainGUI.getRootPane().registerKeyboardAction(escListener,
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

}
