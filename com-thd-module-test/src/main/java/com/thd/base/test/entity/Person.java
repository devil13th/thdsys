package com.thd.base.test.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


@Entity
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
        query = "select p from Person p where p.name=?1 and p.address=?2")
public class Person implements Serializable{
    
    

	private String id;
    private String name;
    private Integer age;
    private String address;
    private String Info;
    private Date birthday;
    private Date createTime;
    public Person() {
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
    
    //Date 类型默认时分秒，如果只要精确到日则需要使用时间戳则需要添加TemporalType.DATE
    @Temporal(TemporalType.DATE)
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
