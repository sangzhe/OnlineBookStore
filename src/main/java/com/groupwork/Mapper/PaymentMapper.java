package com.groupwork.Mapper;

import com.groupwork.Model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/12.
 */
@Mapper
@Repository
public interface PaymentMapper {
    List<Payment> getPaymentsByUsername(String Email);

    int insertPayment(@Param("Payment") Payment Payment);

    int insertUserPayment(@Param("PaymentId") String PaymentId,@Param("Email") String Email);

    int deletePayment(@Param("PaymentId") String PaymentId);

    Payment getPaymentById(String Id);
}
