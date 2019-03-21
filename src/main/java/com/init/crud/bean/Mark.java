package com.init.crud.bean;

public class Mark {
    private Integer markId;

    private String markItem;

    private String markGenre;

    private String markContent;

    private Double markScore;

    private String markMethod;
    
    

    public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mark(Integer markId, String markItem, String markGenre, String markContent, Double markScore,
			String markMethod) {
		super();
		this.markId = markId;
		this.markItem = markItem;
		this.markGenre = markGenre;
		this.markContent = markContent;
		this.markScore = markScore;
		this.markMethod = markMethod;
	}

	public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public String getMarkItem() {
        return markItem;
    }

    public void setMarkItem(String markItem) {
        this.markItem = markItem == null ? null : markItem.trim();
    }

    public String getMarkGenre() {
        return markGenre;
    }

    public void setMarkGenre(String markGenre) {
        this.markGenre = markGenre == null ? null : markGenre.trim();
    }

    public String getMarkContent() {
        return markContent;
    }

    public void setMarkContent(String markContent) {
        this.markContent = markContent == null ? null : markContent.trim();
    }

    public Double getMarkScore() {
        return markScore;
    }

    public void setMarkScore(Double markScore) {
        this.markScore = markScore;
    }

    public String getMarkMethod() {
        return markMethod;
    }

    public void setMarkMethod(String markMethod) {
        this.markMethod = markMethod == null ? null : markMethod.trim();
    }
}