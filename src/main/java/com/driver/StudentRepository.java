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
    HashMap<String,HashSet<String>>teacherStudentDb=new HashMap<>();

    public void addStudent(Student student){
        String key=student.getName();
        studentDb.put(key,student);
    }

    public void addTeacher(Teacher teacher){
        String key=teacher.getName();
        teacherDb.put(key,teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName){
        HashSet<String >students=teacherStudentDb.get(teacherName);
        students.add(studentName);
        teacherStudentDb.put(teacherName,students);
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

        List<String>studentsist=new ArrayList<>();
        if(!(teacherStudentDb.containsKey(teacherName)))
            return studentsist;
        HashSet<String>students=teacherStudentDb.get(teacherName);


        for(String student:students){
            studentsist.add(student);
        }
        return studentsist;
    }
    public List<String> getAllStudents(){
        List<String>studentsList=new ArrayList<>();
        for (String studentName: studentDb.keySet()){
            studentsList.add(studentName);
        }
        return studentsList;
    }
    public void deleteTeacherByName(String teacherName){



            for(String student:teacherStudentDb.get(teacherName)){
                studentDb.remove(student);
            }
        teacherStudentDb.remove(teacherName);
        teacherDb.remove(teacherName);


    }
    public void deleteAllTeachers(){
       for(String teacherName:teacherDb.keySet()){
           for(String student:teacherStudentDb.get(teacherName)){
               studentDb.remove(student);
           }
           teacherStudentDb.remove(teacherName);
           teacherDb.remove(teacherName);
       }



    }


}
