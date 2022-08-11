package com.kuang.controller;


import com.kuang.mapper.DepartmentMapper;
import com.kuang.pojo.DepartmentPojo;
import com.kuang.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    /***
     * 查询所有部门
     * @param model
     * @return
     */
    @RequestMapping(value = "/depts", method = {RequestMethod.GET})
    public String list(Model model) {
        List<DepartmentPojo> dpartments = departmentMapper.getAllDepartments();
        model.addAttribute("depts", dpartments);
        return "dept/list";
    }

}
