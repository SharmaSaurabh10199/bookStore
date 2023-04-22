package com.saurabh.crudoperations.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.saurabh.crudoperations.Model.BookModel;

@Repository
public class BookRepository {

    private static Connection connection;
    private static Logger logger = LoggerFactory.getLogger(BookRepository.class);

    BookRepository() throws SQLException {
        // create the connection
        logger.info("inside the constructer");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
        createTable();
    }

    private void createTable() throws SQLException {
        String sql = "create table if not exists book  (id int primary key auto_increment, name varchar(20), authorName varchar(20), cost int )";
        Statement stmnt = connection.createStatement();

        int result = stmnt.executeUpdate(sql);

        logger.info("result of create table query is" + result);

    }

    public void insert(BookModel book) throws SQLException {
        // create the jdbc connection and insert the book
        logger.info("inside the insert method: Bookrepo");
        // dynamic query
        String sql = "insert into book(name, cost, authorName) values(?,?,?)";
        // prepared statment is used
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, book.getName());
        statement.setInt(2, book.getCost());
        statement.setString(3, book.getAuthorName());

        int result = statement.executeUpdate();

        logger.info("the result of insert is :" + result);

    }

    public BookModel getBookById(int bookId) throws SQLException {
        String sql = "select * from book where id=" + bookId;
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int cost = resultSet.getInt("cost");
            String authorName = resultSet.getString("authorName");
            BookModel book = new BookModel(id, name, authorName, cost);

            return book;
        }

        return null;
    }

    public List<BookModel> getBooks() throws SQLException {
        String sql = "select * from book";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<BookModel> bookList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int cost = resultSet.getInt("cost");
            String authorName = resultSet.getString("authorName");
            BookModel book = new BookModel(id, name, authorName, cost);

            bookList.add(book);
        }

        return bookList;
    }

    public BookModel updateBook(BookModel book) throws SQLException {
        String sql = "update book set cost=?, name=?, authorName=?" + "where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(2, book.getName());
        statement.setInt(1, book.getCost());
        statement.setString(3, book.getAuthorName());
        statement.setInt(4, book.getId());

        int result = statement.executeUpdate();

        logger.info("the result of update is :" + result);
        return getBookById(book.getId());
    }

    public BookModel deleteBook(int id) throws SQLException {
        String sql = "delete from book where id=" + id;
        Statement statement = connection.createStatement();
        BookModel book = getBookById(id);
        int result = statement.executeUpdate(sql);
        logger.info("inside delete result is" + result);

        return book;
    }

}
