package com.udemy.studentproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.udemy.studentproject.bean.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






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
    //to bind  URI template  variable with the method argument we need to use  @path variable
    
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


 //Spring boot rest api with Request param(map to query parameters)
 //(to extract query paramater value in request url)
 
//http://localhost:8080/students/query?id=1&firstName=priyanka&lastName=Reddy

@GetMapping("students/query")

public Student studentRequestVariable(@RequestParam int id,
                                      @RequestParam  String  firstName,
                                      @RequestParam  String lastName)
{
    return new Student(id, firstName, lastName);

}
// spring boot Rest API that handles http  post request
//client will send request  in request body

//@POST MAPPING AND @RequestMapping


//post to create new resource 
@PostMapping("student/create")  //to map incoming post request  
//http://localhost:8080/student/create
//RequestBody annotation internally uses spring provided http msg  converter  to convert json to java object
@ResponseStatus(HttpStatus.CREATED)

// to send response in the  status //it will return 201 created as response 
public Student createStudent(@RequestBody Student student)
{
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());

    return student;  //it will return the  student 

}




//spring boot Rest API that handles http  put  request
//client will send request  in request body
// update the existing resource 

@PutMapping("students/{id}/update")
//http://localhost:8080/students/{id}/update
public Student updateStudent(@pathVariable String id,@RequestBody Student student )
{
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return  student;
//if status is successfull by default it will create 

}


    }



