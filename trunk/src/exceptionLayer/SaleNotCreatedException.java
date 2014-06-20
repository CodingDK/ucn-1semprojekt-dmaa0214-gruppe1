package exceptionLayer;

public class SaleNotCreatedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SaleNotCreatedException() {
		super();
	}
	
	public SaleNotCreatedException(String arg0) {
		super(arg0);
	}
	
	public SaleNotCreatedException(Throwable arg0) {
		super(arg0);
	}
	
	public SaleNotCreatedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
