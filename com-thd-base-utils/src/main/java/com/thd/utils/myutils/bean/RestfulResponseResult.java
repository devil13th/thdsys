package com.thd.utils.myutils.bean;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.thd.utils.myutils.exception.MyException;


/**
 * 该类是用于restful服务出现错误时返回客户端的DTO
 * @author wangl
 *
 */
public class RestfulResponseResult {
	//HTTP状态码(只有为200才是正确返回,如果不是200则需要设置message属性)
	private int httpCode ;
	
	//HTTP状态码对应英文状态
	private HttpStatus httpStatus;
	//返回结果
	private Object result;
	//消息
    private String message;
    //错误
    private Exception exception;

    
    public static ResponseEntity returnSuccess(Object obj){
    	RestfulResponseResult rrr = new RestfulResponseResult();
    	rrr.setHttpStatus(HttpStatus.OK);
    	rrr.setHttpCode(HttpStatus.OK.value());
    	rrr.setResult(obj);
    	return new ResponseEntity<RestfulResponseResult>(rrr,rrr.getHttpStatus());
    }
    
    public static ResponseEntity returnFailure(HttpStatus httpStatus,String message){
    	RestfulResponseResult rrr = new RestfulResponseResult();
    	rrr.setHttpStatus(httpStatus);
    	rrr.setHttpCode(httpStatus.value());
    	rrr.setMessage(message);
    	return new ResponseEntity<RestfulResponseResult>(rrr,rrr.getHttpStatus());
    }
    
    public static ResponseEntity returnFailure(HttpStatus httpStatus,String message,Exception e){
    	RestfulResponseResult rrr = new RestfulResponseResult();
    	rrr.setHttpStatus(httpStatus);
    	rrr.setHttpCode(httpStatus.value());
    	rrr.setMessage(message);
    	return new ResponseEntity<RestfulResponseResult>(rrr,rrr.getHttpStatus());
    }
    
    public static ResponseEntity returnFailure(Exception e){
    	RestfulResponseResult rrr = new RestfulResponseResult();
    	rrr.setException(e);
    	rrr.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    	rrr.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    	
    	boolean isFather = MyException.class.isAssignableFrom(e.getClass());  
    	
    	//如果是业务主动抛出的异常则将错误信息设置到message属性上
    	if( isFather){
    		rrr.setMessage(e.getMessage());
    	}else{
    		rrr.setMessage("系统错误");
    	}
    	System.out.println(e.getClass());
    	return new ResponseEntity<RestfulResponseResult>(rrr,rrr.getHttpStatus());
    }
    
    
    

    public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
}
