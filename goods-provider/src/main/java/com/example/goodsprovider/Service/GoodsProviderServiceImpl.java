package com.example.goodsprovider.Service;

import com.example.goodscommon.pojo.Book;
import com.example.goodsprovider.Dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodsProviderService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<Book> getBookList() {
        return goodsDao.getBookList();
    }

    @Override
    public Book getBookDetail(Integer id) {
        return goodsDao.getBookDetial(id);
    }

    @Override
    public void addBook(Book book) {
        goodsDao.addBook(book);
    }
}
