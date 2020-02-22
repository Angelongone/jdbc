package cn.itcast.datasource.jdbctemplate;

import cn.itcast.datasource.druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo2 {
    public static void main(String[] args){
        //1.获取JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update temp set age = 20 where name = ?";
        int java = template.update(sql, "java");
        System.out.println(java);
    }
}
