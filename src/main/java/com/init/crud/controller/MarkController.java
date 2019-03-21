package com.init.crud.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.init.crud.bean.Department;
import com.init.crud.bean.Item;
import com.init.crud.bean.Mark;
import com.init.crud.bean.Msg;
import com.init.crud.service.ItemService;
import com.init.crud.service.MarkService;
import com.init.crud.service.RecordForMarkService;

@Controller
public class MarkController {
	@Autowired
	MarkService markService;
	@Autowired
	RecordForMarkService recordForMarkService;
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/mark")
	@ResponseBody
	public Msg getMarks(@RequestParam(value="name")String name){
		List<Mark> marks= markService.getMarksByName(name);
		List<Department> deps= markService.getAllDeps();
		return Msg.success().add("marks", marks).add("deps", deps);
	}
	@ResponseBody
	@RequestMapping("/addRecord")
	public Msg addRecord(@RequestParam(value="recs")String recs,@RequestParam(value="dep")String dep,@RequestParam(value="name")String name){
		//获取当前年月
		Calendar now = Calendar.getInstance();  
		Date date=new Date();
		SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd");
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		String string="";
		if(month<10)
			string=year+"-0"+month+"-01";
		else
			string=year+"-"+month+"-01";
		//获取当前年月
		try {
			date=aDate.parse(string);
		} catch (ParseException e) {
			return Msg.fail();
		}
		if(recordForMarkService.isMarked(name,dep,date)){
			return Msg.success().add("msg", "该部门已评分");
		}
		
		markService.addRecords(recs, dep,name);
		markService.dealRecords(dep,name);
		markService.cleanRecords();
		return Msg.success().add("msg", "评分成功");
	}
	@ResponseBody
	@RequestMapping("/markss")
	public Msg markss(@RequestParam(value ="pn")String pn) {
		//System.out.println("markss"+pn);
		int i=Integer.valueOf(pn);
		PageHelper.startPage(i, 5);
		List<Mark> marks= markService.getAll();
		PageInfo page = new PageInfo(marks, 5);
		List<Item> items=itemService.getAllItems();
		return Msg.success().add("pageInfo", page).add("items", items);
	}
	@RequestMapping(value="/mark/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getMark(@PathVariable("id")Integer id){
		Mark mark=markService.getMark(id);
		return Msg.success().add("mark", mark);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateMark")
	public Msg saveMark(@RequestParam(value ="mark")String mark,@RequestParam(value ="id")Integer id){
		//System.out.println(mark+id);
		markService.updateMark(mark,id);
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="/mark/{ids}",method=RequestMethod.DELETE)
	public Msg deleteMark(@PathVariable("ids")String id){		
			Integer i = Integer.valueOf(id);
			markService.deleteId(i);
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping("/addMark")
	public Msg addMark(@RequestParam("mark")String mark){		
			markService.addMark(mark);
		return Msg.success();
	}
	
}
