package com.groupwork.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class Order implements Serializable{
    private String Id;
    private List<OrderDetail> OrderDetails;
    private UserGeneral User;
    private Address ShippingAddress;
    private Address BillingAddress;
    private Payment Payment;
    private Date OrderDate;
    private float OrderPrice;

    public Order(List<com.groupwork.Model.OrderDetail> orderDetails, UserGeneral user, Address shippingAddress, Address billingAddress, com.groupwork.Model.Payment payment, Date orderDate, float orderPrice) {
        Id = UUID.randomUUID().toString();
        OrderDetails = orderDetails;
        User = user;
        ShippingAddress = shippingAddress;
        BillingAddress = billingAddress;
        Payment = payment;
        OrderDate = orderDate;
        OrderPrice = orderPrice;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public List<com.groupwork.Model.OrderDetail> getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetail(List<com.groupwork.Model.OrderDetail> orderDetails) {
        OrderDetails = orderDetails;
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
