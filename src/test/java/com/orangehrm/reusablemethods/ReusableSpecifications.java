package com.orangehrm.reusablemethods;

import com.orangehrm.testbase.TestBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableSpecifications extends TestBase {
	
	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestSpecification;
	public static ResponseSpecBuilder respec;
	public static ResponseSpecification responseSpecification;
	
	public static RequestSpecification getGenericRequestSpec() {
		rspec = new RequestSpecBuilder();
		//rspec.setContentType(ContentType.JSON);	
		rspec.addQueryParam("access_token", accessToken );
		//rspec.addHeader("Authorization", "Bearer " +IssueOAuthToken.getOAuth2Token());
		requestSpecification = rspec.build();
		return requestSpecification;
	}
	
	public static ResponseSpecification getGenericResponseSpec() {
		respec = new ResponseSpecBuilder();
		respec.expectHeader("Content-Type", "application/json");
		responseSpecification = respec.build();
		return responseSpecification;
	}

}
