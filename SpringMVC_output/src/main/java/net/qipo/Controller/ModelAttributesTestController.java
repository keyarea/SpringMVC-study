package net.qipo.Controller;

import bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试ModelAttributes注解；
 * 使用场景，修改图书为例；
 *
 * 实际场景：
 * 并不是全字段修改；只会修改部分字段；
 * 1、不修改的字段可以在页面进行展示，但是不要提供修改输入框；
 * 2、为了简单，Controller直接在参数位置来写Book对象；
 * 3、SpringMVC为我们自动封装book；（没有带的就是null值）；
 * 4、如果接下来调用了一个全字段更新的dao操作；会将其他的字段可能变为null；
 *
 * 如何能保证全字段更新的时候，只更新页面携带的数据？
 * 1、修改Dao，代价大？
 * 2、Book对象是如何封装的？
 *      SpringMVC创建一个对象,每个属性都有默认值，bookName就是null
 *          先让SpringMVC别创建book对象，直接从数据库中先取出一个id=100的book对象信息
 *      将请求中的所有与book一一对应的属性一一设置过来；
 *          使用从数据库中取出的对象，给它的对象设置值；请求参数带了哪些值就覆盖哪些值；
 *          带了的字段就改为携带的值，没带的字段就保持之前的值。
 *      调用全字段更新就有问题；
 *          将之前从数据库中查到的对象，并且封装了请求参数的对象，进行保存；
 *
 */
@Controller
public class ModelAttributesTestController {

    /**
     * 可以告诉SpringMVC不要new这个book了，我刚才保存了一个
     * 那个就是从数据库中查询出来的
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(@ModelAttribute("book")Book book) {
        System.out.println("页面提交过来的书的数据信息： " + book);
        // bookDao.update(book);
        return "success";
    }

    /**
     * 1、SpringMVC要封装请求参数的Book对象不应该谁自己new出来的。
     *      而应该是从数据库中拿到的准备好的值。
     * 2、再来使用这个对象来封装请求参数；
     *
     * @ModelAttributes:
     *      参数： 取出刚才保存的数据
     *      方法位置：这个方法就会提前于目标方法运行；
     *          我们可以提前查出这个数据库中的图书的信息
     *          将这个图书信息保存起来，方便下一个方法还能使用
     *
     * @ModelAttribute 标注的方法会提前运行并把运行结果放在隐含模型中；(返回值)
     * 	放的时候会使用一个key
     * 		如果@ModelAttribute("book")指定了，就用指定的book；
     *      如果没指定就用返回值类型的首字母小写作为可以；
     */
//    @ModelAttribute
//    public void MyModelAttribute(ModelMap modelMap) {
//        Book book = new Book(100, "西游记", "王五", 12, 12, 19.98);
//        System.out.println("数据库中查到的数据信息: " + book);
//        modelMap.addAttribute("book",book);
//        System.out.println("ModelAttribute查询了图书并保存起来了, modelMap是:" + modelMap.getClass());
//    }


    /**
     * 一般使用将对象保存在ModelMap中，而不是作为一个返回值
     * @return
     */
    @ModelAttribute
    public Book MyModelAttribute() {
        Book book = new Book(100, "西游记", "王五", 12, 12, 19.98);
        System.out.println("数据库中查到的数据信息: " + book);
        return book;
    }
}
