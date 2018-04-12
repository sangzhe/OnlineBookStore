package com.groupwork.Controller;

import com.groupwork.Model.Book;
import com.groupwork.Model.Result;
import com.groupwork.Service.BrowsingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by sangzhe on 2018/4/11.
 */
@RestController
@RequestMapping("/api")
public class BookController {

    private static final Logger _logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BrowsingService bookService;

    @RequestMapping(path="/book/all")
    public Result allBooks(){
        _logger.info("Controller.BookController.allBooks");
        List<Book> books = bookService.getBook("","","","",0,10);
        if(books == null){
            return Result.fail("No books",300);
        }
        return Result.success(books);
    }

    @RequestMapping(path="/book/search")
    public Result searchBooksByCondition(@RequestParam Map<String, String> params){
        int limit = Integer.parseInt(params.get("limit"));
        int offset  = Integer.parseInt(params.get("offset"));
        String name ="";
        String author="";
        String sortBy="";
        String category="";
        if(params.containsKey("name")) name = params.get("name");
        if(params.containsKey("author")) author = params.get("author");
        if(params.containsKey("sortBy")) sortBy = params.get("sortBy");
        if(params.containsKey("category")) category = params.get("category");

        List<Book> books = bookService.getBook(name,author,category,sortBy,limit,offset);
        if(books == null){
            return Result.fail("No books",300);
        }
        return Result.success(books);

    }

    @RequestMapping(value="/book/id={Id}")
    public Result getBookDetail(@PathVariable("Id") int Id){
        _logger.info("Controller.BookController.getBookDetail");
        Book book = bookService.getBookDetailById(Id);
        if(book==null){
            return Result.fail("No book found",300);
        }
        return Result.success(book);
    }
}
