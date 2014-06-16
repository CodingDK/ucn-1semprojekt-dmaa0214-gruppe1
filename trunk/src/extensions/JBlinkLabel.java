package extensions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class JBlinkLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private static final int BLINKING_RATE = 500;
	private boolean blinkingOn = true;
	private boolean state = false;
	
	public JBlinkLabel(String text) {
		super(text);
		Timer timer = new Timer( BLINKING_RATE , new TimerListener(this));
		timer.setInitialDelay(0);
		timer.start();
	}
	
	public void startBlinking(boolean flag, boolean isError) {
		this.state = isError;
		this.blinkingOn = flag;
	}
	
	private void setBlinking(boolean flag){
		this.blinkingOn = flag;
	}
	
	private boolean getState(){
		return this.state;
	}
	
	private class TimerListener implements ActionListener {
		private JBlinkLabel bl;
		private Color bg;
		private Color fg;
		private boolean isForeground = true;
		private int interval = 0;
		
		public TimerListener(JBlinkLabel bl) {
			this.bl = bl;
			fg = Color.BLACK;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(bl.getState()){
				bg = Color.RED;
			}else{
				bg = Color.GREEN;
			}
			if (bl.blinkingOn) {	
				interval++;
				if (isForeground) {
					bl.setForeground(fg);
				} else {
					bl.setForeground(bg);
				}
				isForeground = !isForeground;
				if(interval > 10){
					bl.setBlinking(false);
					bl.setText("");
					interval = 0;
				}
			}else {
				if (isForeground) {
					bl.setForeground(fg);
					isForeground = false;
				}
			}
			
		}
	}
}