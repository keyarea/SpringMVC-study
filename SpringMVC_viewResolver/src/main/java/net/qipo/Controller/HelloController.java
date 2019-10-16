package net.qipo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        // return "hello";  只会找到/WEB-INF/pages/hello.jsp
        // 但是我有一个页面在webapp文件夹下,如何返回?
        // 可以使用相对路径的方式
       return "../../hello" ;
    }

    /**
     * forward:/hello.jsp 转发到一个页面
     * /hello.jsp  : 转发到当前项目的hello.jsp页面
     * 一定要加上/,不加/就是相对路径,容易出问题
     * forward前缀的转发,不会由我们配置的视图解析器拼串
     *
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(){
       return "forward:/hello.jsp";
    }

    @RequestMapping("/handle02")
    public String handle02() {
       return "forward:/handle01" ;
    }

    /**
     * 重定向至hello.jsp页面
     * 有前缀的转发和重定向操作,配置的视图解析器就不会进行拼串操作
     * 重定向 redirect:重定向的路径
     *      /hello.jsp : 代表就是从当前项目下开始,SpringMVC会自动的为路径添加上项目名.
     *
     *      原生的servlet重定向需要加项目名字
     *      response.sendRedirect("/hello.jsp");
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03() {
        return "redirect:/hello.jsp";
    }

    /**
     * 多次重定向
     */
    @RequestMapping("/handle04")
    public String handle04() {
       return "redirect:/handle03" ;
    }
}
