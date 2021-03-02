
//NOTE: This program is part of the: Post and Get Request using Serialization and De-Serialization Using XML Format. - 1/2:

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

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement; 

@XmlAccessorType(XmlAccessType.FIELD) // Since every variable/item that is defined below, is considered as a Node, we need to specify that using this statement. Each Element given below is considered as a FIELD.
@XmlRootElement // If we know the root element, we can specify it...otherwise, ignore it.

public class VideoGame implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id = 0;
	public String name;
	public String releaseDate;
	public int reviewScore = 0;
	public String category;
	public String rating;

	public int getId(){
	return id;
	}

	public void setId(int id){
	this.id = id;
	}

	public void setName(String name){
	this.name = name;
	}

	public String getName(){
	return name;
	}

	public String getReleaseDate(){
	return releaseDate;
	}

	public void setReleaseDate(String releaseDate){
	this.releaseDate = releaseDate;
	}

	public int getReviewScore() {
	return reviewScore;
	}

	public void setReviewScore(int reviewScore){
	this.reviewScore = reviewScore;
	}

	public String getCategory(){
	return category;
	}

	public void setCategory(String category){
	this.category = category;
	}

	public String getRating(){
	return rating;
	}

	public void setRating(String rating){
	this.rating = rating;
	}

	//@Override
	//Write a method to display all the data
	public String toString() {
		return(this.id +" " +this.name+ " " + this.releaseDate+ " " +this.reviewScore + " " +this.category+" " +this.rating+" " );
	}
 
}
