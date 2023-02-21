package com.ourcom.app3.domain;

import java.util.Date;

public class Article {
	private String articleNo;
	private String title;
	private String content;
	private Date writeDate;
	private String writerid;
	
	
	public Article() {
		super();
	}

	public Article(String articleNo, String title, String content, Date writeDate, String writerid) {
		super();
		this.articleNo = articleNo;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.writerid = writerid;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getWriterid() {
		return writerid;
	}

	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}

	@Override
	public String toString() {
		return "Article [articleNo=" + articleNo + ", title=" + title + ", content=" + content + ", writeDate="
				+ writeDate + ", writerid=" + writerid + "]";
	}
	
	
	
	
}
