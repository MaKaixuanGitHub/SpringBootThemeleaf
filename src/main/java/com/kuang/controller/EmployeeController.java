package com.kuang.controller;

import com.kuang.mapper.DepartmentMapper;
import com.kuang.mapper.EmployeeMapper;
import com.kuang.model.Department;
import com.kuang.model.Employee;
import com.kuang.pojo.EmployeePojo;
import com.kuang.service.DepartmentDao;
import com.kuang.service.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    /***
     * 查出所有员工信息
     * @param model
     * @return list
     */
    @RequestMapping(value = "/emps", method = {RequestMethod.GET})
    public String list(Model model) {
        List<EmployeePojo> employees = employeeDao.getAllEmployee();
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
        Collection<Department> departments = departmentDao.selectAll();
        model.addAttribute("departments", departments);

        return "emp/add";
    }


    /***
     * 追加一条信息
     * @param employee
     * @return
     */
    // PostMapping
    @RequestMapping(value = "/emp", method = {RequestMethod.POST})
    public String addpage(Employee employee) {
        employeeDao.insert(employee);
        return "redirect:/emps";
    }


    /***
     * 更新
     * @param id
     * @param model
     * @return
     */
//    @GetMapping("/emp/{id}")
    @RequestMapping(value = "/emp/{id}", method = {RequestMethod.GET})
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.selectByPrimaryKey(id);
        Collection<Department> departments = departmentDao.selectAll();
        model.addAttribute("departments", departments);
        model.addAttribute("employee", employee);
        return "emp/update";
    }

    /***
     * 更新一条数据
     * @param employee
     * @return
     */
//    @PostMapping("/updateEmp")
    @RequestMapping(value = "/updateEmp", method = {RequestMethod.POST})
    public String updateEmp(Employee employee) {
        employeeDao.updateByPrimaryKey(employee);
        return "redirect:/emps";
    }


    /***
     * 删除一条数据
     * @param id
     * @return emps
     */
//    @GetMapping("/delEmp/{id}")
    @RequestMapping(value = "/delEmp/{id}", method = {RequestMethod.GET})
    public String delEmp(@PathVariable("id") Integer id) {
        employeeDao.deleteByPrimaryKey(id);
        return "redirect:/emps";
    }
}
