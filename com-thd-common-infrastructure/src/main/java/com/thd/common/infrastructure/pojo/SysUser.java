package com.thd.common.infrastructure.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sys_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SysUser implements Serializable {
	public SysUser() {
    }
	@Id
	@GenericGenerator(name = "assignedGenerator", strategy = "assigned")  
	@GeneratedValue(generator = "assignedGenerator")     
	@Column(name="user_id",length=50)
	private String userId;
	
	@Column(name="user_name",length=50)
	private String userName;
	
	@Column(name="user_account",length=50)
	private String userAccount;
	
	@Column(name="user_password",length=50)
	private String userPassword;
	
	@Column(name="company_name",length=200)
	private String companyName;
	
	@Column(name="user_mail",length=100)
	private String userMail;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
}
