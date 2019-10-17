package net.qipo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义视图解析器
 */
@Controller
public class MyViewResolverController {

    @RequestMapping("/handleplus")
    public String handle(ModelMap modelMap) {
        List<String> vname = new ArrayList<>();
        List<String> imgname = new ArrayList<>();
        vname.add("童老师");
        vname.add("飞哥");

        imgname.add("萌萌");
        modelMap.addAttribute("video", vname);
        modelMap.addAttribute("imgs", imgname);
        return "mv:/hd";
    }
}
