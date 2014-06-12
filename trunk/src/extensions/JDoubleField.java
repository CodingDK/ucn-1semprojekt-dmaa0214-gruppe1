package extensions;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JDoubleField extends JTextField {
	private static final long serialVersionUID = 1L;
	
	public JDoubleField(){
		super();
	}
	
	public JDoubleField(int col){
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
				if(chars[i] == '.'){
					if(getLength() == 0){
						go = false;
						break;
					}else if(getText(0, getLength()).contains(".")){
						go = false;
						break;
					}
				} else {
					try{
						Double.parseDouble(String.valueOf(chars[i]));
					}catch(NumberFormatException e){
						go = false;
						break;
					}
				}
			}
			
			if(go){
				super.insertString(offs, new String(chars), a);
			}
		}
	}
}
