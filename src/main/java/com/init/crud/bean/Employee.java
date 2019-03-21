package com.init.crud.bean;

public class Employee {
    private Integer empId;

    private Integer empPosition;

    private String empName;

    private String empDepartment;

    private String empPassword;
    
    

    public Employee(Integer empId, Integer empPosition, String empName, String empDepartment, String empPassword) {
		super();
		this.empId = empId;
		this.empPosition = empPosition;
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.empPassword = empPassword;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(Integer empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment == null ? null : empDepartment.trim();
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword == null ? null : empPassword.trim();
    }
}