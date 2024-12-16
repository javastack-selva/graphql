package graphql.client.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(value = Include.NON_DEFAULT)
public class Student {
	private Integer rollno;
	private String name;
	private String department;
	private Integer mark;
}
