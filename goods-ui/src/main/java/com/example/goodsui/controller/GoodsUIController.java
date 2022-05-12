package com.example.goodsui.controller;

import com.example.goodscommon.pojo.Book;
import com.example.goodsui.Service.GoodsUIService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/ui")
public class GoodsUIController {

    @Resource
    private GoodsUIService goodsUIService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        goodsUIService.testGoodsProvider();
        return "success";
    }

    //查询
    @RequestMapping("/list")
    @ResponseBody
    public List<Book> list(){
        List<Book> bookList = goodsUIService.getBookList();
        return bookList;
    }

    @RequestMapping("/detail/{id}")
    @ResponseBody
    public Book detail(@PathVariable("id")Integer id){
        Book book = goodsUIService.getBookDetail(id);
        return book;
    }
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        return goodsUIService.addBook(book);
    }

}

