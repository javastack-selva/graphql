package pack.graphql.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pack.graphql.example.entity.Student;
import pack.graphql.example.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@MutationMapping
	public Student addStudent(@Argument Integer rollno, @Argument String name,@Argument String department,@Argument Integer mark){
		Student student = new Student(rollno, name, department, mark);
		return studentService.addStudent(student);
	}
	
	
	@MutationMapping
	public Student addOneStudent(@Argument Student student){		
		return studentService.addStudent(student);
	}
	
	@QueryMapping
	public List<Student> getAllStudent(){
		return studentService.getAllStudents();
		
	}
	
	@QueryMapping
	public List<Student>  getStudentByDepartment(@Argument String department){
		return studentService.getStudentByDepartment(department);		
	}
}
