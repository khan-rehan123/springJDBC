package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//		JdbcTemplate temp = context.getBean("jdbcTemplate",JdbcTemplate.class);
		
		
		
		/* insert query */ 
		 String query="insert into student values(?,?,?)";
		
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		  Student student2 = new Student(); 
		  student2.setId(1234);
		  student2.setName("khan rehan khan");
		  student2.setCity("Thane"); 
		  int insert = studentDao.insert(student2);
		  System.out.println("insert student value" + insert);
		 
		
		// update query
		/*
		 * Student student2=new Student(); student2.setId(1234);
		 * student2.setName("md rehan"); student2.setCity("kanpur"); int result =
		 * studentDao.update(student2); System.out.println("data changed"+ result);
		 */
		
		/* delete query */
		/*
		 * int delete = studentDao.delete(1234);
		 * System.out.println("delete student value"+ delete);
		 */
		
		/* select student single data */
		/*
		 * Student student = studentDao.getStudent(456);
		 *	System.out.println("select single student value "+ student);
		 */
		
		/* get All student */
		List<Student> allStudent = studentDao.getAllStudent();
		for(Student s:allStudent) {
			System.out.println("get all student "+ s);
		}
	}
}
