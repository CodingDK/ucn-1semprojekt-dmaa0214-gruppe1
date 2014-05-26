package exceptionLayer;

public class NoSelectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoSelectionException() {
		super();
	}

	public NoSelectionException(String arg0) {
		super(arg0);
	}

	public NoSelectionException(Throwable arg0) {
		super(arg0);
	}

	public NoSelectionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSelectionException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
