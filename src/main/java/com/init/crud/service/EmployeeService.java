package com.init.crud.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.crud.bean.Employee;
import com.init.crud.bean.EmployeeExample;
import com.init.crud.bean.EmployeeExample.Criteria;
import com.init.crud.dao.EmployeeMapper;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	 String[] excelHeader = { "工号", "姓名", "所在部门","密码"};
	public List<Employee> getAll() {
		return employeeMapper.selectByExample(null);
	}

	public void addEmp(String emp) {
		try {
			emp = URLDecoder.decode(emp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String[] strings =emp.split("&");
		String password="000000";
		String name=strings[0].split("=")[1];
		int position=Integer.valueOf(strings[2].split("=")[1]);
		String dName=strings[1].split("=")[1];
		Employee employee=new Employee(null,position,name,dName,password);
		employeeMapper.insert(employee);
	}

	public void deleteEmp(int emp) {
		employeeMapper.deleteByPrimaryKey(emp);
	}

	public void updateEmp(String emp ,String id) {
		try {
			emp = URLDecoder.decode(emp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int i=Integer.valueOf(id);
		String[] strings =emp.split("&");
		String password="000000";
		String dName=strings[0].split("=")[1];
		int position=Integer.valueOf(strings[1].split("=")[1]);
		Employee employee=new Employee(i,position,null,dName,password);
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	public Employee getEmp(String id) {
		int i=Integer.valueOf(id);
		return employeeMapper.selectByPrimaryKey(i);
	}

	public Employee login(String name, String password) {
		EmployeeExample employeeExample=new EmployeeExample();
		Criteria criteria=employeeExample.createCriteria();
		criteria.andEmpNameEqualTo(name);
		Employee employee=employeeMapper.selectByExample(employeeExample).get(0);
		if(password.equals(employee.getEmpPassword())){
			return employee;
		}
		return null;
	}

	public HSSFWorkbook export(List<Employee> list) {
		HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet("Campaign");  
        HSSFRow row = sheet.createRow((int) 0);  
        HSSFCellStyle style = wb.createCellStyle();  
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(excelHeader[i]);  
            cell.setCellStyle(style);  
            sheet.autoSizeColumn(i);  
        }  
  
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow(i + 1);  
            Employee emp = list.get(i);  
            row.createCell(0).setCellValue(emp.getEmpId());  
            row.createCell(1).setCellValue(emp.getEmpName());  
            row.createCell(2).setCellValue(emp.getEmpDepartment());  
            row.createCell(3).setCellValue(emp.getEmpPassword());  
        }  
        return wb;  

	}
	

	

	

}
