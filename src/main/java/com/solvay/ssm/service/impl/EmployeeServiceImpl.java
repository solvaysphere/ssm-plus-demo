package com.solvay.ssm.service.impl;

import com.solvay.ssm.entity.Employee;
import com.solvay.ssm.dao.EmployeeMapper;
import com.solvay.ssm.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Solvay
 * @since 2020-06-09
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
