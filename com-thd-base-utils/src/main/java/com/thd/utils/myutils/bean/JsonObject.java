package com.thd.utils.myutils.bean;

public class JsonObject {
	private String status;
	private String errMsg;
	private Object objJson;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Object getObjJson() {
		return objJson;
	}
	public void setObjJson(Object objJson) {
		this.objJson = objJson;
	}
}
