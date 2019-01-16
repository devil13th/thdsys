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
 * com.thd.module.note.pojo.ModNoteList entity. 
 * file autogenerated by ThirdteenDevils's CodeGenUtil
 */
@Entity
@Table(name="mod_note_list")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ModNoteList implements java.io.Serializable {
	//PK  
	@Id
	@GenericGenerator(name = "idGeneratorForModNoteList", strategy = "uuid.hex")  
	@GeneratedValue(generator = "idGeneratorForModNoteList")
	@Column(name="note_id" ,length=50)
	private java.lang.String noteId;
	
	
	
	
	//
	//varchar
	@Column(name="note_title" ,length=255)
	private java.lang.String noteTitle;
	
	//
	//varchar
	@Column(name="note_desc" ,length=500)
	private java.lang.String noteDesc;
	
	//
	//varchar
	@Column(name="note_classify" ,length=255)
	private java.lang.String noteClassify;
	
	//
	//varchar
	@Column(name="is_delete" ,length=255)
	private java.lang.String isDelete;
	
	//
	//date
	@Temporal(TemporalType.DATE)
	@Column(name="expire_date" )
	private java.util.Date expireDate;
	
	//
	//int
	@Column(name="alarm_days" )
	private java.lang.Integer alarmDays;
	
	//
	//datetime
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cre_time" )
	private java.util.Date creTime;
	
	//
	//varchar
	@Column(name="cre_user" ,length=50)
	private java.lang.String creUser;
	
	//
	//datetime
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mod_time" )
	private java.util.Date modTime;
	
	//
	//varchar
	@Column(name="mod_user" ,length=50)
	private java.lang.String modUser;
	







	
	public void setNoteId(java.lang.String noteId){
		this.noteId = noteId;
	}
	public java.lang.String getNoteId(){
		return this.noteId;
	}
	public void setNoteTitle(java.lang.String noteTitle){
		this.noteTitle = noteTitle;
	}
	public java.lang.String getNoteTitle(){
		return this.noteTitle;
	}
	public void setNoteDesc(java.lang.String noteDesc){
		this.noteDesc = noteDesc;
	}
	public java.lang.String getNoteDesc(){
		return this.noteDesc;
	}
	public void setNoteClassify(java.lang.String noteClassify){
		this.noteClassify = noteClassify;
	}
	public java.lang.String getNoteClassify(){
		return this.noteClassify;
	}
	public void setIsDelete(java.lang.String isDelete){
		this.isDelete = isDelete;
	}
	public java.lang.String getIsDelete(){
		return this.isDelete;
	}
	public void setExpireDate(java.util.Date expireDate){
		this.expireDate = expireDate;
	}
	public java.util.Date getExpireDate(){
		return this.expireDate;
	}
	public void setAlarmDays(java.lang.Integer alarmDays){
		this.alarmDays = alarmDays;
	}
	public java.lang.Integer getAlarmDays(){
		return this.alarmDays;
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