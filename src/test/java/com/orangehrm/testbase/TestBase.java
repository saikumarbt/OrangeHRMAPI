package com.orangehrm.testbase;

import org.junit.BeforeClass;

import com.orangehrm.model.IssueOAuthToken;

import io.restassured.RestAssured;

public class TestBase {

	protected static String accessToken;
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://127.0.0.1/orangehrm/symfony/web/index.php/api/v1";
		accessToken = IssueOAuthToken.getOAuth2Token();
	}
}
