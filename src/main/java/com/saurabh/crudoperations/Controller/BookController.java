package com.saurabh.crudoperations.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.crudoperations.BookRequests.BookCreateRequests;
import com.saurabh.crudoperations.BookRequests.BookUpdateRequest;
import com.saurabh.crudoperations.Model.BookModel;
import com.saurabh.crudoperations.Services.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("get/books")
    public String getBooks() {
        return "books";
    }

    @PostMapping("/add/book")
    public void insert(@Valid @RequestBody BookCreateRequests bookRequests) throws SQLException {
        BookModel book = new BookModel();
        book.setAuthorName(bookRequests.getAuthorName());
        book.setCost(bookRequests.getCost());
        book.setName(bookRequests.getName());

        bookService.insert(book);

    }

    @GetMapping("/get/book/{id}")
    public BookModel getBook(@PathVariable int id) throws SQLException {

        return bookService.getBookById(id);
    }

    @GetMapping("/get/all/book")
    public List<BookModel> getAllBooks() throws SQLException {

        return bookService.getBooks();
    }

    @PutMapping("/update/book")
    public BookModel updateBook(@RequestBody BookUpdateRequest bookUpdateRequest) throws SQLException {
        BookModel book = new BookModel(bookUpdateRequest.getId(), bookUpdateRequest.getName(),
                bookUpdateRequest.getAuthorName(), bookUpdateRequest.getCost());
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/book/{id}")
    public BookModel deleteBook(@PathVariable int id) throws SQLException {
        return bookService.deleteBook(id);
    }

}
