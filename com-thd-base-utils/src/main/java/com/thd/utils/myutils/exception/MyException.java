package com.thd.utils.myutils.exception;

public class MyException extends RuntimeException {
	public MyException(){};
	public MyException(String message) {
        super(message);
    }
}
