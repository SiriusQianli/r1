package com.init.crud.service;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.crud.bean.Item;
import com.init.crud.dao.ItemMapper;

@Service
public class ItemService {
@Autowired
ItemMapper itemMapper;

	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemMapper.selectByExample(null);
	}

	public void addItem(String item) {
		try {
			item=URLDecoder.decode(item,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] strings=item.split("&");
		String itemName=strings[0].split("=")[1];
		String empName=strings[1].split("=")[1];
		Item item2=new Item(null, itemName, empName, 1);
		itemMapper.insert(item2);
	}

	public void deleteItem(int item) {
		itemMapper.deleteByPrimaryKey(item);
	}

	public void updateItem(String item, int itemId) {
		try {
			item=URLDecoder.decode(item,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] strings=item.split("&");
		String itemName=strings[0].split("=")[1];
		String empName=strings[1].split("=")[1];
		Item item2=getItemById(itemId);
		item2.setItemEmp(empName);
		item2.setItemName(itemName);
		itemMapper.updateByPrimaryKey(item2);
		
	}

	public Item getItemById(int itemId) {
		
		return itemMapper.selectByPrimaryKey(itemId);
	}

}
