package com.groupwork.Authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by sangzhe on 2018/4/8.
 */
@Component
public class AuthorizationIntercetor extends HandlerInterceptorAdapter {
    @Autowired
    RedisTokenManager redisTokenManager;

    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //映射的不是方法
        if(!(handler instanceof HandlerMethod)){

            return true;
        }
        HandlerMethod handlerMethod =(HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //得到该处理器是否需要认证
        LoginRequired annotation = method.getAnnotation(LoginRequired.class);
        if(annotation==null){
            return true;
        }else{
            String authorization = request.getHeader(com.groupwork.Model.Constants.AUTHORIZATION);
            if(authorization!=null && authorization.length()!=0){

                boolean checkToken = redisTokenManager.checkToken(authorization);
                if(checkToken){
                    return true;
                }else{
                    returnJson(response, "Access denied");
                }

            }else{
                returnJson(response, "Resource not exits");
            }

        }





        return true;
    }
    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }
    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
    /**
     * This implementation is empty.
     */
    @Override
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    }


    /**
     * 异常返回
     * @param response
     * @param json
     * @throws Exception
     */
    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
