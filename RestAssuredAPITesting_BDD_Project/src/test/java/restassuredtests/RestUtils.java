//Source: https://www.youtube.com/watch?v=c04OckzYeOk&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=3
//Topic: Tutorial-3: API/Webservices Testing using RestAssured BDD Approach

package restassuredtests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getFirstName()
	{
	String generatedString = RandomStringUtils.randomAlphabetic(1);
	return ("John" + generatedString);
	}

	public static String getLastName()
	{
	String generatedString = RandomStringUtils.randomAlphabetic(1);
	return ("John" + generatedString);
	}

	public static String getUserName()
	{
	String generatedString = RandomStringUtils.randomAlphabetic(3);
	return ("John" + generatedString);
	}

	public static String getPassword()
	{
	String generatedString = RandomStringUtils.randomAlphabetic(3);
	return ("John" + generatedString);
	}

	public static String getEmail()
	{
	String generatedString = RandomStringUtils.randomAlphabetic(3);
	return (generatedString+"@gmail.com");
	}
	
	public static double getRandomNumber()
	{
	double x = Math.random();
	return x;
	}
	
	public static short getRandomNumberInByte()
	{
	byte x = (byte) Math.random();
	return x;
	}
	
	public static String empName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}

	public static String empSal()
	{
	String generatedString = RandomStringUtils.randomNumeric(5);
	return (generatedString);
	}

	public static String empAge()
	{
	String generatedString = RandomStringUtils.randomNumeric(2);
	return (generatedString);
	}
	
	
}
