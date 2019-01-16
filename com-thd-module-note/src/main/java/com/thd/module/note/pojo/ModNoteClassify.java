package com.thd.module.note.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * com.thd.module.note.pojo.ModNoteClassify entity. 
 * file autogenerated by ThirdteenDevils's CodeGenUtil
 */
@Entity
@Table(name="mod_note_classify")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ModNoteClassify implements java.io.Serializable {
	//PK  分类标识
	@Id
	@GenericGenerator(name = "idGeneratorForModNoteClassify", strategy = "uuid.hex")  
	@GeneratedValue(generator = "idGeneratorForModNoteClassify")
	@Column(name="classify_id" ,length=50)
	private java.lang.String classifyId;
	
	
	
	
	//名称
	//varchar
	@Column(name="classify_name" ,length=255)
	private java.lang.String classifyName;
	
	//树码
	//varchar
	@Column(name="classify_tree_code" ,length=255)
	private java.lang.String classifyTreeCode;
	
	//排序号
	//varchar
	@Column(name="classify_sort" ,length=255)
	private java.lang.String classifySort;
	
	//备注
	//varchar
	@Column(name="classify_memo" ,length=500)
	private java.lang.String classifyMemo;
	
	//是否叶子节点 1是 0否
	//varchar
	@Column(name="is_leaf" ,length=10)
	private java.lang.String isLeaf;
	
	//是否删除 1否 0是
	//varchar
	@Column(name="is_delete" ,length=255)
	private java.lang.String isDelete;
	
	//创建时间
	//datetime
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cre_time" )
	private java.util.Date creTime;
	
	//创建人
	//varchar
	@Column(name="cre_user" ,length=50)
	private java.lang.String creUser;
	
	//修改时间
	//datetime
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mod_time" )
	private java.util.Date modTime;
	
	//修改人
	//varchar
	@Column(name="mod_user" ,length=50)
	private java.lang.String modUser;
	







	
	public void setClassifyId(java.lang.String classifyId){
		this.classifyId = classifyId;
	}
	public java.lang.String getClassifyId(){
		return this.classifyId;
	}
	public void setClassifyName(java.lang.String classifyName){
		this.classifyName = classifyName;
	}
	public java.lang.String getClassifyName(){
		return this.classifyName;
	}
	public void setClassifyTreeCode(java.lang.String classifyTreeCode){
		this.classifyTreeCode = classifyTreeCode;
	}
	public java.lang.String getClassifyTreeCode(){
		return this.classifyTreeCode;
	}
	public void setClassifySort(java.lang.String classifySort){
		this.classifySort = classifySort;
	}
	public java.lang.String getClassifySort(){
		return this.classifySort;
	}
	public void setClassifyMemo(java.lang.String classifyMemo){
		this.classifyMemo = classifyMemo;
	}
	public java.lang.String getClassifyMemo(){
		return this.classifyMemo;
	}
	public void setIsLeaf(java.lang.String isLeaf){
		this.isLeaf = isLeaf;
	}
	public java.lang.String getIsLeaf(){
		return this.isLeaf;
	}
	public void setIsDelete(java.lang.String isDelete){
		this.isDelete = isDelete;
	}
	public java.lang.String getIsDelete(){
		return this.isDelete;
	}
	public void setCreTime(java.util.Date creTime){
		this.creTime = creTime;
	}
	public java.util.Date getCreTime(){
		return this.creTime;
	}
	public void setCreUser(java.lang.String creUser){
		this.creUser = creUser;
	}
	public java.lang.String getCreUser(){
		return this.creUser;
	}
	public void setModTime(java.util.Date modTime){
		this.modTime = modTime;
	}
	public java.util.Date getModTime(){
		return this.modTime;
	}
	public void setModUser(java.lang.String modUser){
		this.modUser = modUser;
	}
	public java.lang.String getModUser(){
		return this.modUser;
	}
	
	

}