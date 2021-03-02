//Source: https://www.youtube.com/watch?v=jIvYQesb_zc&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=5
//Topic: Tutorial-5: API/Webservices Testing using RestAssured BDD Approach

package restassuredtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Demo4_Delete_Request {

	@Test
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath= "/delete/2";
		
		Response response =
		given()
		
		.when()
					.delete()
		.then()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 OK")
					.contentType("application/json")
					.log().all()
					.extract().response();//This method will capture the response() from the API and the response body will be stored in the 'response' variable, defined above.
		
		String jsonAsString = response.asString(); // The response is in the JSON format. So we use the method-asString(), to convert it into the String. The output of this operation is stored in a variable named 'jsonAsString'.
			
		Assert.assertEquals(jsonAsString.contains("Successfully! Record has been deleted"),true);
		
	
	}
	
	
	
	
	
}
