package com.library.management.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
  /*   private final BookService bookService;

    public BookController(BoookService bookService){
        this.bookService = bookService;
    }

    //DELETE
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "Book Deleted Successfully!!";
    }

    */

}
