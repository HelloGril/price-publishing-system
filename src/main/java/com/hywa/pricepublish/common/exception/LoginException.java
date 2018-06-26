package com.hywa.pricepublish.common.exception;


/**
 * 自定义一个异常处理基类
 * 原理：继承一个RuntimeException可以直接断开事务，如果使用Exception做基类，将不会对事务产生影响
 * @author jiang
 */


public class LoginException extends RuntimeException{

	private static final long serialVersionUID = 6884443738106271335L;
	
	private Long code = -1L;
	
	public LoginException(Long code,String message){
		super(message);
		this.code = code;
	}
	public LoginException(String message){
		super(message);
	}

	
}
