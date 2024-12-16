package pack.graphql.example.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import pack.graphql.example.model.Student;

@Controller
public class StudentController {
	
	@QueryMapping
	public List<Student> getAllStudents(){
		return Student.studentList;
	}
	
	@QueryMapping
	public List<Student> getStudentByDepartment(@Argument String department){
		return Student.getStudentByDepartment(department);
	}

}
