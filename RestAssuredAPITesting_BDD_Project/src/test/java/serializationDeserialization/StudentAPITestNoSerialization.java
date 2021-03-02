
//NOTE: This program is part of the: Post and Get Request using Serialization and De-Serialization Using JSON Format. - 3/4:

package serializationDeserialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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



public class StudentAPITestNoSerialization {

	public HashMap<String, Serializable> map = new HashMap<String, Serializable>();
	public ArrayList<String> coursesList = new ArrayList<String>();
	
	
	//Creating a POST Request to accommodate the API Payload to create a new Student Record.
	@Test(priority = 1)
	public void createNewStudent() {	
		
		map.put("id", "101");
		map.put("firstName", "Krishna");
		map.put("lastName", "Chaitanya");
		map.put("email", "test@gmail.com");
		map.put("programme", "Manager");
		
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		//adding the coursesList created in the ArrayList into the HashMap.
		
		map.put("courses",coursesList);
		
		//BDD Keywords being implemented
		given()
					.contentType(ContentType.JSON)
					.body(map)
		.when()
					.post("http://localhost:8085/student") //This API URL is not working...since my "Sprint Boot" application which is supposed to run is not working properly and is giving some issue.
																				 //But I have written this code to understand the concept of Serialization. (Location: C:\SDET - QA Automation Techie).
					
		.then()
					.statusCode(201)
					.assertThat()
					.body("msg", equalTo("Student added"));
 	}
		
	//Creating a Get Request go retrieve the student details.
	
	@Test (priority = 2)	
	public void getStudentRecord()
	{
		given()
				  
		.when()
					.get("http://localhost:8085/student/101")
		.then()
					.statusCode(200)
					.assertThat()
					.body("id", equalTo(101)) //The new Student Id that we have created in the above method using the createNewStudent() method.
					.log().all();
	 }
	 
}
