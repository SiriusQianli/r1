package com.init.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.init.crud.bean.Employee;
import com.init.crud.bean.Msg;
import com.init.crud.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		PageHelper.startPage(pn, 5);
		List<Employee> emps= employeeService.getAll();
		PageInfo pageInfo=new PageInfo(emps,5);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}
	@ResponseBody
	@RequestMapping("/getAllEmps")
	public Msg getAllEmps(){
		List<Employee> emps= employeeService.getAll();
		return Msg.success().add("emps", emps);
	}
	@ResponseBody
	@RequestMapping("/addEmp")
	public Msg addEmp(@RequestParam(value="emp")String emp){
		employeeService.addEmp(emp);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping("/deleteEmp")
	public Msg deleteEmp(@RequestParam(value="empId")String empId){
		int emp=Integer.valueOf(empId);
		employeeService.deleteEmp(emp);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping("/updateEmp")
	public Msg updateEmp(@RequestParam(value="emp")String emp,@RequestParam(value="id")String id){
		employeeService.updateEmp(emp,id);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping("/getEmp")
	public Msg getEmp(@RequestParam(value="id")String id){
		Employee employee=employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	@ResponseBody
	@RequestMapping("/login")
	public Msg login(@RequestParam(value="name")String name,@RequestParam(value="password")String password){
		Employee employee=employeeService.login(name,password);
		if(employee!=null)
		return Msg.success().add("emp", employee);
		else
			return Msg.fail();
	}
}
