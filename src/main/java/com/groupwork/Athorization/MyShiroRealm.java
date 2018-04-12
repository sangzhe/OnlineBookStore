package com.groupwork.Athorization;

import com.groupwork.Model.JWTToken;
import com.groupwork.Model.UserSecurity;
import com.groupwork.Service.UserService;
import com.groupwork.Util.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sangzhe on 2018/4/10.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger _logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    UserService userService;

    /**
     * JWT签名密钥，这里没用。我使用的是用户的MD5密码作为签名密钥
     */
    public static final String SECRET = "9281e268b77b7c439a20b46fd1483b9a";

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 认证信息(身份验证)
     * Authentication 是用来验证用户身份
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)
            throws AuthenticationException {
        _logger.info("MyShiroRealm.doGetAuthenticationInfo()");

        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比

        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        //通过username从数据库中查找 ManagerInfo对象
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserSecurity user = userService.getUserSecurityByEmail(username);

        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

}