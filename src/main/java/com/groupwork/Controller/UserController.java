package com.groupwork.Controller;

import com.groupwork.Authorization.RedisTokenManager;
import com.groupwork.Model.Result;
import com.groupwork.Model.Token;
import com.groupwork.Model.UserGeneral;
import com.groupwork.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by sangzhe on 2018/4/7.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisTokenManager tokenManager;

    @RequestMapping(value="/hello" ,method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/id={ID}",method = RequestMethod.GET)
    public UserGeneral getUserGeneralById(@PathVariable("ID") String Id){
        return userService.getUserGeneralById(Id);
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Result Login(@RequestBody Map<String, String> request  ){
        if(userService.UserLoginVerification(request.get("Email"), request.get("Password"))){
            Token createToken = tokenManager.createToken(request.get("username"));
            return Result.success(createToken);
        }else{
            return Result.fail("fail",403);

        }
    }


}
