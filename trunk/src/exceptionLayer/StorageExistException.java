package exceptionLayer;

public class StorageExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public StorageExistException() {}
	
	public StorageExistException(String message) {
		super(message);
	}
	
	public StorageExistException(Throwable cause) {
		super(cause);
	}
	
	public StorageExistException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public StorageExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
