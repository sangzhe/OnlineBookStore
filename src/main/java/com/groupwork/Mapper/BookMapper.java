package com.groupwork.Mapper;

import com.groupwork.Model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/11.
 */
@Mapper
@Repository
public interface BookMapper {

    /**
     * used for present book detail
     * @param Id bookid
     * @return
     */
    Book getBookDetailById(int Id);

    /**
     * used for browsing books
     * @param name default is "%", means match any name
     * @param category  default is "%"
     * @param sortBy    default is sort by rate
     * @param limit     used for page
     * @param offset
     * @return
     */
    List<Book> getBooks(@Param("name") String name, @Param("author") String author,@Param("category") String category,@Param("sortBy") String sortBy, @Param("limit") int limit,@Param("offset") int offset);
}
