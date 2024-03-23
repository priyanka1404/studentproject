package com.udemy.studentproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.studentproject.bean.Student;


// to manage response and body we have to use response entity


@RestController
public class StudentResponseEntityController {

    //to manipulate the http response for rest api
    //statuscode,body,header as a result 


  //http://localhost:8080/student1
  //we will get response in json format
    @GetMapping("student1")

    //simple java method which returns student object

    

    public ResponseEntity<Student> getStudentResponse(){
        Student student =new Student(1, "priyanka", "Nomula");
        //return new ResponseEntity<>(student,HttpStatus.OK);
        // here we are configuring body and http status 
        //custom-header
        return ResponseEntity.ok()
        .header("custom-header","ramesh")
        .body(student);
    }






   @GetMapping("students1")  // http://localhost:8080/students1 
       //it will return list of students in the format of json to client   
    public  ResponseEntity<List<Student>> getStudentsResponse()
    {
    List<Student> students =new ArrayList<>(); 
    students.add(new Student(1, "priyanka", "nomula"));
    students.add(new Student(2, "sridhar", "alapati"));
    students.add(new Student(3, "pinky", "ragidi"));

    return  ResponseEntity.ok(students);

    }


    //spring boot  Rest API with path variable

    //{id}-URI tempalte variable
    //http://localhost:8080/students1/1
    @GetMapping("students1/{id}") 
    //to bind  URI template  variable with the method argument we need to use  @path variable
    
    public ResponseEntity<Student> studentPathVariableResponse(@PathVariable("id") int studentId){
      Student student = new Student(studentId ,"sridhar", "alapati");
    
        return  ResponseEntity.ok(student);
        
    }


    // spring boot rest api with id ,firstname,lastname
@GetMapping("students1/{id}/{first-name}/{last-name}")
// http://localhost:8080/students1/2/priya/nomula

    public ResponseEntity<Student> pathVariableResponse(@PathVariable("id")  int  studentId,
                                 @PathVariable("first-name") String firstName,
                                 @PathVariable("last-name") String lastName){
                                    
     Student student = new Student(studentId, firstName, lastName);
               
    return  ResponseEntity.ok(student);          
                                 
 }


 //Spring boot rest api with Request param(map to query parameters)
 //(to extract query paramater value in request url)
 
//http://localhost:8080/students1/query?id=1&firstName=priyanka&lastName=Reddy

@GetMapping("students1/query")

public ResponseEntity<Student> studentRequestVariableResponse(@RequestParam int id,
                                      @RequestParam  String  firstName,
                                      @RequestParam  String lastName)
{
    Student student=new Student(id, firstName, lastName);
    return  ResponseEntity.ok(student);

}
// spring boot Rest API that handles http  post request
//client will send request  in request body

//@POST MAPPING AND @RequestMapping


//post to create new resource 
@PostMapping("student1/create")  //to map incoming post request  
//http://localhost:8080/student1/create
//RequestBody annotation internally uses spring provided http msg  converter  to convert json to java object
//@ResponseStatus(HttpStatus.CREATED)

// to send response in the  status //it will return 201 created as response 
public  ResponseEntity<String> createStudentResponse(@RequestBody Student student)
{
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());

    return ResponseEntity.status(HttpStatus.CREATED).body("STUDENT inserted successfully");  //it will return the  student 

}




//spring boot Rest API that handles http  put  request
//client will send request  in request body
// update the existing resource 

@PutMapping("students1/{id}/update")
//http://localhost:8080/students1/{id}/update
public  ResponseEntity<Student> updateStudentResponse(@RequestBody Student student,@PathVariable("id") int studentId )
{
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return  new ResponseEntity<>(student,HttpStatus.CREATED);


}

//spring boot Rest API that handles http  delete   request
@DeleteMapping("students1/{id}/delete")
 //http://localhost:8080/students1/{id}/delete
public ResponseEntity<String> deleteStudentResponse(@PathVariable("id") int studentId){

    System.out.println(studentId);
    
    return  ResponseEntity.ok("student deleted successfully");


}


    }






    

