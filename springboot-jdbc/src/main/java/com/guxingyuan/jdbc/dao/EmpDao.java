package com.guxingyuan.jdbc.dao;

import com.guxingyuan.jdbc.domain.Emp;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/8/25       create this file
 * </pre>
 */
@Component
public class EmpDao {

    @Resource
    private JdbcTemplateDao jdbcTemplateDao;

    public List<Emp> listAllEmp() {
        return jdbcTemplateDao.listObjects(Emp.class, "Select * from guxingyuan.emp");
    }


}
