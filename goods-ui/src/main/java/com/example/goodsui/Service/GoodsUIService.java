package com.example.goodsui.Service;


import com.example.goodscommon.pojo.Book;

import java.util.List;

public interface GoodsUIService {
    void testGoodsProvider();

    List<Book> getBookList();

    Book getBookDetail(Integer id);

    String addBook(Book book);
}
