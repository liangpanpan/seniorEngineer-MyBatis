package com.guxingyuan.boot.service.impl;

import com.guxingyuan.boot.mapper.EmpMapper;
import com.guxingyuan.boot.pojo.Emp;
import com.guxingyuan.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp selectEmp(Integer id) {
        return empMapper.selectEmp(id);
    }

    @Override
    public List<Emp> selectEmpByName(String userName) {
        return empMapper.selectEmpByName(userName);
    }

    @Override
    public Integer insertEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public Integer updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public Integer deleteEmp(Emp emp) {
        return empMapper.deleteEmp(emp);
    }
}
