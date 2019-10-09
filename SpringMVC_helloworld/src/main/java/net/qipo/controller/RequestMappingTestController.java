package net.qipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 为当前类的所有方法的请求地址设置一个基准路径
 */
@RequestMapping("haha")
@Controller
public class RequestMappingTestController {

    @RequestMapping("handle01")
    public String handle01() {
        System.out.println("RequestMappingTestController ...handle01");
        return "success";
    }

    /**
     * @RequestMapping的其他属性
     * method: 限定请求方式
     *    	method=RequestMethod.GET: 只接受这种请求方式,默认是什么都可以;
     * 	    不是规定的请求方式就报错:
     *        405 - Request method 'GET' not supported
     * params: 规定请求参数
     * headers:
     * consumes:
     * produces:
     */
    @RequestMapping(value = "handle02",method = RequestMethod.POST)
    public String handle02() {
        return "success";
    }

    @RequestMapping(value = "handle03", params = {"username"})
    public String handle03() {
        return "success";
    }

}
