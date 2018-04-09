package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class Cart implements Serializable {
    private UserGeneral User;
    private OrderDetail OrderDetail;

    public Cart(UserGeneral user, com.groupwork.Model.OrderDetail orderDetail) {
        User = user;
        OrderDetail = orderDetail;
    }

    public UserGeneral getUser() {
        return User;
    }

    public void setUser(UserGeneral user) {
        User = user;
    }

    public com.groupwork.Model.OrderDetail getOrderDetail() {
        return OrderDetail;
    }

    public void setOrderDetail(com.groupwork.Model.OrderDetail orderDetail) {
        OrderDetail = orderDetail;
    }
}
