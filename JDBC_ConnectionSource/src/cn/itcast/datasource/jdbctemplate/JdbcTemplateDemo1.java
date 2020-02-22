package cn.itcast.datasource.jdbctemplate;

import cn.itcast.datasource.druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate快速入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args){
        //1.导入jar包
        //2.创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update temp set age = 40 where name = ?";
        int java = template.update(sql, "java");
        System.out.println(java);
    }
}
