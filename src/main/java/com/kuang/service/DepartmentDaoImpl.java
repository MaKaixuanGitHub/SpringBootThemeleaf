package com.kuang.service;

import com.kuang.mapper.DepartmentMapper;
import com.kuang.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentDaoImpl implements DepartmentDao{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Collection<Department> selectAll() {
        return departmentMapper.selectAll();
    }
}
