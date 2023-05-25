package com.panpan.sqlite;

import java.sql.*;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/5/23       create this file
 * </pre>
 */
public class SqliteDemo {

    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("drop table if exists user;");

        stat.executeUpdate("create table user (name, password);");
        PreparedStatement prep = conn.prepareStatement("insert into user values (?, ?);");

        prep.setString(1, "zhangsan");
        prep.setString(2, "1234");
        prep.addBatch();
        prep.setString(1, "lisi");
        prep.setString(2, "123456");
        prep.addBatch();
        prep.setString(1, "wangwu");
        prep.setString(2, "111111");
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);
        ResultSet rs = stat.executeQuery("select * from user;");
        while (rs.next()) {
            System.out.println("name = " + rs.getString("name"));
            System.out.println("password=" + rs.getString("password"));
        }
        rs.close();
        conn.close();
    }

}
