package com.init.crud.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.crud.bean.Department;
import com.init.crud.bean.DepartmentExample;
import com.init.crud.bean.DepartmentExample.Criteria;
import com.init.crud.bean.Grade;
import com.init.crud.bean.GradeExample;
import com.init.crud.bean.Item;
import com.init.crud.bean.ItemExample;
import com.init.crud.bean.Mark;
import com.init.crud.bean.MarkExample;
import com.init.crud.bean.Msg;
import com.init.crud.bean.Record;
import com.init.crud.bean.RecordForMark;
import com.init.crud.dao.DepartmentMapper;
import com.init.crud.dao.GradeMapper;
import com.init.crud.dao.ItemMapper;
import com.init.crud.dao.MarkMapper;
import com.init.crud.dao.RecordForMarkMapper;
import com.init.crud.dao.RecordMapper;

@Service
public class MarkService {
	@Autowired
	MarkMapper markMapper;
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	RecordMapper recordMapper;
	@Autowired
	RecordForMarkMapper recordForMarkMapper;
	@Autowired
	GradeMapper gradeMapper;
	@Autowired
	ItemMapper itemMapper;
	
	public List<Mark> getAll(){
		//System.out.println("getAllMarks");
		return markMapper.selectByExample(null);
	}
	public List<Department> getAllDeps(){
		//System.out.println("getAllDeps");
		return departmentMapper.selectByExample(null);
	}
	
	 
	public void addRecords(String recs,String dep,String name){
		String[] strings =recs.split("&");
		String score="0";
		
		for (String string : strings) {
			String[] ss=string.split("=");
			int i=Integer.valueOf(ss[0]);
			if(ss.length!=1) score=ss[1];
			//获取当前年月
			Calendar now = Calendar.getInstance();  
			Date date=new Date();
			SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd");
			int year=now.get(Calendar.YEAR);
			int month=now.get(Calendar.MONTH)+1;
			String sss="";
			if(month<10)
				sss=year+"-0"+month+"-01";
			else
				sss=year+"-"+month+"-01";
			//获取当前年月
			try {
				date=aDate.parse(sss);
			} catch (ParseException e) {
				
				continue;
			}
			recordMapper.insert(new Record(null, i, dep, date, score, name));
		}
	}
	public void dealRecords(String dep,String name){
		List<Record> list = recordMapper.selectByExample(null);
		Record record=list.get(0);
		//向recordForMark表中添加纪录
		recordForMarkMapper.insert(new RecordForMark(null, name, record.getRecDate(), dep));
		//清算成绩加入grade表中
		gradeMapper.insert(new Grade(null, dep, 100.0, record.getRecDate(),""));
		for (Record r : list) {
			//找到要更新的记录grade
			GradeExample gExample=new GradeExample();
			com.init.crud.bean.GradeExample.Criteria criteria=gExample.createCriteria();
			criteria.andGradeDepEqualTo(dep);
			criteria.andGradeMonthEqualTo(record.getRecDate());
			Grade grade=gradeMapper.selectByExample(gExample).get(0);
			//找到该项的总分
			Mark mark=markMapper.selectByPrimaryKey(r.getRecItemId());
			//更新记录
			double d=mark.getMarkScore()-Double.parseDouble(r.getRecRemark());
			grade.setGradeGrade(grade.getGradeGrade()-d);
			if(d>0){
			grade.setGradeRemark(grade.getGradeRemark()+r.getRecItemId()+"_"+String.format("%.1f", d)+";");
			gradeMapper.updateByExampleSelective(grade, gExample);}
		}
		
	}
	
	public void cleanRecords(){
		recordMapper.deleteByExample(null);
	}
	public Mark getMark(Integer id) {
		// TODO Auto-generated method stub
		return markMapper.selectByPrimaryKey(id);
	}
	public void deleteId(int id) {
		markMapper.deleteByPrimaryKey(id);
	}
	public void addMark(String mark) {
		try {
			mark = URLDecoder.decode(mark, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String[] strings =mark.split("&");
		String item=strings[0].split("=")[1];
		String genre=strings[1].split("=")[1];
		String content=strings[2].split("=")[1];
		String score=strings[3].split("=")[1];
		String method=strings[4].split("=")[1];
			markMapper.insert(new Mark(null, item, genre, content, Double.valueOf(score), method));
	}
	public void updateMark(String mark,Integer id) {
		try {
			mark = URLDecoder.decode(mark, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String[] strings =mark.split("&");
		String item=strings[0].split("=")[1];
		String genre=strings[1].split("=")[1];
		String content=strings[2].split("=")[1];
		String score=strings[3].split("=")[1];
		String method=strings[4].split("=")[1];
		markMapper.updateByPrimaryKeySelective(new Mark(id, item, genre, content, Double.valueOf(score), method));
	}
	public List<Mark> getMarksByName(String name) {
		List<Mark> marks=new ArrayList<Mark>();
		//找到name负责的item
		ItemExample iExample=new ItemExample();
		com.init.crud.bean.ItemExample.Criteria criteria=iExample.createCriteria();
		criteria.andItemEmpEqualTo(name);
		List<Item> items=itemMapper.selectByExample(iExample);
		for (Item item : items) {
			MarkExample mExample=new MarkExample();
			com.init.crud.bean.MarkExample.Criteria criteria2=mExample.createCriteria();
			criteria2.andMarkItemEqualTo(item.getItemName());
			marks.addAll(markMapper.selectByExample(mExample));
		}
		return marks;
	}
}
