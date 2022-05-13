package com.example.goodsui.Service;


import com.example.goodscommon.pojo.Book;
import com.example.goodscommon.vo.ResultVo;

import java.util.List;

public interface GoodsUIService {
    void testGoodsProvider();

    List<Book> getBookList();

    ResultVo getBookDetail(Integer id);

    String addBook(Book book);
}
