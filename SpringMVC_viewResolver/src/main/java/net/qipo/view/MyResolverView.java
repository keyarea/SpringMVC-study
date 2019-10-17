package net.qipo.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.lang.annotation.Annotation;
import java.util.Locale;

public class MyResolverView implements ViewResolver, Ordered {
    private Integer order = 0;

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
       if(viewName.startsWith("mv:")) {
           // 根据视图名返回视图对象
           return new MyView();
       }else{
           // 如果不能处理返回null
           return null;
       }
    }

    /**
     *
     * @return
     */
    @Override
    public int getOrder() {
        return order;
    }

    /**
     * 改变视图解析器的优先顺讯
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
}
