package br.com.waiso.encrypt.des.app;

public class EncriptaDecriptaException extends Exception {

	private static final long serialVersionUID = 3430817230816051929L;
	
	public EncriptaDecriptaException(String message){
        super(message);
    }

    public EncriptaDecriptaException(String message, Throwable cause){
        super(message, cause);
    }
    
    public EncriptaDecriptaException(Class<?> srcClass, String message, Throwable cause) {
		super(message);
	}

}