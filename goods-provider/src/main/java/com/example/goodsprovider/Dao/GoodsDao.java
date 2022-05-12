package com.example.goodsprovider.Dao;

import com.example.goodscommon.pojo.Book;



import java.util.List;
public interface GoodsDao {

    List<Book> getBookList();

    Book getBookDetial(Integer id);

    void addBook(Book book);
}
