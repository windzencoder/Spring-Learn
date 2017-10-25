package com.wz.spring.jdbc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private EmployeeDao employeeDao;
	private DepatmentDao depatmentDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeeDao = ctx.getBean(EmployeeDao.class);
		depatmentDao = ctx.getBean(DepatmentDao.class);
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	
	@Test
	public void testNameParameterJdbcTemplate2() {
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:lastName, :email, :deptId)";
		//对象
		Employee employee = new Employee();
		employee.setLastName("XYZ");
		employee.setEmail("xyz@sina.com");
		employee.setDeptId(3);
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, parameterSource);
	}
	
	
	@Test
	public void testNameParameterJdbcTemplate() {
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:ln, :email, :deptid)";
		java.util.Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ln", "FF");
		paramMap.put("email", "ff@123.com");
		paramMap.put("deptid", 2);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testDepatmentDao(){
		System.out.println(depatmentDao.get(1));
	}
	
	
	@Test
	public void testEmployeeDao(){
		System.out.println(employeeDao.get(1));
	}
	
	@Test
	public void testQueryForObject2() {
		String sql = "select count(id) from employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	@Test
	public void testQueryForList() {
		String sql = "SELECT id, last_name lastName, email  from employees where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 5);
		System.out.println(employees);
	}
	
	
	@Test
	public void testQueryForObject() {
		String sql = "SELECT id, last_name lastName, email , dept_id as \"department.id\" from employees where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
		
	}
	
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(?, ?, ?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"AA", "aa@123.com", 1});
		batchArgs.add(new Object[]{"BB", "bb@123.com", 2});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	@Test
	public void testUpdate(){
		String sql = "UPDATE employees set last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "Jack", 5);
	}
	
	
	@Test
	public void testDataSource(){
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getClass().getName());
	}
}
