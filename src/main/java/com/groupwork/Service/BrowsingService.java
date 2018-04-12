package com.groupwork.Service;

import com.groupwork.Mapper.BookMapper;
import com.groupwork.Model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/11.
 */
@Service
public class BrowsingService {

    private static final Logger _logger = LoggerFactory.getLogger(BrowsingService.class);

    @Autowired
    BookMapper bookMapper;

    public Book getBookDetailById(int Id){
        _logger.info("Service.BrowsingService.getBookDetailById");
        Book book = bookMapper.getBookDetailById(Id);
        _logger.info(book.toString());
        return book;
    }

    public List<Book> getBook(String name,String author,String category,String sortBy,int limit,int offset){
        _logger.info("Service.BrowsingService.getBooks");

        _logger.info("name:"+name+" category: "+category+" sortBy:"+sortBy+ "limit:"+limit+","+offset);

        if(name.equals("")){
            name = null;
        }else{
            name = "%"+name+"%";
        }
        if(category.equals("")){
            category=null;
        }
        if(author.equals("")){
            author=null;
        }else{
            author = "%"+author+"%";
        }
        if(sortBy.equals("")){
            sortBy="rate";
        }
        List<Book> books =  bookMapper.getBooks(name,author,category,sortBy,limit,offset);
        _logger.info(books.toString());
        return books;
    }

}
