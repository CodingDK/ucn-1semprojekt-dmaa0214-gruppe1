package extensions;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SpaceDocument extends PlainDocument {
	private boolean oneSpace;
	private static final long serialVersionUID = 1L;
	
	public SpaceDocument(boolean oneSpace) {
		this.oneSpace = oneSpace;
	}
	
	public SpaceDocument() {
		oneSpace = true;
	}
	
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		boolean go = true;
		if (str == null) {
			return;
		} else if (!oneSpace) {
			if (str.equals(" ")) {
				return;
			}
		} else if (getLength() == 0 && str.equals(" ")) {
			return;
		} else if (str.equals(" ")) {
			if (getLength() > 0) {
				if (getText(0, getLength()).charAt(getLength() - 1) == ' ') {
					return;
				}
			}
		} else {
			
		}
		
		if (go) {
			super.insertString(offs, str, a);
		}
	}
}
