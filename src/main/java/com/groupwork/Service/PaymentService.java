package com.groupwork.Service;

import com.groupwork.Mapper.PaymentMapper;
import com.groupwork.Mapper.UserGeneralMapper;
import com.groupwork.Model.Payment;
import com.groupwork.Model.UserGeneral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/14.
 */
@Service
public class PaymentService {
    private static final Logger _logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    PaymentMapper paymentMapper;

    @Autowired
    UserGeneralMapper userGeneralMapper;

//    @Transactional(rollbackFor = Exception.class)
    public String addNewPaymentToUser(String cardNumber, String lastName, String firstName, String securityNumber, String expire, int zipcode,String Email){
        _logger.info("Service.AddressService.addNewAddressToUser");
        Payment payment = new Payment(cardNumber, lastName, firstName, securityNumber, expire, zipcode);
        String PaymentId = payment.getId();
        UserGeneral user = userGeneralMapper.getUserByEmail(Email);

        try {
            paymentMapper.insertPayment(payment);
            paymentMapper.insertUserPayment(PaymentId,user.getId());
        }catch (Exception e){
            _logger.info("(addNewAddressToUser)Error:"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "Error to add";
        }


        return PaymentId;

    }


    public List<Payment> getUserPaymentsByEmail(String Email){
        return paymentMapper.getPaymentsByUsername(Email);
    }

    public int deletePayment(String PaymentId){
        _logger.info("Service.AddressService.deletePayment");
        return paymentMapper.deletePayment(PaymentId);
    }

}
