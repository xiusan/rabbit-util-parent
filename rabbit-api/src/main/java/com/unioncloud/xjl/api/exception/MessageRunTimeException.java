package com.unioncloud.xjl.api.exception;

/**
 * 	$MessageRunTimeException
 * @author xjl
 *
 */
public class MessageRunTimeException extends RuntimeException {

	private static final long serialVersionUID = 8651828913888663267L;

	public MessageRunTimeException() {
		super();
	}
	
	public MessageRunTimeException(String message) {
		super(message);
	}
	
	public MessageRunTimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MessageRunTimeException(Throwable cause) {
		super(cause);
	}
}
