package com.init.crud.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.init.crud.bean.Department;
import com.init.crud.bean.Employee;
import com.init.crud.bean.Mark;
import com.init.crud.bean.Msg;
import com.init.crud.service.DepartmentService;
import com.init.crud.service.MarkService;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	//获取部门列表并按分数降序排列
	@RequestMapping("/countMarks")
	@ResponseBody
	public Msg countMarks(@RequestParam(value ="year")String year,@RequestParam(value ="month")String month){
		List<Department> department;
		try {
			department = departmentService.countMarks(year,month);
		} catch (ParseException e) {
			return Msg.fail();
		}
		return Msg.success().add("deplist", department);
	}
	//获取部门列表
	@RequestMapping("/getDeps")
	@ResponseBody
	public Msg getDeps(){
		List<Department> list=departmentService.getAllDeps();
		//System.out.println("getDeps");
		return Msg.success().add("deps", list);
	}
	@RequestMapping("/getDeps1")
	@ResponseBody
	public Msg Deps(@RequestParam(value ="pn")String pn) {
		System.out.println("markss"+pn);
		int i=Integer.valueOf(pn);
		PageHelper.startPage(i, 5);
		List<Department> deps= departmentService.getAllDeps();
		PageInfo page = new PageInfo(deps, 5);
		return Msg.success().add("pageInfo", page);
	}
	//转至评分页面
	@RequestMapping("/gotoMarks")
	public String gotoMark(){
		return "marks";
	}
	
	@ResponseBody
	@RequestMapping("/addDep")
	public Msg addEmp(@RequestParam(value="dep")String dep){
		departmentService.addDep(dep);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping("/deleteDep")
	public Msg deleteEmp(@RequestParam(value="depId")String depId){
		int dep=Integer.valueOf(depId);
		departmentService.deleteDep(dep);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping("/updateDep")
	public Msg updateDep(@RequestParam(value="dep")String dep,@RequestParam(value="id")String id){
		departmentService.updateDep(dep,id);
		return Msg.success();
	}
	@ResponseBody
	@RequestMapping("/getDep")
	public Msg getDep(@RequestParam(value="id")String id){
		Department department=departmentService.getDep1(id);
		return Msg.success().add("dep", department);
	}
	 @RequestMapping(value = "/pullOutDeps")  
	    public void exportExcel(HttpServletRequest request, HttpServletResponse response)   
	    throws Exception {  
	        
	   }  
}
