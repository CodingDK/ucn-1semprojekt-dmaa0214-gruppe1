package exceptionLayer;

public class NotEnoughItemsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NotEnoughItemsException() {
		super();
	}
	
	public NotEnoughItemsException(String arg0) {
		super(arg0);
	}
	
	public NotEnoughItemsException(Throwable arg0) {
		super(arg0);
	}
	
	public NotEnoughItemsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public NotEnoughItemsException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
}
