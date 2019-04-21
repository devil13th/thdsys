package com.thd.base.test.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestMethodBean {
	
	private String id;
    private String name;
    private Integer age;
    private String address;
    private String Info;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") //用于post form data 方式获取转换
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")	//用于post requestBody 方式获取转换
    private Date createTime;
    public RequestMethodBean() {
    }

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
    @Column(name="id",length=50)
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	//精确到时分秒
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	//@Transient 不映射到数据库
    @Transient
    public String getInfo(){
    	return this.name + " : " + this.age;
    }
    
    public void setInfo(String info) {
		Info = info;
	}
}
