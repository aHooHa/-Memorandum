package com.newer.memo.dao;

import java.sql.Date;

public class Memo {
	
	private int id;
	private String name;
	private String type;
	private String context;
	private String theame;
	private Date time;
	
	
	public Memo() {
		super();
	}


	public Memo(String name, String type, String context, String theame, Date time) {
		super();
		this.name = name;
		this.type = type;
		this.context = context;
		this.theame = theame;
		this.time = time;
	}


	public Memo(int id, String name, String type, String context, String theame, Date time) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.context = context;
		this.theame = theame;
		this.time = time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public String getTheame() {
		return theame;
	}


	public void setTheame(String theame) {
		this.theame = theame;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Memo [id=" + id + ", name=" + name + ", type=" + type + ", context=" + context + ", theame=" + theame
				+ ", time=" + time + "]";
	}
	
	
	

}
