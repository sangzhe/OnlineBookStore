package com.groupwork.Service;

import com.groupwork.Mapper.UserGeneralMapper;
import com.groupwork.Mapper.UserSecurityMapper;
import com.groupwork.Model.UserGeneral;
import com.groupwork.Model.UserSecurity;
import com.groupwork.Util.MD5utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Date;
import java.util.Map;

/**
 * Created by sangzhe on 2018/4/7.
 */
@Service
public class UserService {
    private static final Logger _logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserSecurityMapper userSecurityMapper;
    @Autowired
    UserGeneralMapper userGeneralMapper;

    public UserSecurity getUserSecurityByEmail(String Email){
        return userSecurityMapper.getUserSecurityByEmail(Email);
    }
    public boolean UserLoginVerification(String Email,String Password){
        UserSecurity user = this.getUserSecurityByEmail(Email);
        String encryptedPassword = MD5utils.MD5EncodeUtf8(Password);
        return encryptedPassword.equals(user.getPassword());
    }

    @Transactional(rollbackFor = Exception.class)
    public int UserRegister(String Email,String Password){

        if(this.getUserSecurityByEmail(Email)!= null){
            // -2 means the email already exists in the database
            return -2;
        }
        String encrypted = MD5utils.MD5EncodeUtf8(Password);

        UserSecurity new_user = new UserSecurity(Email,encrypted);


        try {
            userSecurityMapper.insertNewUserSecurity(new_user);
            userGeneralMapper.insertNewUserGeneral(new_user.getUserId());
        }catch (Exception e){
            _logger.info("(addNewAddressToUser)Error:"+e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }

        return 0;
    }

    public UserSecurity getUserSecurityById(String Id){
        return userSecurityMapper.getUserSecurityById(Id);
    }

    public int modifyUserPassword(String Email,String Password){
        UserSecurity user = this.getUserSecurityByEmail(Email);
        String new_password = MD5utils.MD5EncodeUtf8(Password);
        user.setPassword(new_password);
        return userSecurityMapper.updateUserPassword(user);

    }

    public UserGeneral getUserGeneralByEmail(String Email){
        return userGeneralMapper.getUserByEmail(Email);
    }

    public int modifyUserProfile(String Email, Map<String,String> attributes){
        UserGeneral user = userGeneralMapper.getUserByEmail(Email);
        for(Map.Entry<String,String> entry:attributes.entrySet()){
            if(entry.getValue()=="") continue;
            switch (entry.getKey()){
                case "Gender": user.setGender(entry.getValue());break;
                case "Birth":user.setBirth(Date.valueOf(entry.getValue()));break;
                case "LastName":user.setLastName(entry.getValue());break;
                case "FirstName":user.setFirstName(entry.getValue());break;
            }
        }

        return userGeneralMapper.updateUserGeneral(user);
    }


}
