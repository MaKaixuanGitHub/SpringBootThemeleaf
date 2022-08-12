package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
public class TestJDBC {
//    //注入数据源
//    @Autowired
//    DataSource dataSource;
//
//    @Test
//     public void contextLoads() throws SQLException {
//        //查看默认的数据源
//        System.out.println(dataSource.getClass());
//        //获得数据库连接
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        //关闭连接
//        connection.close();
//    }

    /***
     * String Security Test
     * @throws SQLException　SQLException
     */
    @Test
     public void contextLoads() throws SQLException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 密码加密
        String encode = passwordEncoder.encode("1234");

        // 比较密码
        boolean matches = passwordEncoder.matches("1234", encode);

        System.out.println("encode=====>" + encode);
        System.out.println("=====================");
        System.out.println("matches=====>" + matches);
    }
}
