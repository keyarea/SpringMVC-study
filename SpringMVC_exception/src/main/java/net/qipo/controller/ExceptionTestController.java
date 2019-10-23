package net.qipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTestController {

    @RequestMapping("/handle01")
    public String handle01(Integer i) {
        System.out.println("handle01...");
        System.out.println(10/i);
        return "success";
    }

    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String  username) {
        if (!"admin".equals(username) ){
            System.out.println("登陆失败!");
            throw new UserNameNotFoundException();
        }
        System.out.println("登陆成功");
        return "success";
    }

    @RequestMapping(value = "/handle03", method = RequestMethod.POST)
    public String handle03() {

        return "success";
    }

    @RequestMapping(value = "/handle04")
    public String handle04() {
        String str = null;
        str.equals("hello");
        return "success";
    }

    /**
     * 告诉springMVC这个方法专门用于处理这个类发生的异常
     * 1. 给方法上随便写一个Exception,用来接受发生的异常
     * 2. 要携带异常信息,不能给参数位置写model;
     * 3. 直接返回ModelAndView就可以了
     * 4. 如果有多个@ExcepptionHandler都能处理这个异常,精确优先
     * 5. 全局异常处理与本类同时存在,本类优先
     */
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
