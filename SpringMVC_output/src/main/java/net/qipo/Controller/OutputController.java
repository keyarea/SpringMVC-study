package net.qipo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * SpringMVC除了可以在方法上传入原声api request,reponse,session外 还能怎么样把数据带给页面
 *
 * 1, 可以在方法传入Map,或者Model或则好ModelMap.该这些参数里面保存的所有数据都会放在请求域中.可以在页面获取.
 *      Map,Model,ModelMap 都是BindingAwareModelMap在工作
 *      相当于给BindingAwareModelMap保存的东西都会被放在请求域中;
 *      Map(interface) Model(interface) ModelMap(class)
 * 2, 方法的返回值可以变为ModelAndView类型;
 *      既包含视图信息(页面地址)也包含模型信息(给页面带的数据);
 *      而且数据是放在请求域中的;
 *
 * 3, SpringMVC提供了一种可以临时该Session域中保存数据的方式;
 *      使用一个注解@SessionAttributes(只能标在类上)
 *      @SessionAttributes(value = "msg"): 给BindingAwareModelMap保存的数据同时给session放一份;
 *      value指定保存数据时要给session放的数据的key;
 *      types = {String.class}: 只要保存的是这种类型的数据,给session中放一份
 *
 * 后来推荐SessionAttributes就别用了,可能会发生异常;
 * 给session中放数据请使用原生api;
 */
@SessionAttributes(value = {"msg", "hahaha"}, types = {String.class})
@Controller
public class OutputController {

    @RequestMapping("/handle02")
    public String handle02(Map<String, Object> map) {
        map.put("msg", "你好");
        System.out.println("map的类型:" + map.getClass());
        return "success";
    }

    @RequestMapping("/handle03")
    public String handle03(Model model) {
        model.addAttribute("msg", "你好坏");
        System.out.println("model的类型:" + model.getClass());
        return "success";
    }

    @RequestMapping("/handle04")
    public String handle04(ModelMap modelMap) {
        modelMap.addAttribute("msg", "二傻子");
        System.out.println("modelmap的类型:" + modelMap.getClass());
        return "success";
    }

    /**
     * 返回值是ModelAndView,可以为页面携带数据
     * @return
     */
    @RequestMapping("/handle05")
    public ModelAndView handle05() {
        // 之前的返回值就叫视图名;试图名视图解析器是会帮我们最终拼串得到页面的真实地址;
//        ModelAndView mv = new ModelAndView("success");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("msg", "你好呀啊!");
        return mv;
    }
}
