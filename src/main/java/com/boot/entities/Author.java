package com.boot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int aid;
private String name;
private String language;

@OneToOne(mappedBy = "author")
@JsonBackReference
private Book book;

public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public Author() {
	super();
	// TODO Auto-generated constructor stub
}
public Author(int aid, String name, String language) {
	super();
	this.aid = aid;
	this.name = name;
	this.language = language;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
@Override
public String toString() {
	return "Author [aid=" + aid + ", name=" + name + ", language=" + language + "]";
}



}
