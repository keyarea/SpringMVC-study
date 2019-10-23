package net.qipo.controller;

import net.qipo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    public BookController(){
        System.out.println("bookController");
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(bookService);
        return "success";
    }
}
