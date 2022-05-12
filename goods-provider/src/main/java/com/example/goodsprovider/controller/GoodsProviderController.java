package com.example.goodsprovider.controller;

import com.example.goodscommon.pojo.Book;
import com.example.goodsprovider.Service.GoodsProviderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderController {

    @Resource
    private GoodsProviderService goodsProviderService;
    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了good-provider");
        return "调用成功";
    }
    @RequestMapping("/list")
    public List<Book> list(){
    List<Book> bookList = goodsProviderService.getBookList();
    return bookList;
    }

    @RequestMapping("/detail/{id}")
    public Book detail(@PathVariable("id")Integer id){

        Book book = goodsProviderService.getBookDetail(id);
        return book;
    }
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        goodsProviderService.addBook(book);
        return "success";
    }
}
