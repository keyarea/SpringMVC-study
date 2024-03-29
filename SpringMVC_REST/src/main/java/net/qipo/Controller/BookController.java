package net.qipo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {


    @RequestMapping(value = "book/{id}", method = RequestMethod.POST)
    public String addBook(@PathVariable("id")String id) {

        System.out.println("添加了"+ id +"号图书");

        return "success";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id")String id) {
        System.out.println("删除了"+ id +"号图书");

        return "success";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id")String id) {
        System.out.println("修改了"+ id +"号图书");

        return "success";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable("id")String id) {
        System.out.println("查询到了"+ id +"号图书");
        return "success";
    }
}
