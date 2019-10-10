package net.qipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模糊匹配功能
 *
 * URL可以写模糊的通配符
 *  ？ : 能替代任意一个字符
 *  *  ： 能替代任意多个字符，和一层路径
 *  ** : 能替代多层路径呢
 */

@Controller
public class RequestMappingMatchTestController {

    @RequestMapping(value = "antTest01")
    public String antTest01() {
        System.out.println("antTest01...");
        return "success";
    }

    /**
     * ? : 匹配一个字符，0个或者多个都不行
     *    模糊和精确多个匹配下，精确优先
     * @return
     */
    @RequestMapping(value = "antTest0?")
    public String antTest02() {
        System.out.println("antTest02...");
        return "success";
    }

    /**
     * *: 匹配任意多个字符
     * @return
     */
    @RequestMapping(value = "antTest0*")
    public String antTest03() {
        System.out.println("antTest03...");
        return "success";
    }

    /**
     * *： 也可以匹配一层路径
     * @return
     */
    @RequestMapping(value = "/*/antTest04")
    public String antTest04() {
        System.out.println("antTest04...");
        return "success";
    }

    /**
     * **: 匹配任意多层路径
     * @return
     */
    @RequestMapping(value = "/**/antTest04")
    public String antTest05() {
        System.out.println("antTest05...");
        return "success";
    }

    /**
     * 路径上可以由占位符, 占位符的语法就是可以在任意路径的地方写一个｛变量名｝
     *
     * 注意： 路径上的占位符也只能占一层路径
     * @return
     */
    @RequestMapping(value = "user/{id}")
    public String pathVariableTest(@PathVariable("id")String id) {
        System.out.println("路径上占位符的值" + id);
        return "success";
    }
}
