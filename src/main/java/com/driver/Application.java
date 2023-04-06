package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		Student student1=new Student("anish",16,45.0);
//		Student student2=new Student("manu",18,56.0);
//		Student student3=new Student("ankit",20,59.0);
//		Student student4=new Student("aman",22,78.0);
//
//		StudentController studentController=new StudentController();
//		System.out.println(studentController.addStudent(student1));
//		studentController.addStudent(student2);
//		studentController.addStudent(student3);
//		studentController.addStudent(student4);
//
//		Teacher teacher1=new Teacher("amir",2,30);
//		Teacher teacher2=new Teacher("arvind",2,35);
//
//		System.out.println(studentController.addTeacher(teacher1));
//		studentController.addTeacher(teacher2);
//
//		System.out.println(studentController.addStudentTeacherPair("anish","amir"));
//		studentController.addStudentTeacherPair("manu","amir");
//		studentController.addStudentTeacherPair("ankit","arvind");
//		studentController.addStudentTeacherPair("aman","arvind");

//		List<String>students=studentController.getStudentsByTeacherName("amir");
//		System.out.println(students.toString());



	}
}
