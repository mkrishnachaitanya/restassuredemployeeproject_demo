//Source: https://www.youtube.com/watch?v=DehqozMbx8s&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=2

package restassuredtests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_Get_Request {
	
	@Test (priority = 0)
	public void getWeatherDetails(){
		given()
		 			.when().get("http://dummy.restapiexample.com/api/v1/employee/1")
					.then()
					.statusCode(200)
					//.statusLine("HTTP/1.1 200 OK")
					.assertThat().body("status",equalTo("success"))
					.header("Content-Type","application/json");
}//NOTE: CHAITANYA, CONNECTION IS REFUSED FOR THIS REQUEST. BUT THIS IS THE CORRECT SIGNATURE OF THE API GET REQUEST. 
	//	WHEN DOING REAL-APPLICATIONS TESTING, YOU CAN FOLLOW THIS SYNTAX.
	
}

/*
 *API testing using RestAssured, we use mostly, the following keywords

The following are the sections:
1) given()
Note: we do the following(some of them) activities in this section:
Eg: set Cookies, add authorization code, add Params, set some headers information, etc. So,
basically, all the pre-requisites that needs to be added for a test to run are added here.
Note: Given' keyword, lets you set a background, here, you pass the request headers, query and path param, body, cookies.


2) when()
Note: Any action that we need to perform, say, get,post, put, delete...etc, are included in this section.

3) then()
Note: In this section, we will validate the outcome of the actions that we performed in the when() section.
Eg: validate the status code, extract the response, extract headers, cookies and response body are captured here.
Also, we will do Assertions here, in this section. 
 * 
 * 
 * 
 * 
 */
