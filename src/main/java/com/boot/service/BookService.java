package com.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.dao.BookRepository;
import com.boot.entities.Book;

@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;

//	private static List<Book> list = new ArrayList<>();
//
//	static {
//
//		list.add(new Book(102, "hows going on", "abc"));
//		list.add(new Book(104, "testing", "mno"));
//		list.add(new Book(134, "devloping", "pqr"));
//
//	}

	// get all book get method

	public List<Book> getAllBook() {

		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;

	}

	// getsingle book get methood

	public Book getBookById(int id) {
		Book book = null;
		try {
			//book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		book=this.bookRepository.findById(id);
		
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return book;
	}

	// adding book post method
	public Book addBook(Book b) {

//		list.add(b);
//		return b;
		
		Book book=bookRepository.save(b);
		return book;
	}

	// delete book delete method

	public void deleteBook(int id) {

	//	list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	
	}

	// update book put method

	public void updateBook(Book book, int id) {

//		list.stream().map(b -> {
//			if (b.getId() == book.getId()) {
//
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		
		
		book.setId(id);
		bookRepository.save(book);

	}

}
