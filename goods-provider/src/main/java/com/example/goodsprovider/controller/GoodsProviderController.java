package com.example.goodsprovider.controller;

import com.example.goodscommon.pojo.Book;
import com.example.goodsprovider.Service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Book book = goodsProviderService.getBookDetail(id);
        return book;
    }
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        goodsProviderService.addBook(book);
        return "success";
    }

    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//次数
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50")//服务错误率
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num")Integer num){
        int n = (int)Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回: "+n+"/"+num+"="+result;
    }
    public String fallBack(@RequestParam("num")Integer num){
        return "服务降级响应:num为0";
    }

}
