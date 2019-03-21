package com.init.crud.bean;

public class Department {
    private Integer depId;

    private String depName;

    private Double depScore;

    private Integer depRank;

    private String depRemark;

    private Integer depNumber;
    
    

    public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer depId, String depName, Double depScore, Integer depRank, String depRemark,
			Integer depNumber) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depScore = depScore;
		this.depRank = depRank;
		this.depRemark = depRemark;
		this.depNumber = depNumber;
	}

	public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public Double getDepScore() {
        return depScore;
    }

    public void setDepScore(Double depScore) {
        this.depScore = depScore;
    }

    public Integer getDepRank() {
        return depRank;
    }

    public void setDepRank(Integer depRank) {
        this.depRank = depRank;
    }

    public String getDepRemark() {
        return depRemark;
    }

    public void setDepRemark(String depRemark) {
        this.depRemark = depRemark == null ? null : depRemark.trim();
    }

    public Integer getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(Integer depNumber) {
        this.depNumber = depNumber;
    }
}