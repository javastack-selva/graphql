package pack.graphql.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.graphql.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByDepartment(String department);

}
