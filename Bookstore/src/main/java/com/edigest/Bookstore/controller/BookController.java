package com.edigest.Bookstore.controller;

import com.edigest.Bookstore.DTO.DTO;
import com.edigest.Bookstore.entity.Book;
import com.edigest.Bookstore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController  {

    @GetMapping("")
    public String home() {
        return "Welcome to the Bookstore API";
    }

    @Autowired
    private BookService bookService;


    /*@PostConstruct
    public void init() {
        Book book1 = new Book(1L, "Wings of Fire", "APJ Abdul Kalam", "Biography", 299);
        Book book2 = new Book(2L, "Harry Potter", "J.K. Rowling", "Fantasy", 499);
        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
    }*/
    @GetMapping("/Browse-Collection")
    public List<Book> getALLBooks(){
      return bookService.getAllBooks();

    }
    @PostMapping("/Sell-Upload")
    public ResponseEntity<String> uploadBook(@RequestBody DTO dto){
        Book savedBook = bookService.addBookFromDTO(dto);
        return ResponseEntity.ok("Book uploaded: " + savedBook.getBookName());
    }


    @GetMapping("/books/genre/{genre}")
    public List<Book> browse(@PathVariable String genre){
        return bookService.searchForType(genre);

    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getById(@PathVariable String id){
        Book book = bookService.getByBookId(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            System.out.println("Not Found");
            return ResponseEntity.notFound().build();//Not Found // or throw an exception / return a 404 message
        }

    }



}
