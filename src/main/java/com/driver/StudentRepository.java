package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class StudentRepository {
    HashMap<String,Student> studentDb= new HashMap<>();
    HashMap<String,Teacher> teacherDb=new HashMap<>();
    HashMap<String,HashSet<Student>>teacherStudentDb=new HashMap<>();

    public void addStudent(Student student){
        String key=student.getName();
        studentDb.put(key,student);
    }

    public void addTeacher(Teacher teacher){
        String key=teacher.getName();
        teacherDb.put(key,teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName){
        if(!(studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName)))
            return;

        Student student=studentDb.get(studentName);
        if(!(teacherStudentDb.containsKey(teacherName))){
            Teacher teacher=teacherDb.get(teacherName);
            HashSet<Student>studentList=new HashSet<>();
            studentList.add(student);
            teacherStudentDb.put(teacherName,studentList);
            return;
        }
        HashSet<Student>studentList=teacherStudentDb.get(teacherName);
        studentList.add(student);
    }

    public Student getStudentByName(String name){
        Student student=studentDb.get(name);
        return student;
    }
    public Teacher getTeacherByName(String name){
        Teacher teacher=teacherDb.get(name);
        return teacher;
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        HashSet<Student>students=teacherStudentDb.get(teacherName);

        List<String>studentsist=new ArrayList<>();
        for(Student student:students){
            studentsist.add(student.getName());
        }
        return studentsist;
    }
    public List<String> getAllStudents(){
        List<String>studentsList=new ArrayList<>();
        for (Student student: studentDb.values()){
            studentsList.add(student.getName());
        }
        return studentsList;
    }
    public void deleteTeacherByName(String teacherName){
        teacherDb.remove(teacherName);
        teacherStudentDb.remove(teacherName);
    }
    public void deleteAllTeachers(){
        teacherDb.clear();
        teacherStudentDb.clear();
    }


}
