package com.init.crud.bean;

public class Item {
    private Integer itemId;

    private String itemName;

    private String itemEmp;

    private Integer itemGot;
    
    

    public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Integer itemId, String itemName, String itemEmp, Integer itemGot) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemEmp = itemEmp;
		this.itemGot = itemGot;
	}

	public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemEmp() {
        return itemEmp;
    }

    public void setItemEmp(String itemEmp) {
        this.itemEmp = itemEmp == null ? null : itemEmp.trim();
    }

    public Integer getItemGot() {
        return itemGot;
    }

    public void setItemGot(Integer itemGot) {
        this.itemGot = itemGot;
    }
}