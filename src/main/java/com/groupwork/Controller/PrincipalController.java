package com.groupwork.Controller;

import com.groupwork.Model.Order;
import com.groupwork.Model.OrderDetail;
import com.groupwork.Model.Result;
import com.groupwork.Service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/15.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/access_control")
public class PrincipalController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/cart/add")
    public Result addToCart(@RequestParam("Email") String Email, @RequestParam("BookId") int BookId,@Param("BookAmount") int BookAmount){
        int n = orderService.addToCart(Email,BookId,BookAmount);
        return Result.success();
    }

    @RequestMapping("/cart/getAll")
    public Result getAllFromCart(@RequestParam("Email") String Email){
        List<OrderDetail> results= orderService.getOrderDetailsFromCartByEmail(Email);
        if(results!=null ||results.size()!=0){
            return Result.success(results);
        }else{
            return Result.fail("Empty cart",100);
        }
    }

    @RequestMapping("/transaction/placeorder")
    public Result placeAnOrder(@RequestParam("Email") String Email,@RequestParam("PaymentId") String PaymentId,@RequestParam("BillingAddressId") String BillingAddressId,@RequestParam("ShippingAddressId") String ShippingAddressId,@RequestParam("OrderDetailId") String OrderDetailId){
        String[] OrderDetailIds = OrderDetailId.split("||");
        int n = orderService.addOrder(Email,PaymentId,BillingAddressId,ShippingAddressId, OrderDetailIds);
        return Result.success();
    }

    @RequestMapping("/history")
    public Result getAllOrdersByEmail(@RequestParam("Email") String Email){
        List<Order> orders = orderService.getAllOrdersByEmail(Email);
        if(orders!=null ||orders.size()!=0){
            return Result.success(orders);
        }else{
            return Result.fail("No order",100);
        }
    }


}
