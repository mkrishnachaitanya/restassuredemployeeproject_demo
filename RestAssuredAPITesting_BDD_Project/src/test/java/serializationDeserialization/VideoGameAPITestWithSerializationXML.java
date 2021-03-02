
//NOTE: This program is part of the: Post and Get Request using Serialization and De-Serialization Using XML Format. - 2/2:
//Source: https://www.youtube.com/watch?v=sD7z52tUKK8&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=10
//Topic: Tutorial-10: API/Webservices Testing using RestAssured BDD | Serialization & De-serialization XML 

/*
 * API Testing using RestAssured:
BDD - Behavior Driven Development Approach:
---------------------------------------------------------------
1) Post and Get Request using Serialization and De-Serialization

Request and Response used: XML FORMAT

Pre-requisite: Install Gradel on Windows.
Gradle Download Link: https://gradle.org/releases/

VideoGameDB API Download Link:
https://github.com/james-willett/VideoGameDB

How to run the application using Gradle:
c:>gradlew bootRun

URL to get API Request:
URL: http://localhost:8080/swagger-ui/index.html#
 * 
 * 
 */

package serializationDeserialization;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class VideoGameAPITestWithSerializationXML {

	@Test (priority = 1)
	public void testVideoGameSerializationXML()
	{
		VideoGame myVideoGame = new VideoGame();
		
		myVideoGame.setId(11);
		myVideoGame.setCategory("Driving");
		myVideoGame.setName("mkc123");
		myVideoGame.setRating("Five");
		myVideoGame.setReleaseDate("2021-02-02");
		myVideoGame.setReviewScore(90);
		
		//Sending a POST request using BDD format.
		given()
					.contentType("application/xml")
					.body(myVideoGame)
					
		.when().post("http://localhost:8080/app/videogames")
		.then()
				  .log().all()
				  .body(equalTo("{\"status\": \"Record Added Successfully\"}"));	
 	}

	@Test (priority = 2)
	public void testVideoVideoGameDeSerialization() {
		
		VideoGame myVideoGame = get("http://localhost:8080/app/videogames/11").as(VideoGame.class); //This response of [get("http://localhost:8080/app/videogames/11")] has to be converted into the object typ[VideoGame.class].
		System.out.println(myVideoGame.toString());
 
	}
	
	
}
