package net.qipo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 集中处理所有异常
 *
 * 1. 集中处理所有异常的类加入到ioc容器中;
 * 2. @ControllerAdvice专门处理异常的类
 */
@ControllerAdvice
public class MyOriginException {
//    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class} )
//    public ModelAndView handleException01(Exception e) {
//        System.out.println("handleException01" + e);
//
//        //
//        ModelAndView myerror = new ModelAndView("myerror");
//        myerror.addObject("ex", e);
//        // 视图解析器拼串
//        return myerror;
//    }
}
