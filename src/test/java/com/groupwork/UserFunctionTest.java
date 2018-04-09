package com.groupwork;

import com.groupwork.Model.UserSecurity;
import com.groupwork.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sangzhe on 2018/4/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ECommerceApplication.class)
public class UserFunctionTest {


    @Autowired
    private UserService userService;
    @Test
    public void testUserRegister(){
        int n = userService.UserRegister("zhe.sang@icloud.com","0000000000000");
        userService.UserRegister("zhe.sang@gmail.com","1234454566");
        assertThat(n).isEqualTo(0);
    }

    @Test
    public void testUserLogin(){
        boolean g = userService.UserLoginVerification("zhe.sang@gmail.com","1234454566");
        assertThat(g).isEqualTo(true);
    }

    @Test
    public void testUserModifyPassword(){
        UserSecurity user = userService.getUserSecurityByEmail("zhe.sang@icloud.com");
        String id = user.getUserId();
        int n = userService.modifyUserPassword(id,"876543222222");
        assertThat(n).isGreaterThan(0);
    }

    @Test
    public void testUserInformationModification(){
        Map<String,String> attribute = new HashMap<String,String>();
        attribute.put("LastName","Sang");
        attribute.put("FirstName","Zhe");
        attribute.put("Birth","1995-06-27");
        attribute.put("Gender","Male");

        UserSecurity user = userService.getUserSecurityByEmail("zhe.sang@icloud.com");
        String id = user.getUserId();
        int n = userService.modifyUserProfile(id,attribute);
        assertThat(n).isGreaterThan(0);
    }


}
