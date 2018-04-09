package com.groupwork.Service;

import com.groupwork.Mapper.UserGeneralMapper;
import com.groupwork.Mapper.UserSecurityMapper;
import com.groupwork.Model.UserGeneral;
import com.groupwork.Model.UserSecurity;
import com.groupwork.Util.MD5utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Map;

/**
 * Created by sangzhe on 2018/4/7.
 */
@Service
public class UserService {
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


        int n = userSecurityMapper.insertNewUserSecurity(new_user);

        int m = 1/n;

        n = userGeneralMapper.insertNewUserGeneral(new_user.getUserId());

        m = 1/n;

        return 0;
    }

    public UserSecurity getUserSecurityById(String Id){
        return userSecurityMapper.getUserSecurityById(Id);
    }

    public int modifyUserPassword(String Id,String Password){
        UserSecurity user = this.getUserSecurityById(Id);
        String new_password = MD5utils.MD5EncodeUtf8(Password);
        user.setPassword(new_password);
        return userSecurityMapper.updateUserPassword(user);

    }
    public UserGeneral getUserGeneralById(String Id){
        return userGeneralMapper.getUserById(Id);
    }

    public int modifyUserProfile(String Id, Map<String,String> attributes){
        UserGeneral user = userGeneralMapper.getUserById(Id);
        for(Map.Entry<String,String> entry:attributes.entrySet()){
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
