package training.exceptions;

public class CustomException extends Exception{
	public CustomException(String message){
		super(message);
	}
	public CustomException(String message,Exception cause){
		super(message,cause);
	}

}
