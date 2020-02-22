package cn.itcast.datasource.jdbc;

import java.sql.*;

public class jdbc {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pre = null;

        //获取连接对象
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","angelong");
            String sql = "insert into temp(name,age) values(?,?)";
            pre = conn.prepareStatement(sql);
//            pre.setString(1,"name");
//            pre.setString(2,"age");
            pre.setString(1,"YangTao");
            pre.setString(2,"18");
            pre.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pre != null){
                try {
                    pre.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
