package com.ssafy.news;

public class News {
	private String title; // 기사 헤드라인
	private String desc; // 내용
	private String link; // 링크
	
	public News() {
		
	}
	
	public News(String title, String desc, String link) {
		this.title = title;
		this.desc = desc;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return  title;
	}
	
	
	
}
