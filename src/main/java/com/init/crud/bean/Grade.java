package com.init.crud.bean;

import java.util.Date;

public class Grade {
    private Integer gradeId;

    private String gradeDep;

    private Double gradeGrade;

    private Date gradeMonth;

    private String gradeRemark;
    
    

    public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(Integer gradeId, String gradeDep, Double gradeGrade, Date gradeMonth, String gradeRemark) {
		super();
		this.gradeId = gradeId;
		this.gradeDep = gradeDep;
		this.gradeGrade = gradeGrade;
		this.gradeMonth = gradeMonth;
		this.gradeRemark = gradeRemark;
	}

	public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeDep() {
        return gradeDep;
    }

    public void setGradeDep(String gradeDep) {
        this.gradeDep = gradeDep == null ? null : gradeDep.trim();
    }

    public Double getGradeGrade() {
        return gradeGrade;
    }

    public void setGradeGrade(Double gradeGrade) {
        this.gradeGrade = gradeGrade;
    }

    public Date getGradeMonth() {
        return gradeMonth;
    }

    public void setGradeMonth(Date gradeMonth) {
        this.gradeMonth = gradeMonth;
    }

    public String getGradeRemark() {
        return gradeRemark;
    }

    public void setGradeRemark(String gradeRemark) {
        this.gradeRemark = gradeRemark == null ? null : gradeRemark.trim();
    }
}