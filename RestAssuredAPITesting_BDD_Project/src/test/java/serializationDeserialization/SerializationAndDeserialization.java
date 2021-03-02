
//NOTE: This program is part of the: Post and Get Request using Serialization and De-Serialization Using JSON Format. - 1/4:

//Source: https://www.youtube.com/watch?v=mYLqiRebLmM&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=8
//Topic: Tutorial-8: API/Webservices Testing using RestAssured BDD | Serialization & De-serialization


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



package serializationDeserialization;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i = 10;
	int j = 20;
	
}


public class SerializationAndDeserialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Test t1 =  new Test(); // Here, 't1' is an 'object' reference variable.
		System.out.println("t1 values are:" + t1.i +  " " + t1.j);
		
		
		//Serialization
		FileOutputStream fos = new FileOutputStream("test.txt"); // fos will allow us to write our object into memory.
		ObjectOutputStream oos = new ObjectOutputStream(fos) ; 
			
		oos.writeObject(t1); //This method will convert our object into file format and that file will be written into memory using FileOutputStream.
		
		//De-serialization
		FileInputStream fis = new FileInputStream("test.txt");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Test t2 = (Test) ois.readObject(); //This method will get the file into the Object format. Since we get the result as an object, we will have to create an 'object' of the 'Test' class and store it. Here, we use t2.
		System.out.println("t2 values are:" + t2.i + " "  + t2.j);
		
		oos.close();
	}

}
