package net.qipo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String handle01() {
        System.out.println("handle01...");
        return "success";
    }

    /**
     * SpringMVC如何获取带来的各种信息
     * 默认方式获取请求参数：
     *   直接给方法入参上写一个和请求参数名字相同的变量。这个变量就来接收请求参数的值；
     *   带了参数   就有值
     *   没带参数   就是null
     *
     * @RequestParam : 获取请求参数；
     *      @RequestParam("username")String username
     *      username = request.getParameter("username");
     *      默认这个参数是必须带的，
     *      value : 指定要获取的参数的key
     *      required : 这个参数是否是必须的
     *      defaultValue: 默认值，没带就是null
     *      与@PathVariable不同的是，这个是取的？后面的值，而不是路径中的值
     * @RequestHeader : 获取请求头中的某个key值
     *      以前获取： request.getHeader("User-Agent");
     *      如果请求头中没有这个key值，就会报错
     *      value:
     *      required:
     *      defaultValue:
     * @CookieValue : 获取某个cookie的值
     *      以前的操作： Cookie[] cookies = request.getCookies();
     *      for(Cookie c: cookies) {
     *          if(c.getName().equals(“”)){
     *              c.getValue();
     *          }
     *      }
     */
    @RequestMapping("handle02")
    public String handle02(@RequestParam("username")String username) {
        System.out.println("handle02..." + username);
        return "success";
    }


    /**
     *
     * @param userAgent
     */
    @RequestMapping("handle03")
    public String handle03(@RequestHeader("User-Agent")String userAgent) {
        System.out.println("handle03...User-Agent:" + userAgent);
        return "success";
    }

    public String handle04() {
        System.out.println("handle04...");
        return "success";
    }
}
