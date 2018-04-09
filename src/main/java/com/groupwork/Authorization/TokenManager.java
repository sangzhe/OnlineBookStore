package com.groupwork.Authorization;

import com.groupwork.Model.Token;

/**
 * Created by sangzhe on 2018/4/8.
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @param Email 指定用户的email
     * @return 生成的token
     */
    public Token createToken(String Email);
    /**
     * 检查token是否有效
     * @return 是否有效
     */
    public boolean checkToken(String authorization);
    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public Token getToken(String authentication);
    /**
     * 清除token
     * @param authentication 登录用户的id
     */
    public void deleteToken(String authentication);
}

