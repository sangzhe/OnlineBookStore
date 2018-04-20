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
    public Result addToCart(@RequestParam("username") String username, @RequestParam("BookId") String BookId,@Param("BookAmount") String BookAmount){
        int bookId = Integer.parseInt(BookId);
        int bookAmount = Integer.parseInt(BookAmount);
        int n = orderService.addToCart(username,bookId,bookAmount);
        return Result.success();
    }

    @RequestMapping("/cart/getAll")
    public Result getAllFromCart(@RequestParam("username") String username){
        List<OrderDetail> results= orderService.getOrderDetailsFromCartByEmail(username);
        if(results!=null ||results.size()!=0){
            return Result.success(results);
        }else{
            return Result.fail("Empty cart",100);
        }
    }

    @RequestMapping("/transaction/directpurchase")
    public Result directPurchase(@RequestParam("username") String username,
                                 @RequestParam("BookId") String BookId,
                                 @RequestParam("BookAmount") String BookAmount,
                                 @RequestParam("LastName") String LastName,
                                 @RequestParam("FirstName") String FirstName,
                                 @RequestParam("CardNumber") String CardNumber,
                                 @RequestParam("Expire") String Expire,
                                 @RequestParam("SecurityNumber") String SecurityNumber,
                                 @RequestParam("PaymentZipcode") String PaymentZipcode,
                                 @RequestParam("Street") String Street,
                                 @RequestParam("Street2") String Street2,
                                 @RequestParam("City") String City,
                                 @RequestParam("State") String State,
                                 @RequestParam("AddressZipcode") String AddressZipcod){


        int n =orderService.addOrder(username,BookId,BookAmount,LastName,FirstName,CardNumber,Expire,SecurityNumber,PaymentZipcode,Street,Street2,City,State,AddressZipcod);
        return Result.success();
    }
    @RequestMapping("/transaction/placeorder")
    public Result placeAnOrder(@RequestParam("username") String username,@RequestParam("PaymentId") String PaymentId,@RequestParam("BillingAddressId") String BillingAddressId,@RequestParam("ShippingAddressId") String ShippingAddressId,@RequestParam("OrderDetailId") String OrderDetailId){
        String[] OrderDetailIds = OrderDetailId.split("||");
        int n = orderService.addOrder(username,PaymentId,BillingAddressId,ShippingAddressId, OrderDetailIds);
        return Result.success();
    }
    @RequestMapping("/history")
    public Result getAllOrdersByEmail(@RequestParam("username") String username){
        List<Order> orders = orderService.getAllOrdersByEmail(username);
        if(orders!=null ||orders.size()!=0){
            return Result.success(orders);
        }else{
            return Result.fail("No order",100);
        }
    }


}
