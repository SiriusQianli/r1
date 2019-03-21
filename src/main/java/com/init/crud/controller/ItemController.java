package com.init.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.init.crud.bean.Department;
import com.init.crud.bean.Employee;
import com.init.crud.bean.Item;
import com.init.crud.bean.Msg;
import com.init.crud.service.EmployeeService;
import com.init.crud.service.ItemService;

@Controller
public class ItemController {
@Autowired
ItemService itemService;
@Autowired
EmployeeService employeeService;

@RequestMapping("/getItems")
@ResponseBody
public Msg getItems(@RequestParam(value ="pn")String pn) {
	System.out.println("markss"+pn);
	int i=Integer.valueOf(pn);
	PageHelper.startPage(i, 5);
	List<Item> deps= itemService.getAllItems();
	PageInfo page = new PageInfo(deps, 5);
	List<Employee> employees=employeeService.getAll();
	return Msg.success().add("pageInfo", page).add("emps", employees);
}
@RequestMapping("/getItemss")
@ResponseBody
public Msg getItemss() {
	List<Item> items= itemService.getAllItems();

	return Msg.success().add("items", items);
}
@ResponseBody
@RequestMapping("/addItem")
public Msg addEmp(@RequestParam(value="item")String item){
	itemService.addItem(item);
	return Msg.success();
}
@ResponseBody
@RequestMapping("/deleteItem")
public Msg deleteEmp(@RequestParam(value="itemId")String itemId){
	int item=Integer.valueOf(itemId);
	itemService.deleteItem(item);
	return Msg.success();
}
@ResponseBody
@RequestMapping("/updateItem")
public Msg updateDep(@RequestParam(value="item")String item,@RequestParam(value="id")String id){
	int itemId=Integer.valueOf(id);
	itemService.updateItem(item,itemId);
	return Msg.success();
}
@ResponseBody
@RequestMapping("/getItem")
public Msg getDep(@RequestParam(value="id")String id){
	int itemId=Integer.valueOf(id);
Item item=itemService.getItemById(itemId);
	return Msg.success().add("item", item);
}
}
