package com.thd.base.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="transaction_test")
public class TransactionTest {
	

	private String id;
    private Integer ct;
    private String name;
    private Long version;
    public TransactionTest() {
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
    public Integer getCt() {
		return ct;
	}
	public void setCt(Integer ct) {
		this.ct = ct;
	}
	@Column(name="name",length=50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Version
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
}
