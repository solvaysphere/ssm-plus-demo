package com.solvay.ssm.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.solvay.ssm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testSelectEmps() {
        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>().lambda()
                .eq(Employee::getGender, 1));
        employees.stream().forEach(System.out::println);

    }

    @Test
    public void testPageEmps() {
        Page<Employee> page = employeeMapper.selectPage(new Page<Employee>(2, 3), new QueryWrapper<Employee>().lambda()
                .eq(Employee::getGender, 1));
        System.out.println(page);
        page.getRecords().stream().forEach(System.out::println);
    }
}
