package com.guxingyuan.mapper;

import com.guxingyuan.pojo.Emp;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/10/28       create this file
 * </pre>
 */
public interface EmpMapper {

    Emp selectEmp(Integer id);

    Integer insertEmp(Emp emp);

    Integer updateEmp(Emp emp);

    Integer deleteEmp(Emp emp);
}
