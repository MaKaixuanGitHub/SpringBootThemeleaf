package com.kuang.mapper;

import com.kuang.model.Department;
import com.kuang.pojo.DepartmentPojo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DepartmentMapper extends Mapper<Department> {

    List<DepartmentPojo> getAllDepartments();
}