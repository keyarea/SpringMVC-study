package net.qipo.controller;

import net.qipo.bean.Department;
import net.qipo.bean.Employee;
import net.qipo.dao.DepartmentDao;
import net.qipo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工
     * @return
     */
    @RequestMapping("/emps")
    public String gerEmps(ModelMap modelMap) {
        Collection<Employee> all = employeeDao.getAll();
        modelMap.addAttribute("emps", all);
        return "list";
    }

    @RequestMapping("/toaddpage")
    public String toAddPage(ModelMap modelMap) {
        Collection<Department> departments = departmentDao.getDepartments();
        modelMap.addAttribute("departments", departments);
//        modelMap.addAttribute("command", new Employee(null, "张三", "aa@163.com", 1, departmentDao.getDepartment(101)));
        modelMap.addAttribute("employee", new Employee());
        return "add";
    }


    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult bindingResult, ModelMap modelMap) {
        System.out.println("要添加的员工:" + employee);
        // 获取是否有校验错误
        boolean b = bindingResult.hasErrors();

        if (b) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String, Object> errorsMap = new HashMap<>();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("错误消息:" + fieldError.getDefaultMessage());
                System.out.println("错误的字段:" + fieldError.getField());
                System.out.println(fieldError);
                System.out.println("________________");
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            modelMap.addAttribute("errorInfo", errorsMap);
            System.out.println("有校验错误");
            return "add";
        }else{
            employeeDao.save(employee);
            // 返回列表页面
            return "redirect:/emps";
        }
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id, ModelMap modelMap) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        modelMap.addAttribute("departments", departments);
        modelMap.addAttribute("employee",employee);
        return "edit";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee) {
        System.out.println("要修改的员工: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id) {
        System.out.println("要删除的用户id" + id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    /**
     * 可以通过写一个自定义类型的转换器让其工作；
     * 步骤：
     *      ConversionService: 是一个接口；
     *          它里面有Converter（转换器）进行工作：
     *      1、实现Converter接口，写一个自定义的类型转换器；
     *      2、Converter是ConversionService中的组件；
     *          你的Converter得放进ConverterService中；
     *          将webDataBinder中的ConversionService设置成我们这个加了自定义类型装换器的ConversionService；
     *      3、配置出ConversionService；
     *
     * @param employee
     * @return
     */
    @RequestMapping("/quickadd")
    public String quickAdd(@RequestParam("empinfo") Employee employee) {
        System.out.println("封装" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id", required = false)Integer id, ModelMap modelMap) {
        if(id != null) {
            Employee employee = employeeDao.get(id);
            modelMap.addAttribute("employee", employee);
        }
    }



}
