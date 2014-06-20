package extensions;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
	private static final long serialVersionUID = 1L;
	private int limit;
	private boolean onlyInt;
	
	public JTextFieldLimit(int limit, boolean onlyInt) {
		super();
		this.limit = limit;
		this.onlyInt = onlyInt;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
		if(str == null) return;
		boolean go = true;
		if(onlyInt){
			char[] chars = str.toCharArray();
			
			for(int i = 0; i < chars.length; i++){
				try{
					Integer.parseInt(String.valueOf(chars[i]));
				}catch(NumberFormatException e){
					go = false;
					break;
				}
			}
		}
		
		if(go && ((getLength() + str.length()) <= limit)){
			super.insertString(offset, str, attr);
		}
	}
	
}
