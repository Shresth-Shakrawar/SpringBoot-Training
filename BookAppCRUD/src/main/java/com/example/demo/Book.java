package com.example.demo;

public class Book {
	private int id;
	private String bName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBName() {
		return bName;
	}
	public void setBName(String bName) {
		this.bName = bName;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bName=" + bName + "]";
	}
	public Book(int id, String bName) {
		super();
		this.id = id;
		this.bName = bName;
	}
	
}
