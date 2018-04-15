package com.groupwork.Service;

import com.groupwork.Mapper.PaymentMapper;
import com.groupwork.Model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by sangzhe on 2018/4/14.
 */
@Service
public class PaymentService {
    private static final Logger _logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    PaymentMapper paymentMapper;

//    @Transactional(rollbackFor = Exception.class)
    public int addNewPaymentToUser(int cardNumber, String lastName, String firstName, int securityNumber, String expire, int zipcode,String Email){
        _logger.info("Service.AddressService.addNewAddressToUser");
        Payment payment = new Payment(cardNumber, lastName, firstName, securityNumber, expire, zipcode);
        String PaymentId = payment.getId();


        try {
            paymentMapper.insertPayment(payment);
            paymentMapper.insertUserPayment(PaymentId,Email);
        }catch (Exception e){
            _logger.info("(addNewAddressToUser)Error:"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }


        return 0;

    }

    public int deletePayment(String PaymentId){
        _logger.info("Service.AddressService.deletePayment");
        return paymentMapper.deletePayment(PaymentId);
    }

}
