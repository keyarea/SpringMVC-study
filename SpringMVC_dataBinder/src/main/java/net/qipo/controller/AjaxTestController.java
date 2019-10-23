package net.qipo.controller;

import net.qipo.bean.Employee;
import net.qipo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

@Controller
public class AjaxTestController {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * SpringMVC下载一个文件
     * @return
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {
        // 1. 得到要下载的文件的流
        // 找到要下载文件的真实路径
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/assets/1.jpg");
        FileInputStream is = new FileInputStream(realPath);
        byte[] tmp = new byte[is.available()];
        is.read(tmp);
        is.close();

        // 将要下载的文件流返回
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition", "attachement;filename="+"1.jpg");
        return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
    }

    /**
     *  ResponseEntity<String>:响应体中内容的类型 自定义
     * @return
     */
    @RequestMapping("/test03")
    public ResponseEntity<String> test03() {
        String body = "<h1>success</h1>";
        HttpStatus statusCode = HttpStatus.OK  ;
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Set-Cookie", "username=hhhh");

        return new ResponseEntity<String>(body,  headers, statusCode);
    }

    /**
     * 将数据放在响应体中
     * @return
     */
    @ResponseBody
    @RequestMapping("/test02")
    public String test02() {
        return "<h1>success</h1>";
    }

    /**
     * 如果参数位置写 HttpEntity<String> str;
     * 比@RequestBody更加强大的是，可以拿到请求头；
     * @param str
     * @return
     */
    @RequestMapping("/test01")
    public String test01(HttpEntity<String> str) {
        System.out.println(str);
        return "success";
    }

    /**
     * @RequestBody: 请求体；获取一个请求的请求体；
     * @RequestParam: 可以获取请求中的值
     * @RequestBody Empolyee empolyee 会直接将body封装为对象
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("请求体：" + body);
        return "success";
    }

    /**
     * 将返回的数据放在响应体中；
     * 如果是对象，jackjson包自动的将对象转为json格式
     * @return
     */
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll() {
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }

}
