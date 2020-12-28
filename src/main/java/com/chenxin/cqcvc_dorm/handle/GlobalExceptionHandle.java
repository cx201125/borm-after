package com.chenxin.cqcvc_dorm.handle;

import com.chenxin.cqcvc_dorm.exception.NotFountException;
import com.chenxin.cqcvc_dorm.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

    //处理登录失败的异常处理器
    @ExceptionHandler(NotFountException.class)
    public R noexcept(NotFountException e){
        return R.error(e.getCode(),e.getMsg());
    }
    //兜底的异常处理
    @ExceptionHandler(Exception.class)
    public R globa(Exception e){
        e.printStackTrace();
        return R.error();
    }
}
