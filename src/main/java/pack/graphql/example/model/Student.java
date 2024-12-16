package pack.graphql.example.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Student(Integer rollno, String name, String department, Integer mark) {

	public static List<Student> studentList = Arrays.asList(
			new Student(1,"Selva","EEE",78),
			new Student(2,"Ram","EEE",79),
			new Student(3,"Sasi","EEE",80));

	public static List<Student> getStudentByDepartment(String department2) {
		return studentList.stream().filter(s -> s.department.equals(department2)).collect(Collectors.toList());
	}
			
}
