package com.groupwork.Mapper;

import com.groupwork.Model.Book;
import com.groupwork.Model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by sangzhe on 2018/4/14.
 */
@Mapper
@Repository
public interface OrderMapper {

    int insertOrder(@Param("OrderId") String OrderId,
                    @Param("OrderDetailId")String OrderDetailId,
                    @Param("PaymentId") String PaymentId,
                    @Param("BillingAddressId") String BilllingAddressId,
                    @Param("ShippingAddressId") String ShippingAddressId,
                    @Param("UserId") String UserId,
                    @Param("OrderPrice") float OrderPrice,
                    @Param("Date")Date Date);

    List<Order> getAllOrdersByEmail(String Email);


    List<Book> getTopSellingBook();

    Book getPreferenceByGender(@Param("Gender") String Gender);
}
