package com.groupwork.Model;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by sangzhe on 2018/4/8.
 */
public class JWTToken implements AuthenticationToken{
    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public JWTToken(String token) {
        this.token = token;
    }
}
