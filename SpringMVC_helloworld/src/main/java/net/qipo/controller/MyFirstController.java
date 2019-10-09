package net.qipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首先告诉springMVC这是一个处理器,可以处理请求
 * @Controller : 标识哪个组件是控制器
 *
 * 运行流程:
 * 	1. 客户端点击链接会发送http://localhost:8080/projectName/hello 请求
 * 	2. 来到tomcat服务器;
 * 	3. SpringMVC的前端控制器收到所有的请求;
 * 	4. 来看请求地址和@RequestMapping标注的哪个匹配,来找到到底使用哪个类的哪个方法来处理;
 * 	5. 前端控制器找到了目标处理类和目标方法,直接利用反射执行目标方法;
 * 	6. 方法执行之后会有一个返回值,SpringMVC认为这个返回值就是要去的页面地址;
 * 	7. 拿到方法返回值之后,用视图解析器进行拼串得到完整的页面地址;
 *  8. 拿到页面地址,前端控制器帮我们转发到页面;
 *
 * @RequestMapping: 告诉SpringMVC这个方法用来处理什么请求?
 *           这个/是可以省略的,即使省略了,也是默认从当前项目下开始的;
 *
 * 如果不指定配置文件位置?
 *     /WEB-INF/springDispatcherServlet-servlet.xml
 *     如果不指定,也会默认去找一个文件;
 *     /WEB-INF/xxx-servlet.xml   xxx: 就是配置的前端控制器的servlet-name
 *     就在web应用的WEB-INF下创建一个 名为 前端控制器名-servlet.xml
 *
 *
 * 处理*.jsp是tomcat做的事;所有项目的小web.xml都是继承于大的web.xml
 * DefaultServlet是Tomcat中处理静态资源的?
 *
 * 除了jsp和servlet外,剩下的都是静态资源;
 *
 * index.html是一个静态资源,tomcat就会在服务器下找到这个资源并返回;
 * 我们前端控制器的/禁用了tomcat中的DefaultServlet
 *
 * 	1. 服务器的web.xml中有个DefaultServlet是url-pattern=/
 * 	2. 我们的配置中前端控制器url-pattern也是/
 * 	静态资源会来到DispatcherServlet(前端控制器)看哪个方法的RequestMapping是这个
 * 	3. 为什么*.jsp又能够访问? 因为我们没有覆盖服务器中的JspServlet的配置
 *  4. /* 直接就是拦截所有的请求;  我们写/ 也是为了迎合后来的Rest风格的URL地址
 */
@Controller
public class MyFirstController {

    /**
     *  /代表从当前项目下开始,处理当前项目下的hello请求
     */
    @RequestMapping("/hello")
    public String myfirstRequest() {
        System.out.println("请求收到了,正在处理中...");

        // 视图解析器会自动拼串
        // <property name="prefix" value="/WEB-INF/pages/" />
        // <property name="suffix" value=".jsp"/>
        // (前缀)/WEB-INF/pages/ + 返回值 + (后缀).jsp
        return "success";
    }
}
