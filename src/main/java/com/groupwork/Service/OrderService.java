package com.groupwork.Service;

import com.groupwork.Mapper.*;
import com.groupwork.Model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by sangzhe on 2018/4/14.
 */
@Service
public class OrderService {

    private static final Logger _logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    PaymentMapper paymentMapper;

    @Autowired
    UserGeneralMapper userGeneralMapper;

    public List<OrderDetail> getAllOrderDetailsByEmail(String Email){
        return orderDetailMapper.getOrderDetailsFromCartByEmail(Email);
    }

    public int addOrderDetail(int bookId,int bookAmount){
        String Id = UUID.randomUUID().toString();
        return orderDetailMapper.insertOrderDetail(Id,bookId,bookAmount);
    }

    public int deleteOrderDetail(String Id){
        return orderDetailMapper.deleteOrderDetail(Id);
    }

    @Transactional(rollbackFor = Exception.class)
    public int addOrder(String Email,String PaymentId,String BillingAddressId,String ShippingAddressId,String[] OrderDetailIds){
        try {
            List<OrderDetail> orderDetails = new ArrayList<>();
            float price=0;
            for (int i = 0; i < OrderDetailIds.length; i++) {
                OrderDetail orderDetail = orderDetailMapper.getOrderDetailById(OrderDetailIds[i]);
                if (orderDetail.getBook().getStock() < orderDetail.getBookAmount()) {
                    throw new Exception("out of stock");
                }
                price += orderDetail.getBookAmount()*orderDetail.getBook().getPrice();
                orderDetails.add(orderDetail);
            }

            UserGeneral user = userGeneralMapper.getUserByEmail(Email);
            Payment payment = paymentMapper.getPaymentById(PaymentId);
            Address billingAddress = addressMapper.getAddressById(BillingAddressId);
            Address shippingAddress = addressMapper.getAddressById(ShippingAddressId);

            if(!payment.check()){
                throw new Exception("Payment denied");
            }

            Order order = new Order(orderDetails,user,shippingAddress,billingAddress,payment,new Date(System.currentTimeMillis()),price);

            orderMapper.insertOrder(order);

        }catch (Exception e){
            _logger.info("(addOrder)Error:"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }
        return 0;
    }
}
