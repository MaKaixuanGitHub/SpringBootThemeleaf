package com.kuang.controller;

import com.kuang.mapper.DepartmentMapper;
import com.kuang.mapper.EmployeeMapper;
import com.kuang.model.Department;
import com.kuang.model.Employee;
import com.kuang.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

// Service省略直接跳到mapper
//    @Autowired
//    private EmployeeDao employeeDao;
//
//    @Autowired
//    private DepartmentDao departmentDao;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    /***
     * 查出所有员工信息
     * @param model
     * @return list
     */
    @RequestMapping("/emps")
    public String list(Model model) {
        List<EmployeePojo> employees = employeeMapper.getAllEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    /***
     * 查出所有部门信息
     * @param  model
     * @return add
     */
    @GetMapping("/emp")
    public String toAddpage(Model model) {
        List<Department> departments = departmentMapper.selectAll();
        model.addAttribute("departments", departments);

        return "emp/add";
    }


    /***
     * 追加一条信息
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addpage(Employee employee) {
        employeeMapper.insert(employee);
        return "redirect:/emps";
    }


    /***
     * 更新
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        Collection<Department> departments = departmentMapper.selectAll();
        model.addAttribute("departments", departments);
        model.addAttribute("employee", employee);
        return "emp/update";
    }

    /***
     *
     * @param employee
     * @return
     */
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
        return "redirect:/emps";
    }


    /***
     * 删除
     * @param id
     * @return emps
     */
    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
        return "redirect:/emps";
    }

}
