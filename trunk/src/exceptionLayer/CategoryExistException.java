package exceptionLayer;

public class CategoryExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public CategoryExistException() {
	}
	
	public CategoryExistException(String arg0) {
		super(arg0);
	}
	
	public CategoryExistException(Throwable arg0) {
		super(arg0);
	}
	
	public CategoryExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public CategoryExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
}
