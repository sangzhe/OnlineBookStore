package com.groupwork.Controller;

import com.groupwork.Model.Result;
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sangzhe on 2018/4/10.
 */
@RestControllerAdvice
public class ExceptionController {
    private static final Logger _logger = LoggerFactory.getLogger(ExceptionController.class);


    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Result handle401(ShiroException e) {
        _logger.info("ExceptionController.handle401");
        _logger.info(e.getMessage());
        return Result.fail(e.getMessage(), 401);
    }


    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result globalException(HttpServletRequest request, Throwable ex) {
        _logger.info("ExceptionController.globalException");
        _logger.info(ex.getMessage());
        return new Result("other exception:"+ex.getMessage(), 400);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
