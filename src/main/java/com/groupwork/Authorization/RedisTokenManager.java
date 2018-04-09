package com.groupwork.Authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupwork.Model.Constants;
import com.groupwork.Model.Token;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by sangzhe on 2018/4/8.
 */
@Component
@Data
public class RedisTokenManager implements TokenManager{
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    ObjectMapper mapper = new ObjectMapper();



    @Override
    public Token createToken(String userEmail) {
        String tokenStr = userEmail+UUID.randomUUID().toString().replace("-", "");
        Token token=new Token(userEmail, tokenStr);
        try {
            String value = mapper.writeValueAsString(token);
            redisTemplate.boundValueOps(tokenStr)
                    .set(value, Constants.EXPIRE, TimeUnit.HOURS); //一天过期时间
        }catch (Exception e){
            e.printStackTrace();
        }

        return token;
    }
    @Override
    public boolean checkToken(String tokenStr) {
        //
        if(tokenStr!= null && tokenStr.length()!=0) {
            String json = redisTemplate.boundValueOps(tokenStr).get();
            try {
                Token token = mapper.readValue(json, Token.class);
                if (token.equals(token.getToken())) {
                    //程序授权过期时间
                    return redisTemplate.boundValueOps(tokenStr).expire(Constants.EXPIRE, TimeUnit.HOURS);
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }

        return false;
    }
    @Override
    public Token getToken(String authentication) {
        //获取
        String json = redisTemplate.boundValueOps(authentication).get();
//				JSONUtil.
        try {
            Token token = mapper.readValue(json, Token.class);
            return token;
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }
    @Override
    public void deleteToken(String authentication) {
        redisTemplate.delete(authentication);
    }

}
