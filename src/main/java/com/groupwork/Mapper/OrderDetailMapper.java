package com.groupwork.Mapper;

import com.groupwork.Model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/14.
 */
@Mapper
@Repository
public interface OrderDetailMapper {
    int insertOrderDetail(@Param("Id") String Id,@Param("BookId") int BookId, @Param("BookAmount") int BookAmount);

    int deleteOrderDetail(String Id);

    OrderDetail getOrderDetailById(String Id);

    List<OrderDetail> getOrderDetailsFromCartByEmail(String Email);
}
