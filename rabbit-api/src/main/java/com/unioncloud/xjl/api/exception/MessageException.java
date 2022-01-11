package com.unioncloud.xjl.api.exception;

/**
 * 	$MessageException
 * @author xjl
 *
 */
public class MessageException extends Exception {

	private static final long serialVersionUID = 6347951066190728758L;

	public MessageException() {
		super();
	}
	
	public MessageException(String message) {
		super(message);
	}
	
	public MessageException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MessageException(Throwable cause) {
		super(cause);
	}
	
}
