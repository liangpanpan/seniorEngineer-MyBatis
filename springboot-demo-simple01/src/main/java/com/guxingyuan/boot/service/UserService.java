package com.guxingyuan.boot.service;

import com.guxingyuan.boot.pojo.Emp;

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
public interface UserService {
    Emp selectEmp(Integer id);

    List<Emp> selectEmpByName(String userName);

    Integer insertEmp(Emp emp);

    Integer updateEmp(Emp emp);

    Integer deleteEmp(Emp emp);
}
