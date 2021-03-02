//Source: https://www.youtube.com/watch?v=c04OckzYeOk&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=3
//Topic: Tutorial-3: API/Webservices Testing using RestAssured BDD Approach

package restassuredtests;

import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
//import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_Post_Request {
	
	@SuppressWarnings("rawtypes")
	public static HashMap map = new HashMap();
	

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void postData() {
		
		map.put("id", RestUtils.getRandomNumber());
		map.put("employee_name", RestUtils.getFirstName());
		map.put("employee_salary", RestUtils.getRandomNumber());
		map.put("employee_age",RestUtils.getRandomNumberInByte());
		
		
		//RestAssured Base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//RestAssured Base Path
		RestAssured.basePath = "/create";
		
		
	}
	
	@Test
	public void testPost() {
		
		given()
		.contentType("application/json")
		.body(map)
		 
		.when()
					.post()
		
		.then()
				   .statusCode(200)
				   .and()
				   .body("status", equalTo("success"))
				   .and()
				   .body("message",equalTo("Successfully! Record has been added."));
		
		
		
	}
	
	
}
