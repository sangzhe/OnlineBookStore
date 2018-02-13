package com.groupwork.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class Order implements Serializable{
    private int Id;
    private OrderDetail OrderDetail;
    private UserGeneral User;
    private Address ShippingAddress;
    private Address BillingAddress;
    private Payment Payment;
    private Date OrderDate;
    private float OrderPrice;

    public Order(int id, com.groupwork.Model.OrderDetail orderDetail, UserGeneral user, Address shippingAddress, Address billingAddress, com.groupwork.Model.Payment payment, Date orderDate, float orderPrice) {
        Id = id;
        OrderDetail = orderDetail;
        User = user;
        ShippingAddress = shippingAddress;
        BillingAddress = billingAddress;
        Payment = payment;
        OrderDate = orderDate;
        OrderPrice = orderPrice;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public com.groupwork.Model.OrderDetail getOrderDetail() {
        return OrderDetail;
    }

    public void setOrderDetail(com.groupwork.Model.OrderDetail orderDetail) {
        OrderDetail = orderDetail;
    }

    public UserGeneral getUser() {
        return User;
    }

    public void setUser(UserGeneral user) {
        User = user;
    }

    public Address getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        BillingAddress = billingAddress;
    }

    public com.groupwork.Model.Payment getPayment() {
        return Payment;
    }

    public void setPayment(com.groupwork.Model.Payment payment) {
        Payment = payment;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public float getOrderPrice() {
        return OrderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        OrderPrice = orderPrice;
    }
}
