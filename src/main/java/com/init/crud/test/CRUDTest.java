package com.init.crud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.init.crud.dao.DepartmentMapper;
import com.init.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CRUDTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Test
	public void testCRUD() {
		System.out.println(departmentMapper);
		//插入		
//		departmentMapper.insertSelective(new Department(null,"dep1",0.0,0.0));
//		departmentMapper.insertSelective(new Department(null,"dep2",0.0,0.0));
//		departmentMapper.insertSelective(new Department(null,"dep3",0.0,0.0));
		System.out.println(employeeMapper);
//		employeeMapper.insertSelective(new Employee(null, "张三",new Byte("03"), "dep1"));
//		employeeMapper.insertSelective(new Employee(null, "里斯",new Byte("03"), "dep1"));
//		employeeMapper.insertSelective(new Employee(null, "王屋",new Byte("02"), "dep2"));
//		employeeMapper.insertSelective(new Employee(null, "赵六",new Byte("03"), "dep3"));
//		employeeMapper.insertSelective(new Employee(null, "山本五十六",new Byte("03"), "dep4"));
	}
}
