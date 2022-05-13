package com.example.goodsui.Service;

import com.example.goodscommon.pojo.Book;
import com.example.goodscommon.vo.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@Service
public class GoodsUIServiceImpl implements GoodsUIService {

   @Resource
   private RestTemplate restTemplate;
    @Override
    public void testGoodsProvider() {
        String forObject = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goods-provider返回结果--" + forObject);
    }

    @Override
    public List<Book> getBookList() {
        Book[] bookList =   restTemplate.getForObject("http://goods-provider/provider/list",Book[].class);

        return Arrays.asList(bookList);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackDetail",commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    }//降级响应设置时间
    )
    public ResultVo getBookDetail(Integer id) {
        Book forObject = restTemplate.getForObject("http://goods-provider/provider/detail/" + id, Book.class);
        return ResultVo.ok(forObject);
    }
    public ResultVo fallBackDetail(Integer id) {
         return ResultVo.error("服务降级返回无内容");
    }


    @Override
    public String addBook(Book book) {
        String s = restTemplate.postForObject("http://goods-provider/provider/add", book, String.class);
        return s;

    }
}
