package com.kuang.service;

import com.kuang.model.Employee;
import com.kuang.pojo.EmployeePojo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeDao {

    List<EmployeePojo> getAllEmployee();

    int insert(Employee employee);

    Employee selectByPrimaryKey(int id);

    int updateByPrimaryKey(Employee employee);

    int deleteByPrimaryKey(int id);
}
