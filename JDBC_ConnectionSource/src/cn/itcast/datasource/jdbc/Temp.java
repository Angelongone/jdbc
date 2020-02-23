package cn.itcast.datasource.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Temp {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stm = null;

        //加载配置文件
        Properties por = new Properties();
        InputStream is = Temp.class.getClassLoader().getResourceAsStream("druid.properties");
        por.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(por);
        //获取连接
        conn = ds.getConnection();
        stm = conn.createStatement();
        String sql = "select * from java";
//        ResultSet res = stm.executeQuery(sql);
//        while (res.next()){
//            String name = res.getString("name");
//            int age = res.getInt("age");
//            System.out.println(name + " | " + age);
//        }
        PreparedStatement prestm = conn.prepareStatement(sql);
//        prestm.setString(1,"java");
        ResultSet res = prestm.executeQuery();
        while (res.next()){
            String name = res.getString("name");
            int age = res.getInt("age");
            System.out.println(name + " | " + age);
        }
    }
}

