package com.example.goodsprovider.Service;

import com.example.goodscommon.pojo.Book;

import java.util.List;

public interface GoodsProviderService {


    List<Book> getBookList();

    Book getBookDetail(Integer id);

    void addBook(Book book);
}
