//Source: https://www.youtube.com/watch?v=5xzoJmGzz4o&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=7
//Topic: Tutorial-7: API/Webservices Testing using RestAssured BDD Approach | Validations in XML Response

package restassuredtests;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
1) Verifying Single Content in XML Response.
2) Verifying Multiple Contents in XML Response.
3) Verifying all the content in the XML Response in one go.
4) XPath with text() function
5) Find values using XML Path in XML Response.
 * 
 * 
 */

@SuppressWarnings("unused")
public class Demo6_BasicValidations_XML {

	//1) Verifying Single Content in XML Response.
	@Test (priority=1)
	public void testSingleContent() {
		
		given()
				
		.when()
					.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/") //By the time of this program's execution(29.01.2021), this API was not working. So, if you want to work on this code, try with some other API URL which is working.
		.then()
					.body("CUSTOMER.ID",equalTo("15"))
					.log().all();
 	}
	
	//2) Verifying Multiple Content/s in XML Response.
		@Test  (priority=1)
		public void testMultipleContents() {
			
			given()
					
			.when()
						.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/") //By the time of this program's execution(29.01.2021), this API was not working. So, if you want to work on this code, try with some other API URL which is working.
			.then()
						.body("CUSTOMER.ID",equalTo("15"))
						.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
						.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
						.body("CUSTOMER.STREET", equalTo("319 Upland P1."))
						.body("CUSTOMER.CITY",equalTo("Seattle"));
	 	}
		
		//3) Verifying all the content in the XML Response in one go. and 4) XPath with text() function 
		@Test (priority=3)
		public void testMultipleContentsInOneGo() {
		
		given()
		
		.when()
					.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/") //By the time of this program's execution(29.01.2021), this API was not working. So, if you want to work on this code, try with some other API URL which is working.
		.then()
					.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland P1.Seattle"));//Append all the values that you want to compare...by placing them one beside the other, without spaces. 
																																		//Refer the above given url's video for more info.
																																		// We used the text() method from the XPATH to capture the response.
 			
 }
		
		//5) Find values using XML Path in XML Response.
		@Test (priority=4)
		public void testUsingXpath1() {
			
			given()
			
			.when()
						.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/") //By the time of this program's execution(29.01.2021), this API was not working. So, if you want to work on this code, try with some other API URL which is working.
			.then()
						.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill"))); //Instead of Customer.FIRSTNAME, to display the customer name, we can we XPATH too...!!!
		 }
		
		//5) Find values using XML Path in XML Response.
		@Test (priority=5)
		public void testUsingXpath2() {
			
			given()
			
			.when()
						.get("http://thomas-bayer.com/sqlrest/INVOICE/") //By the time of this program's execution(29.01.2021), this API was not working. So, if you want to work on this code, try with some other API URL which is working.
			.then()
						.body(hasXPath("/INVOICELIST/INVOICE[text()='30']")) //Instead of Customer.FIRSTNAME, to display the customer name, we can we XPATH too...!!!
						.log().all();
			
			
		}
		
}



