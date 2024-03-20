package com.udemy.studentproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.udemy.studentproject.bean.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class StudentController {
    

  //http://localhost:8080/student
  //we will get response in json format
    @GetMapping("student")

    //simple java method which returns student object

    public Student getStudent(){
        Student student =new Student(1, "priyanka", "Nomula");
        return student;
        }



   @GetMapping("students")  // http://localhost:8080/students 
       //it will return list of students in the format of json to client   
    public List<Student> getStudents()
    {
    List<Student> students =new ArrayList<>(); 
    students.add(new Student(1, "priyanka", "nomula"));
    students.add(new Student(2, "sridhar", "alapati"));
    students.add(new Student(3, "pinky", "ragidi"));

    return students;

    }


    //spring boot  Rest API with path variable

    //{id}-URI tempalte variable
    //http://localhost:8080/students/1
    @GetMapping("students/{id}") 
    //to bind template  variable with the method argument we need to use  @path variable
    
    public Student studentPathVariable(@PathVariable("id") int studentId){
    
        return new Student(studentId ,"sridhar", "alapati");
        
    }


    // spring boot rest api with id ,firstname,lastname
@GetMapping("students/{id}/{first-name}/{last-name}")
// http://localhost:8080//id/firstname//lastname

    public Student pathVariable(@PathVariable("id")  int studentId,
                                 @PathVariable("first-name") String firstName,
                                 @PathVariable("last-name") String lastName){
                                    
                                    
    return new Student(studentId, firstName, lastName);              
                                 
 }
 
    }



