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
public class MybatisTest {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            Emp emp = (Emp) session.selectOne("com.guxingyuan.pojo.EmpMapper" +
                    ".selectEmp", 1);
            System.out.println(emp);
        }
    }

    @Test
    public void test02() {

        try (SqlSession session = sqlSessionFactory.openSession()) {

            Emp emp = session.getMapper(EmpMapper.class).selectEmp(1);
            System.out.println(emp);

        }
    }

}
