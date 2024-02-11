package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		// insert query
		String query = "insert into student values(?,?,?)";
		int update = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return update;
	}

	// updating student value
	public int update(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int up = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return up;
	}

//	Delete Opetation 	
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int delete = this.jdbcTemplate.update(query, studentId);
		return delete;
	}

	// get single student value
	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	// get All Student value

	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
