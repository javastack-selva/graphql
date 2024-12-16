package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@MutationMapping
	public Student addStudent(@Argument Student student) {
		return studentService.addStudent(student);
	}
	
	@MutationMapping
	public Student addStudentByParam(@Argument Integer rollno,@Argument String name, @Argument String department, @Argument Integer mark) {
		Student s = new Student(rollno, name, department, mark);
		return studentService.addStudent(s);
	}
	
	@MutationMapping
	public Student updateStudent(@Argument Student student) {
		return studentService.addStudent(student);
	}
	
	@QueryMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudent();
	}
	
	@QueryMapping
	public List<Student> getStudentByDepartment(@Argument String department){
		return studentService.findStudentByDepartment(department);
	}

}
