package com.guxingyuan.jdbc.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.guxingyuan.jdbc.domain.Emp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/8/25       create this file
 * </pre>
 */
@SpringBootTest
public class JdbcTemplateDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateDaoTest.class);

    @Resource
    private DataSource dataSource;

    @Resource
    private JdbcTemplateDao jdbcTemplateDao;

    @Resource
    private EmpDao empDao;

    @Test
    void contextLoads() throws SQLException {
        //看一下默认数据源
        logger.info(dataSource.getClass().getName());
        //获得连接
        Connection connection = dataSource.getConnection();
        logger.info(connection.toString());
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        logger.info("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        logger.info("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }
    

    @Test
    void testJdbcTemplateDao() {
        Assertions.assertNotNull(jdbcTemplateDao);
    }

    @Test
    void testListAllEmp() {
        List<Emp> empList = empDao.listAllEmp();
        empList.stream().forEach(emp -> logger.info(emp.toString()));
    }

    
}
