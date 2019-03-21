package com.init.crud.bean;

import java.util.Date;

public class Record {
    private Integer recId;

    private Integer recItemId;

    private String recDepartmentName;

    private Date recDate;

    private String recRemark;

    private String recPerson;
    
    

    public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Record(Integer recId, Integer recItemId, String recDepartmentName, Date recDate, String recRemark,
			String recPerson) {
		super();
		this.recId = recId;
		this.recItemId = recItemId;
		this.recDepartmentName = recDepartmentName;
		this.recDate = recDate;
		this.recRemark = recRemark;
		this.recPerson = recPerson;
	}

	public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getRecItemId() {
        return recItemId;
    }

    public void setRecItemId(Integer recItemId) {
        this.recItemId = recItemId;
    }

    public String getRecDepartmentName() {
        return recDepartmentName;
    }

    public void setRecDepartmentName(String recDepartmentName) {
        this.recDepartmentName = recDepartmentName == null ? null : recDepartmentName.trim();
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public String getRecRemark() {
        return recRemark;
    }

    public void setRecRemark(String recRemark) {
        this.recRemark = recRemark == null ? null : recRemark.trim();
    }

    public String getRecPerson() {
        return recPerson;
    }

    public void setRecPerson(String recPerson) {
        this.recPerson = recPerson == null ? null : recPerson.trim();
    }
}