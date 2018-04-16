package com.groupwork.Controller;

import com.groupwork.Model.Address;
import com.groupwork.Model.Payment;
import com.groupwork.Model.Result;
import com.groupwork.Service.AddressService;
import com.groupwork.Service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by sangzhe on 2018/4/15.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/access_control")
public class UserInfoController {

    private static final Logger _logger = LoggerFactory.getLogger(UserInfoController.class);


    @Autowired
    AddressService addressService;
    @Autowired
    PaymentService paymentService;

    @RequestMapping("/payment/delete")
    public Result deleteUserPayment(@RequestParam("PaymentId") String PaymentId){
        int n = paymentService.deletePayment(PaymentId);
        if(n==1){
            return Result.success();
        }else{
            return Result.fail("Fail to delete",201);
        }
    }

    @RequestMapping("/payment/getAll")
    public Result getUserPayments(@RequestParam("username") String username){
        _logger.info("Controller.UserInfoController.getUSerPayments");
        List<Payment> paymentList = paymentService.getUserPaymentsByEmail(username);
        if(paymentList!=null || paymentList.size()!=0){
            return Result.success(paymentList);
        }else{
            return Result.fail("No payments found",400);
        }
    }
    @RequestMapping("/payment/add")
    public Result addUserPayment(@RequestParam Map<String, String> params){
        _logger.info("Controller.UserInfoController.addUserPayment");
        _logger.info(params.toString());
        String UserEmail=params.get("username");
        String CardNumber = params.get("CardNumber");
        String Expire=params.get("Expire");
        String SecurityNumber=params.get("SecurityNumber");
        String LastName=params.get("LastName");
        String FirstName=params.get("FirstName");
        int Zipcode=Integer.parseInt(params.get("Zipcode"));
        int n = paymentService.addNewPaymentToUser(CardNumber,LastName,FirstName,SecurityNumber,Expire,Zipcode,UserEmail);
        if(n==0){
            return Result.success();
        }else{
            return Result.fail("Error in adding new payment",401);
        }
    }


    @RequestMapping("/address/delete")
    public Result deleteUserAddress(@RequestParam("AddressId") String AddressId){
        int n = addressService.deleteAddress(AddressId);
        if(n==1){
            return Result.success();
        }else{
            return Result.fail("Fail to delete",201);
        }
    }

    @RequestMapping("/address/getAll")
    public Result getUSerAddresses(@RequestParam("username") String username){
        List<Address> addressList = addressService.getUserAddressByEmail(username);
        if(addressList!= null || addressList.size()!=0){
            return Result.success(addressList);
        }else{
            return Result.fail("No addresses Fund",400);
        }
    }
    @RequestMapping("/address/add")
    public Result addUserAddress(@RequestParam Map<String, String> params) {
        _logger.info("Controller.UserInfoController.addUserAddress");
        _logger.info(params.toString());
        String UserEmail = params.get("username");
        String Street = params.get("Street");
        String Street2 = params.get("Street2");
        String City = params.get("City");
        String State = params.get("State");
        int Zipcode = Integer.parseInt(params.get("Zipcode"));
        int n = addressService.addNewAddressToUser(Street, Street2, City, State, Zipcode, UserEmail);
        if (n == 0) {
            return Result.success();
        } else {
            return Result.fail("Error in adding new payment", 401);
        }
    }

}
