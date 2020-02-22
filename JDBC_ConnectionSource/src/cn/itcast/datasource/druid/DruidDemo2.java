package cn.itcast.datasource.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args){
        /**
         * 调用JDBCUtils工具类，完成添加操作：给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into temp values(?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,"Angleong");
            pstmt.setInt(2,21);
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }
    }
}
