package exceptionLayer;

public class SaleNotCreatedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SaleNotCreatedException() {
		super();
	}
	
	public SaleNotCreatedException(final String arg0) {
		super(arg0);
	}
	
	public SaleNotCreatedException(final Throwable arg0) {
		super(arg0);
	}
	
	public SaleNotCreatedException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
	}
	
	public SaleNotCreatedException(final String arg0, final Throwable arg1, final boolean arg2,
			final boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
}
