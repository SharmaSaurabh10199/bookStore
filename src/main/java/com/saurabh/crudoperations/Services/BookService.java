package com.saurabh.crudoperations.Services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.saurabh.crudoperations.Model.BookModel;
import com.saurabh.crudoperations.Repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepo;

    public void insert(BookModel book) throws SQLException {
        bookRepo.insert(book);

    }

    public List<BookModel> getBooks() throws SQLException {
        return bookRepo.getBooks();
    }

    public BookModel getBookById(int id) throws SQLException {
        return bookRepo.getBookById(id);
    }

    public BookModel updateBook(BookModel book) throws SQLException {
        return bookRepo.updateBook(book);
    }

    public BookModel deleteBook(int id) throws SQLException {
        return bookRepo.deleteBook(id);
    }

}
