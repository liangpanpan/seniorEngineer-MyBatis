package com.guxingyuan.boot.controller;

import com.guxingyuan.boot.pojo.Emp;
import com.guxingyuan.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/9       create this file
 * </pre>
 */
@RestController
@RequestMapping(value = "/mybatis")
public class MyBatisController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/selectEmp")
    public Emp selectEmp(@RequestParam Integer id) {
        return userService.selectEmp(id);
    }

    @PostMapping(value = "/insertEmp")
    public List<Emp> insertEmp(@RequestBody Emp emp) {
        int result = userService.insertEmp(emp);
        if (result != 1) {
            throw new RuntimeException("插入数据“" + emp.getUserName() + "”失败");
        }
        return userService.selectEmpByName(emp.getUserName());
    }

    @PostMapping(value = "/updateEmp")
    public Emp updateEmp(@RequestBody Emp emp) {
        int result = userService.updateEmp(emp);
        if (result != 1) {
            throw new RuntimeException("修改数据id:" + emp.getId() + " userName:" + emp.getUserName() + "失败");
        }
        return userService.selectEmp(emp.getId());
    }

    @PostMapping(value = "/deleteEmp")
    public Integer deleteEmp(@RequestBody Emp emp) {
        return userService.deleteEmp(emp);
    }

}
