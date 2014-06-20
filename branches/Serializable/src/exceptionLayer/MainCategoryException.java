package exceptionLayer;

public class MainCategoryException extends Exception {
	private static final long serialVersionUID = 1L;

	public MainCategoryException() {
	}
	
	public MainCategoryException(String arg0) {
		super(arg0);
	}
	
	public MainCategoryException(Throwable arg0) {
		super(arg0);
	}
	
	public MainCategoryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public MainCategoryException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
}
