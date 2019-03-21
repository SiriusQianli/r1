package com.init.crud.bean;

import java.util.Date;

public class RecordForMark {
    private Integer rfmId;

    private String rfmEmpName;

    private Date rfmMonth;

    private String rfmDepName;
    
    

    public RecordForMark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordForMark(Integer rfmId, String rfmEmpName, Date rfmMonth, String rfmDepName) {
		super();
		this.rfmId = rfmId;
		this.rfmEmpName = rfmEmpName;
		this.rfmMonth = rfmMonth;
		this.rfmDepName = rfmDepName;
	}

	public Integer getRfmId() {
        return rfmId;
    }

    public void setRfmId(Integer rfmId) {
        this.rfmId = rfmId;
    }

    public String getRfmEmpName() {
        return rfmEmpName;
    }

    public void setRfmEmpName(String rfmEmpName) {
        this.rfmEmpName = rfmEmpName == null ? null : rfmEmpName.trim();
    }

    public Date getRfmMonth() {
        return rfmMonth;
    }

    public void setRfmMonth(Date rfmMonth) {
        this.rfmMonth = rfmMonth;
    }

    public String getRfmDepName() {
        return rfmDepName;
    }

    public void setRfmDepName(String rfmDepName) {
        this.rfmDepName = rfmDepName == null ? null : rfmDepName.trim();
    }
}