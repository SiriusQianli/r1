package com.init.crud.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.crud.bean.DepartmentExample.Criteria;
import com.init.crud.bean.RecordForMark;
import com.init.crud.bean.RecordForMarkExample;
import com.init.crud.dao.RecordForMarkMapper;
@Service
public class RecordForMarkService {
	@Autowired
	RecordForMarkMapper recordForMarkMapper;
	
	public boolean isMarked(String name, String dep, Date date) {
		RecordForMarkExample rForMarkExample=new RecordForMarkExample();
		com.init.crud.bean.RecordForMarkExample.Criteria criteria=rForMarkExample.createCriteria();
		criteria.andRfmDepNameEqualTo(dep);
		criteria.andRfmEmpNameEqualTo(name);
		criteria.andRfmMonthEqualTo(date);
		long count=recordForMarkMapper.countByExample(rForMarkExample);
		if(count==0)
		return false;
		else
			return true;
	}

}
