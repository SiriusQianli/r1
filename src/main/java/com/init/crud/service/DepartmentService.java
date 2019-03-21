package com.init.crud.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.crud.bean.Department;
import com.init.crud.bean.DepartmentExample;
import com.init.crud.bean.Employee;
import com.init.crud.bean.Grade;
import com.init.crud.bean.GradeExample;
import com.init.crud.bean.Mark;
import com.init.crud.bean.DepartmentExample.Criteria;
import com.init.crud.bean.Record;
import com.init.crud.dao.DepartmentMapper;
import com.init.crud.dao.GradeMapper;
import com.init.crud.dao.MarkMapper;
import com.init.crud.dao.RecordMapper;

@Service
public class DepartmentService {
	@Autowired
	DepartmentMapper dMapper;
	@Autowired
	RecordMapper rMapper;
	@Autowired
	GradeMapper gMapper;
	@Autowired
	MarkMapper mMapper;

	public Department getDep(String name) {
		DepartmentExample dExample = new DepartmentExample();
		DepartmentExample.Criteria criteria = dExample.createCriteria();
		criteria.andDepNameEqualTo(name);
		// System.out.println("getDepSSSSS");
		return dMapper.selectByExample(dExample).get(0);
	}
	public List<Department> getAllDeps(){
		return dMapper.selectByExample(null);
	}
	public List<Department> getDeps() {
		DepartmentExample dExample=new DepartmentExample();
		dExample.setOrderByClause("dep_score DESC");
		return dMapper.selectByExample(dExample);
	}
	public List<Department> countMarks(String year, String month) throws ParseException {
		//获取全部部门
		List<Department> list1=dMapper.selectByExample(null);
		//初始化成绩
		for (Department department : list1) {
			DepartmentExample dExample=new DepartmentExample();
			Criteria criteria2=dExample.createCriteria();
			criteria2.andDepNameEqualTo(department.getDepName());
			department.setDepScore(100.0);
			department.setDepRemark("");
			dMapper.updateByExampleSelective(department, dExample);
		}
		//获取grade表中月份符合的降序排列
		GradeExample gradeExample=new GradeExample();
		com.init.crud.bean.GradeExample.Criteria criteria=gradeExample.createCriteria();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		criteria.andGradeMonthEqualTo(df.parse(year+"-"+month+"-"+"01"));
		//gradeExample.setOrderByClause("grade_grade DESC");
		List<Grade> list2=gMapper.selectByExample(gradeExample);
		//没有符合条件则直接返回所有部门列表
		if(list2.isEmpty()) return list1;
		//把grade填充到一个department的列表里
		List<Department> list3=new ArrayList<Department>();
		for (Grade g : list2) {
			Department department=new Department();
			department.setDepName(g.getGradeDep());
			department.setDepScore(g.getGradeGrade());
			String remark="";
			//处理备注
			if(g.getGradeRemark()!=null){
			String[] str1=g.getGradeRemark().split(";");
			for (String string : str1) {
				String[] strings=string.split("_");
				Mark mark=mMapper.selectByPrimaryKey(Integer.valueOf(strings[0]));
				remark=remark+mark.getMarkGenre()+"-"+mark.getMarkContent().substring(0, 20)+":"+strings[1]+"|";
			}
			}
			//
			department.setDepRemark(remark);
			list3.add(department);
		}
		//覆盖原本department表中的值
		for (Department department : list3) {
			DepartmentExample dExample=new DepartmentExample();
			Criteria criteria2=dExample.createCriteria();
			criteria2.andDepNameEqualTo(department.getDepName());
			dMapper.updateByExampleSelective(department, dExample);
		}
		DepartmentExample departmentExample=new DepartmentExample();
		departmentExample.setOrderByClause("dep_score DESC");
		list1=dMapper.selectByExample(departmentExample);
		return list1;
	}
	
	public void addDep(String dep) {
		try {
			dep = URLDecoder.decode(dep, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		String[] strings =dep.split("&");
		String name=strings[0].split("=")[1];
		Department department=new Department();
		department.setDepName(name);
		dMapper.insertSelective(department);
		//dMapper.insert(department);
	}

	public void deleteDep(int dep) {
		dMapper.deleteByPrimaryKey(dep);
	}

	public void updateDep(String dep ,String id) {
		try {
			dep = URLDecoder.decode(dep, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int i=Integer.valueOf(id);
		String[] strings =dep.split("&");
		String dName=strings[0].split("=")[1];
		Department department=new Department(i,dName,null,null,null,null);
		dMapper.updateByPrimaryKeySelective(department);
	}

	public Department getDep1(String id) {
		int i=Integer.valueOf(id);
		return dMapper.selectByPrimaryKey(i);
	}


}
