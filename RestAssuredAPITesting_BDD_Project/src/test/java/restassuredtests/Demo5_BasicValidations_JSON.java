//Source: https://www.youtube.com/watch?v=OSnvd8sMpGQ&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=6 
//Topic: Tutorial-6: API/Webservices Testing using RestAssured BDD Approach | Validations in JSON Response

/**
	1) Test Status Code
	2) Log Response
	3) Verifying Single Content in response body
	4) Verifying Multiple Contents in Response body
	5) Setting Parameters and Headers
 * 
 * 
 */


package restassuredtests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@SuppressWarnings("unused")
public class Demo5_BasicValidations_JSON {

	
	@Test (priority = 1)
	public void testStatusCode() {
		
		given()
		
		.when()
					.get("http://jsonplaceholder.typicode.com/posts/5")
		.then().statusCode(200) //1) Test Status Code
		.log().all(); //2) Log Response
		
}
	
	//2) Log Response
	@Test (priority = 2)
	public void testLogging() {
		
		given()
				
		.when()
					.get("https://restcountries.eu/rest/v2/name/india")
		
		.then()
		.statusCode(200)
		.log().all();
 		
	}
	
	//3) Verifying Single Content in response body
	
	@Test (priority = 3)
	public void testSingleContentFromAResponseBody() {
		
		given()
				
		.when()
					.get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.body("data.first_name", equalTo("Janet"));  // Verifying a single content from a Response body. Use "JSONPath Finder" (in Chrome), to get the actual path("data.first_name).
	 	
	}
	
	//4) Verifying Multiple Content in response body
	
		@Test (priority = 4)
		public void testMultipleContentsFromAResponseBody() {
			
			given()
					
			.when()
						.get("https://reqres.in/api/users?page=1")
			
			.then()
			.statusCode(200)
			.body("data.first_name", hasItems("Janet","Janet","Emma"));  // Verifying a single content from a Response body. Use "JSONPath Finder" (in Chrome), to get the actual path("data.first_name).
	 	}
		
		//5) Setting Parameters and Headers
		
		@Test (priority = 5)
		public void testParamsAndHeaders() {
			
			given()
					  .param("MyName", "Krishna") // Setting Param/s.
					  .header("MyHeader","Indian") // Setting Header/s
			.when()
						.get("https://reqres.in/api/users/2")
			
			.then()
			.statusCode(200)
			.log().all();
			 
		 	
		}
	
 	
}


