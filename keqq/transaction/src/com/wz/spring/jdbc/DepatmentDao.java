package com.wz.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DepatmentDao extends JdbcDaoSupport{

	@Autowired
	public void setDataSource2(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public Department get(Integer id) {
		String sql = "select id, dept_name name from departments where id = ?";
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
		Department department = getJdbcTemplate().queryForObject(sql, rowMapper, id);
		return department;
	}
	
}
