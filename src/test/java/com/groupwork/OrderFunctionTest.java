//package com.groupwork;
//
//import com.groupwork.Model.Order;
//import com.groupwork.Model.OrderDetail;
//import com.groupwork.Service.OrderService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
///**
// * Created by sangzhe on 2018/4/14.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ECommerceApplication.class)
//public class OrderFunctionTest {
//    @Autowired
//    private OrderService orderService;
//    @Test
//    public void testGetAllOrderDetails() {
//        List<OrderDetail> results = orderService.getAllOrderDetailsByEmail("zhe.sang@icloud.com");
//
//        results.size();
//    }
//
//    @Test
//    public void testGetAllOrderByEmail(){
//        List<Order> results = orderService.getAllOrdersByEmail("zhe.sang@icloud.com");
//        results.size();
//    }
////    @Test
////    public void testInsertOrderDetailToCart(){
////        int bookId = 40;
////        int amount = 1;
////        int n =orderService.addToCart("zhe.sang@icloud.com",bookId,amount);
////        assertThat(n).isEqualTo(0);
////    }
//
//
//
//    @Test
//    @Transactional
//    public void testDeleteOrderDetail(){
//        int n =orderService.deleteOrderDetail("e5ab3051-9b7a-49b2-b3a5-de32f09301f7");
//
//        assertThat(n).isEqualTo(1);
//    }
//
//    @Test
//    public void testGetOrderDetailsFromCart(){
//        List<OrderDetail> results =  orderService.getOrderDetailsFromCartByEmail("zhe.sang@icloud.com");
//
//        results.size();
//    }
//
////    @Test
////    public void testPlaceOrder(){
////        String[] orderDetailsId = new String[2];
////        orderDetailsId[0] = "0c4208b8-5340-4a9a-b1fe-de6bced03980";
////        orderDetailsId[1] = "8afb1b1e-f9f7-4d6e-bc90-3032056dbe74";
////        int n = orderService.addOrder("zhe.sang@icloud.com",
////                "976d0490-acf4-48b5-b370-16df7296b727",
////                "3f52f54a-f108-44ef-b188-d8f45bc414ad","3f52f54a-f108-44ef-b188-d8f45bc414ad",
////                orderDetailsId);
////        assertThat(n).isEqualTo(0);
////    }
//}
