package net.qipo.controller;

import net.qipo.bean.Department;
import net.qipo.bean.Employee;
import net.qipo.dao.DepartmentDao;
import net.qipo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;

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
    public String addEmp(Employee employee) {
        System.out.println("要添加的员工:" + employee);
        employeeDao.save(employee);
        // 返回列表页面
        return "redirect:/emps";
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

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id", required = false)Integer id, ModelMap modelMap) {
        if(id != null) {
            Employee employee = employeeDao.get(id);
            modelMap.addAttribute("employee", employee);
        }
    }

}
