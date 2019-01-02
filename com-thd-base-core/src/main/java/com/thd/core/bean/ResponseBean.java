package com.thd.core.bean;

import java.io.Serializable;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBean implements Serializable{
	
	
	final static String  SUCCESS = "SUCCESS";
	final static String  FAILURE = "FAILURE";
	
	//状态码
	private HttpStatus httpStatus = HttpStatus.OK;
	//返回的对象
	private Object result;
	//状态
	private String status;
	//错误信息 
	private String errMessage;
	//http header信息
	private HttpHeaders header = new HttpHeaders();
	//全部异常信息
	private Exception e;
	
	
	public ResponseEntity<ResponseBean> success(){
		this.setStatus(this.SUCCESS);
		return new ResponseEntity(this,header,httpStatus);
	}
	
	public ResponseEntity<ResponseBean> failure(){
		this.setStatus(this.FAILURE);
		return new ResponseEntity(this,header,httpStatus);
	}
	
	
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		header.set("status",status);
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public HttpHeaders getHeader() {
		return header;
	}

	public void setHeader(HttpHeaders header) {
		this.header = header;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	public static String getSuccess() {
		return SUCCESS;
	}

	public static String getFailure() {
		return FAILURE;
	}

	
	
	
	
	
	
	
	
}
