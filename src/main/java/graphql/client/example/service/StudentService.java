package graphql.client.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

import graphql.client.example.model.Student;

@Service
public class StudentService {
	
	@Autowired
	HttpGraphQlClient graphQlClient;
	
	public List<Student> getAllStudent(){
		String document = """
				query GetAllStudents {
						getAllStudents {
							rollno
							name
							department
							mark
						}
					}
				""";		
		List<Student>  studentList = graphQlClient.document(document)
		.retrieve("getAllStudents")
		.toEntityList(Student.class).block();
				
		return studentList;
	}
	
	public List<Student> getStudentByDepartment(String department){
		String document = String.format("""
				query GetStudentByDepartment {
						getStudentByDepartment(department: "%s") {
								rollno
								name
						}
					}
				""",department);		
		List<Student>  studentList = graphQlClient.document(document)
		.retrieve("getStudentByDepartment")
		.toEntityList(Student.class).block();
				
		return studentList;
	}
	
	public Student addStudent(Student student){
		String document = String.format("mutation AddStudentByParam {\r\n"
				+ "    addStudentByParam(rollno: \"%d\", name: \"%s\", department: \"%s\", mark: %d) {\r\n"
				+ "        rollno\r\n"
				+ "        name\r\n"
				+ "        department\r\n"
				+ "        mark\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "",student.getRollno(), student.getName(), student.getDepartment(), student.getMark());	
		Student s = graphQlClient.document(document)
		.retrieve("addStudentByParam")
		.toEntity(Student.class).block();
				
		return s;
	}

}
