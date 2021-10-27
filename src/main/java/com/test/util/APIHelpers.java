package com.test.util;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.test.base.BaseSetup;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class APIHelpers extends BaseSetup{

	
	public Response get(String getBaseURL) throws IOException
	{
		//Get call
		System.out.println("\n");
		RestAssured.baseURI = getBaseURL;
		System.out.println("API call is "+getBaseURL);
		Response response= given().contentType(ContentType.JSON)
				.when().get(getBaseURL);
		System.out.println("Response code is " +response.getStatusCode());
		System.out.println("Response Body of the API call is "+response.body().asString());
		return response;
	}
	
	public Response getWithHeaders(String getBaseURL, Map<String,Object> list) throws IOException
	{
		//Get call
		System.out.println("\n");
		RestAssured.baseURI = getBaseURL;
		System.out.println("API call is "+getBaseURL);
		Response response= given().headers(list).contentType(ContentType.JSON)
				.when().get(getBaseURL);
		System.out.println("Response code is " +response.getStatusCode());
		System.out.println("Response Body of the API call is "+response.body().asString());
		return response;
	}
	
	
	public Response post(String postBaseURL, String jsonFilePath) throws IOException
	{
		//Post call
		System.out.println("\n");
		Response response= given().
				contentType("application/json").
				body(jsonFilePath).
				when().
				post(postBaseURL);
		System.out.println("API call is "+postBaseURL);
		System.out.println("Response code is " +response.getStatusCode());
		System.out.println("Response Body of the API call is "+response.body().asString());
		
		return response;
	}
	
	public Response postWithHeaders(String postBaseURL, String jsonFilePath, Map<String,Object> list) throws IOException
	{
		//Post call
		System.out.println("\n");
		Response response= given().headers(list).
				contentType("application/json").
				body(jsonFilePath).
				when().
				post(postBaseURL);
		System.out.println("API call is "+postBaseURL);
		System.out.println("Response code is " +response.getStatusCode());
		System.out.println("Response Body of the API call is "+response.body().asString());
		return response;
	}
	
	public Response put(String putBaseURL, String jsonFilePath) throws IOException
	{
		//Post call
		System.out.println("\n");
		Response response= given().
				contentType("application/json").
				body(jsonFilePath).
				when().
				put(putBaseURL);
		System.out.println("API call is "+putBaseURL);
		System.out.println("Response code is " +response.getStatusCode());
		System.out.println("Response Body of the API call is "+response.body().asString());
		return response;
	}
	
	public Response patch(String patchBaseURL, String jsonFilePath) throws IOException
	{
		//Post call
		System.out.println("\n");
		Response response= given().
				contentType("application/json").
				body(jsonFilePath).
				when().
				patch(patchBaseURL);
		System.out.println("API call is "+patchBaseURL);
		System.out.println("Response code is " +response.getStatusCode());
		System.out.println("Response Body of the API call is "+response.body().asString());
		return response;
	}
	
	public Response patchWithHeaders(String patchBaseURL, String jsonFilePath, Map<String,Object> list) throws IOException
	{
		//Post call
		System.out.println("\n");
		Response response= given().headers(list).
				contentType("application/json").
				body(jsonFilePath).
				when().
				patch(patchBaseURL);
		System.out.println("API call is "+patchBaseURL);
		System.out.println("Response code is " +response.getStatusCode());
		System.out.println("Response Body of the API call is "+response.body().asString());
		return response;
	}
}
