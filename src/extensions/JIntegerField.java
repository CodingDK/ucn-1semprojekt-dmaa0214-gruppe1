package extensions;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JIntegerField extends JTextField {
	private static final long serialVersionUID = 1L;
	
	public JIntegerField(){
		super();
	}
	
	public JIntegerField(int col){
		super(col);
	}
	
	@Override
	protected Document createDefaultModel(){
		return new UpperCaseDocument();
	}
	
	static class UpperCaseDocument extends PlainDocument{
		private static final long serialVersionUID = 1L;
		
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
			if(str == null){
				return;
			}
			
			char[] chars = str.toCharArray();
			boolean go = true;
			
			for(int i = 0; i < chars.length; i++){
				try{
					Integer.parseInt(String.valueOf(chars[i]));
				}catch(NumberFormatException e){
					go = false;
					break;
				}
			}
			
			if(go){
				super.insertString(offs, new String(chars), a);
			}
		}
	}
}
