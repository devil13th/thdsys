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
@Table(name="sys_dic_pub")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SysDicPub implements Serializable {
	public SysDicPub() {
    }
	@Id
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")  
	@Column(name="dic_id",length=50)
	private String dicId;
	@Column(name="dic_name",length=50)
	private String dicName;
	@Column(name="dic_desc",length=50)
	private String dicDesc;
	@Column(name="dic_classify",length=500)
	private String dicClassify;
	public String getDicId() {
		return dicId;
	}
	public void setDicId(String dicId) {
		this.dicId = dicId;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	public String getDicDesc() {
		return dicDesc;
	}
	public void setDicDesc(String dicDesc) {
		this.dicDesc = dicDesc;
	}
	public String getDicClassify() {
		return dicClassify;
	}
	public void setDicClassify(String dicClassify) {
		this.dicClassify = dicClassify;
	}
	
}
