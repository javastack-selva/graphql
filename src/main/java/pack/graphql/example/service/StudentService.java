package pack.graphql.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.graphql.example.entity.Student;
import pack.graphql.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student addStudent(Student s) {
		return studentRepository.save(s);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> getStudentByDepartment(String department){
		return studentRepository.findByDepartment(department);
	}
}
