//Topic: Tutorial-4: API/Webservices Testing using RestAssured BDD Approach
//Source: https://www.youtube.com/watch?v=x4BKSAKZ-Xg&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=4

package restassuredtests;

/*import io.restassured.RestAssured;
import io.restassured.RestAssured.*;*/
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Demo3_Put_Request {

	@SuppressWarnings("rawtypes")
	public static HashMap map = new HashMap();
	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	int id = 1;
	
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void putData() {
			map.put("emp_name", empName);
			map.put("employee_salary", empSalary);
			map.put("employee_age", empAge);
			
			RestAssured.baseURI = "http://dummy.restapiexample.com/public/api/v1/";
			RestAssured.basePath = "/update/" + id;
	 	
	}
	
	@Test
	public void testPut()
	{
		given()
				  .contentType("application/json")
				  .body(map)
		.when()
					.put()
		.then()
					.statusCode(200)
					.log().all();
	}
}
