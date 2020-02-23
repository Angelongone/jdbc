package cn.itcast.datasource.jdbctemplate;

import cn.itcast.datasource.druid.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    public static void main(String[] args){
       /* //1.获取JdbcTemplate对象
        JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
        //2.SQL语句
        String sql = "insert into java values(?,?)";
        //执行SQL语句
        jdbc.update(sql,"javascript",31);*/

       /*//删除一条记录
        JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from java where name = ?";
        jdbc.update(sql,"java");
        */

      /* //查询name为python的记录，将其封装为Map集合
        JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from java where name = ?";
        Map<String, Object> python = jdbc.queryForMap(sql, "python");
        System.out.println(python);*/

      /*//查询所有记录，将其封装为list集合。
        JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from java";
        List<Map<String, Object>> maps = jdbc.queryForList(sql);
        System.out.println(maps);*/

     /* JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
      String sql = "select * from java";
      jdbc.query(sql,new BeanPropertyRowMappertem<Emp>(Emp.class));*/


     //查询总记录数
        JdbcTemplate jdbc = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(*) from java";
        Long total = jdbc.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
