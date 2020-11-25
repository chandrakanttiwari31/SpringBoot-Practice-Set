package com.boot.controller;

import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entities.Book;
import com.boot.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bs;

	
	//get all book
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBook() {

		List<Book> list=bs.getAllBook();
		if(list.size()<=0)
		{
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);

	}
	
	//single book 
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getboook(@PathVariable("id") int id)
	{
		Book book=bs.getBookById(id);
		if(book==null)
		{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b)
	{
		Book bb=null;
		try {
			bb= this.bs.addBook(b);
			return ResponseEntity.of(Optional.of(bb));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	//delete book
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
	{
		try {
			this.bs.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}

	
	
	//update book
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook( @RequestBody Book book,@PathVariable("id") int id)
	{
		
		
		
		try {
			this.bs.updateBook(book,id);
			return ResponseEntity.ok().body(book);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
}
