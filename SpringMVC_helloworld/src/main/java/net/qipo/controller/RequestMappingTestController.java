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
     * headers: 规定请求头，也和params一样能写简单的表达式
     * consumes: 只接受内容类型为哪种的请求，规定请求头中的Content-Type
     * produces: 告诉浏览器返回的内容是什么，给响应头中加上Content-Type
     */
    @RequestMapping(value = "handle02",method = RequestMethod.POST)
    public String handle02() {
        return "success";
    }

    /**
     * params: 规定请求参数
     * 	params支持简单的表达式;
     * 	param1: 表示请求必须包含名为param1的请求参数;
     * 	!param1: 表示请求不能包含名为param1的请求参数;
     * 	param1 != value1: 表示请求包含名为param1的请求参数,但是其值不能为value1;
     * {"param1=value1", "param2"}: 请求必须包含名为param1和param2的
     *
     * eg: params = {"username"}    发送请求的时候必须带上一个名为username的参数，没带的都会404
     * eg：params = {"!username"}    发送请求的时候必须不携带一个名为username的参数，带的都会404
     * eg：params = {"username!=123"} 发送请求的时候，携带的username的值必须不是123（不带username或者值不是123）
     * eg: params = {"username!=123", "pwd", "!age"} 请求参数必须满足以上规则，请求的username不能是123，必须有pwd的值，不能有age
     */
    @RequestMapping(value = "handle03", params = {"username"})
    public String handle03() {
        return "success";
    }

    /**
     * headers: 规定请求头，也和params一样能写简单的表达式
     * User-Agent： 浏览器信息；
     * 限制User-Agent的值，让特定浏览器可以访问；
     * 谷歌浏览器：
     *   User-Agent: Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Mobile Safari/537.36
     * Edge浏览器：
     *
     User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763
     */
    @RequestMapping(value = "handle04", headers = "User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763")
    public String handle04() {
        return "success";
    }

}
