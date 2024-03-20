package com.udemy.studentproject.bean;


//spring mvc will convert java bean (object) to json->client
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    

    //generate parametrized constructor
    
    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    //generate getters

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }



    //generate setters
    public void setId(int id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
