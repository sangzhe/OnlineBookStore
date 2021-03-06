package com.groupwork.Controller;

import com.groupwork.Model.Result;
import com.groupwork.Model.UserGeneral;
import com.groupwork.Service.UserService;
import com.groupwork.Util.JWTUtil;
import com.groupwork.Util.MD5utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by sangzhe on 2018/4/7.
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    private static final Logger _logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserService userService;
//    @RequestMapping(value="/hello")
//    public Result hello(){
//        return Result.success("Hello");
//    }

    @RequestMapping(value = "/user/username={username:.+}",method = RequestMethod.GET)
    public Result getUserGeneralByEmail(@PathVariable("username") String username){

        _logger.info(username+" is attempting to get user profile");

        UserGeneral user = userService.getUserGeneralByEmail(username);

        if(user==null){
            return Result.fail("No user",401);
        }

        return Result.success(user);
    }

    @PostMapping("/login")
    public Result login(@RequestParam("username") String username,@RequestParam("password") String password){
        _logger.info("UserController:login");
        _logger.info("username:"+username);
        _logger.info("password:"+password);
        boolean flag = userService.UserLoginVerification(username,password);
        String encrpted = MD5utils.MD5EncodeUtf8(password);
        if(flag){
            return Result.success(JWTUtil.sign(username,encrpted));
        }else{
            return new Result("UnauthorizedException", 401);
        }
    }

    @PostMapping("/register")
    public Result register(@RequestParam("username") String username,@RequestParam("password") String password){
        _logger.info("UserController:register");
        _logger.info("username:"+username);
        _logger.info("password:"+password);
        int res = userService.UserRegister(username,password);
        if(res==-2){
            return Result.fail("username exists",400);
        }else{
            return Result.success("Resgister succeed");
        }
    }

    @RequestMapping("/user/modify_password")
    public Result modifyPassword(@RequestParam("username") String username,@RequestParam("new_password") String new_password){
        int n = userService.modifyUserPassword(username,new_password);
        if(n==0)return Result.fail("Failed",401);
        return Result.success();
    }

    @RequestMapping("/user/modify_profile")
    public Result modifyUserProfile(@RequestParam Map<String,String> params){
        String Email = params.get("username");
        params.remove("username");
        int n =userService.modifyUserProfile(Email,params);
        if(n==0)return Result.fail("Failed",401);
        return Result.success();
    }

    @RequestMapping(path="/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result unauthorized() {
        return Result.fail("Unauthorized", 401);
    }


}
