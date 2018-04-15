package com.groupwork;

import com.groupwork.Model.OrderDetail;
import com.groupwork.Service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sangzhe on 2018/4/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ECommerceApplication.class)
public class OrderFunctionTest {
    @Autowired
    private OrderService orderService;
    @Test
    public void testGetAllOrderDetails() {
        List<OrderDetail> results = orderService.getAllOrderDetailsByEmail("zhe.sang@icloud.com");

        results.size();
    }

    @Test
    @Transactional
    public void testInsertOrderDetail(){
        int bookId = 8;
        int amount = 2;
        int n =orderService.addOrderDetail(bookId,amount);
        assertThat(n).isEqualTo(1);
    }

    @Test
    @Transactional
    public void testDeleteOrderDetail(){
        int n =orderService.deleteOrderDetail("e5ab3051-9b7a-49b2-b3a5-de32f09301f7");

        assertThat(n).isEqualTo(1);
    }
}
