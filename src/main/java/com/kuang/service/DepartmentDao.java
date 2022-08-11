package com.kuang.service;

import com.kuang.model.Department;

import java.util.Collection;


public interface DepartmentDao {

    // 查询所有部门
    Collection<Department> selectAll();
}
