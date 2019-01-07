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
@Table(name="sys_org")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SysOrg implements Serializable {
	public SysOrg() {
    }
	@Id
	@GenericGenerator(name = "assignedGenerator", strategy = "assigned")  
	@GeneratedValue(generator = "assignedGenerator")     
	@Column(name="org_id",length=50)
	private String orgId;
	@Column(name="org_code",length=50)
	private String orgCode;
	@Column(name="org_tree_code",length=200)
	private String orgTreeCode;
	@Column(name="org_name",length=200)
	private String orgName;
	@Column(name="org_is_leaf",length=10)
	private String orgIsLeaf;
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgTreeCode() {
		return orgTreeCode;
	}
	public void setOrgTreeCode(String orgTreeCode) {
		this.orgTreeCode = orgTreeCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgIsLeaf() {
		return orgIsLeaf;
	}
	public void setOrgIsLeaf(String orgIsLeaf) {
		this.orgIsLeaf = orgIsLeaf;
	}
}
