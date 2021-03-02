
//NOTE: This program is part of the: Post and Get Request using Serialization and De-Serialization Using JSON Format. - 2/4:

//Source:
//Topic:
//This program is created as part of the "StudentAPITestWithSerialization" program, where in we will create a Student Class, which will store all the details of the student(in JSON format)
//and we will use this class (after creating the object), by Serializing and De-serializing concepts and transferring the data in the Student Class Object in create and get methods to populate and print data.

/**
 * API Testing using RestAssured:
BDD - Behavior Driven Development Approach:
---------------------------------------------------------------
1) Post and Get Request without Serialization and De-Serialization (Using HashMap)
2) Post and Get Request using Serialization and De-Serialization

Request and Response used: JSON FORMAT
 * 
 * 
 * @author madir
 *
 */


package serializationDeserialization;

import java.util.List;

public class Student {

	public Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String programme;

	List<String> courses;

	public int getSID() {
	return id;
	}

	public void setSID(Integer id){
	this.id = id;
	}

	public String getFirstName(){
	return firstName;
	}

	public void setFirstName(String firstName){
	this.firstName = firstName;
	}

	public String getLastName(){
	return lastName;
	}

	public void setLastName(String lastName){
	this.lastName = lastName;
	}

	public String getEmail(){
	return email;
	}

	public void setEmail(String email)
	{
	this.email = email;
	}

	public void setProgramme(String programme){
	this.programme = programme;
	}

	public List<String> getCourses()
	{
	return courses;
	}

	public void setCourses(List<String> courses){
	this.courses = courses;
	}

	public String getStudentRecord()
	{
	return (this.id+ " " +this.firstName+" "+this.lastName+ " "+this.email+ " " +this.programme+ " " +this.courses);
	}
	
}
