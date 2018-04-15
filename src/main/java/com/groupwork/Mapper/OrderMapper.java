package com.groupwork.Mapper;

import com.groupwork.Model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/14.
 */
@Mapper
@Repository
public interface OrderMapper {

    int insertOrder(Order order);

    List<Order> getAllOrdersByEmail(String Email);
}
