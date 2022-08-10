package com.kuang.mapper;

import com.kuang.model.Employee;
import com.kuang.pojo.EmployeePojo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {

    // 查询所有员工信息
    List<EmployeePojo> getAllEmployee();
}