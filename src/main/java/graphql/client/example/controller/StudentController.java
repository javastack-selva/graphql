package graphql.client.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import graphql.client.example.model.Student;
import graphql.client.example.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/student/{department}")
	public List<Student> getStudentByDepartment(@PathVariable("department") String department) {
		return studentService.getStudentByDepartment(department);
	}

}
