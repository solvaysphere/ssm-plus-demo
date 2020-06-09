package com.solvay.ssm;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class ApplicationTest {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testEnvironment() throws Exception {
        DataSource ds = applicationContext.getBean("dataSource", DataSource.class);
        Connection con = ds.getConnection();
        System.out.println(con);
    }
}
