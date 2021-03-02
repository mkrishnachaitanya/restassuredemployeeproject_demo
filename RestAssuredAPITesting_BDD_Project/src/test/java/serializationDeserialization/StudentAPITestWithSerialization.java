
///NOTE: This program is part of the: Post and Get Request using Serialization and De-Serialization Using JSON Format. - 4/4:

//Source: https://www.youtube.com/watch?reload=9&reload=9&v=seBJgbMOwKw&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=9
//Topic: Tutorial-9: API/Webservices Testing using RestAssured BDD | Serialization & De-serialization JSON

package serializationDeserialization;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


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



public class StudentAPITestWithSerialization {

	@Test(priority = 1)
	public void CreateNewStudentSerialization() //We need  to pass an object as part of the request using Serialization concept.
	{
		ArrayList<String> coursesList = new ArrayList<String>();// We will be creating an Arrays List to capture the courses.
		
		//Courses will be added here.
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		//Again, we will use the setMethods() in the Student.java class to set the values for the variables[firstName,lastName...etc] and later call them. For that, first we need to create a Student class's object here.
		
		Student student = new Student(); //An object of 'student' is created here.
		
		student.setCourses(coursesList);
		student.setEmail("test@gmail.com");
		student.setFirstName("John");
		student.setFirstName("Deo");
		student.setProgramme("Computer Science");
		student.setSID(101);
		
		
		//We need to POST the below request now using BDD and Serialization concept and validate the success message.
		
		given()
					.contentType(ContentType.JSON)
					.body(student)
		.when()
					.post("http://localhost:8085/student")
		.then()	
					.statusCode(201)
					.assertThat()
					.body("msg",equalTo("Student Added"));
		
	}
	
	@Test(priority =2)
		public void getStudentRecordUsingDeserialization() { // 'GET' method is used to get the details after de-serialization. 
		
			Student stu = new Student();
		
				
			stu =  get("http://localhost:8085/student/101").as(Student.class);  //The response that we get[from "http://localhost:8085/student/101"] should be converted into the object format[which is in the file format initially]. The '(Student.class) will be used to convert the response into object. 
																													  // The response is stored in the 'stu' object variable.		/This API URL is not working...since my "Sprint Boot" application which is supposed to run is not working properly and is giving some issue.
																													//But I have written this code to understand the concept of Serialization. (Location: C:\SDET - QA Automation Techie).
			System.out.println(stu.getStudentRecord());	//Get all the records
			
			Assert.assertEquals(stu.getSID(),101);
			
			
			
		
	}
		
	
}
