package com.guxingyuan.tests;

import com.guxingyuan.mapper.EmpMapper;
import com.guxingyuan.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/10/28       create this file
 * </pre>
 */
public class MybatisCRUD {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void select() {
        SqlSession session = sqlSessionFactory.openSession();
        Emp emp = session.getMapper(EmpMapper.class).selectEmp(1);
        System.out.println(emp);

    }

    @Test
    public void insert() {
        SqlSession session = sqlSessionFactory.openSession();
        Emp emp = new Emp();
        emp.setUserName("hello 张三");

        Integer result = session.getMapper(EmpMapper.class).insertEmp(emp);
        System.out.println(result);

        session.commit();
    }

    @Test
    public void update() {
        SqlSession session = sqlSessionFactory.openSession();
        Emp emp = new Emp();
        emp.setUserName("hello mybatis update");
        emp.setId(3);

        Integer result = session.getMapper(EmpMapper.class).updateEmp(emp);
        System.out.println(result);

        session.commit();
    }

    @Test
    public void delete() {
        SqlSession session = sqlSessionFactory.openSession();
        Emp emp = new Emp();
        emp.setUserName("hello mybatis update");
        emp.setId(4);

        Integer result = session.getMapper(EmpMapper.class).deleteEmp(emp);
        System.out.println("delete:" + result);

        session.commit();
    }

}
