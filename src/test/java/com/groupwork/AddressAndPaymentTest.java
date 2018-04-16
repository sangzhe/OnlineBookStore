//package com.groupwork;
//
//import com.groupwork.Service.AddressService;
//import com.groupwork.Service.PaymentService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
///**
// * Created by sangzhe on 2018/4/15.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ECommerceApplication.class)
//public class AddressAndPaymentTest {
//    @Autowired
//    PaymentService paymentService;
//    @Autowired
//    AddressService addressService;
//
//    @Test
//    public void testAddPayment(){
//        int n =paymentService.addNewPaymentToUser("412002739984","Zhe","Sang","087","0822",15206,"zhe.sang@gmail.com");
//        assertThat(n).isEqualTo(0);
//
//    }
//
//    @Test
//    public void testAddAddress(){
//        int n = addressService.addNewAddressToUser("5700 Bunkerhill St.","APT.603","Pittsburgh","PA",15206,"zhe.sang@icloud.com");
//        assertThat(n).isEqualTo(0);
//    }
//}
