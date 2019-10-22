package net.qipo.component;

import net.qipo.bean.Department;
import net.qipo.bean.Employee;
import net.qipo.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 两个泛型
 *
 * S:source
 * T：target
 */
public class MyStringToEmployeeConverter implements Converter<String, Employee> {
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 自定义的转换规则
     * @param source
     * @return
     */
    @Override
    public Employee convert(String source) {
        System.out.println("页面提交的将要转换的字符串" + source);
        Employee employee = new Employee();
        if(source.contains("-")) {
            String[] split = source.split("-");
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
        }
        return employee;
    }
}
