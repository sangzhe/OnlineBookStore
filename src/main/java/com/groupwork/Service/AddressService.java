package com.groupwork.Service;

import com.groupwork.Mapper.AddressMapper;
import com.groupwork.Mapper.UserGeneralMapper;
import com.groupwork.Model.Address;
import com.groupwork.Model.UserGeneral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by sangzhe on 2018/4/14.
 */
@Service
public class AddressService {

    private static final Logger _logger = LoggerFactory.getLogger(AddressService.class);


    @Autowired
    AddressMapper addressMapper;

    @Autowired
    UserGeneralMapper userGeneralMapper;

    @Transactional(rollbackFor = Exception.class)
    public String addNewAddressToUser(String street, String street2, String city, String state, int zipcode,String Email){
        _logger.info("Service.AddressService.addNewAddressToUser");
        Address address = new Address(street, street2, city, state, zipcode);
        String AddressId = address.getId();
        UserGeneral user = userGeneralMapper.getUserByEmail(Email);

        try {
            addressMapper.insertAddress(address);
            addressMapper.insertUserAddress(AddressId, user.getId());
        }catch (Exception e){
            _logger.info("(addNewAddressToUser)Error:"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "Error to add";
        }


        return AddressId;

    }


    public List<Address> getUserAddressByEmail(String Email){
        return addressMapper.getAddressesByUsername(Email);
    }

    public int deleteAddress(String AddressId){
        _logger.info("Service.AddressService.deleteAddress");
        return addressMapper.deleteAddress(AddressId);
    }
}
