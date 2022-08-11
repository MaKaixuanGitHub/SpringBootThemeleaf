package com.kuang.service;

import com.kuang.mapper.EmployeeMapper;
import com.kuang.model.Employee;
import com.kuang.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeePojo> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public Employee selectByPrimaryKey(int id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public int updateByPrimaryKey(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }
}
