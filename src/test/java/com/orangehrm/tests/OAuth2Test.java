package com.orangehrm.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.orangehrm.config.Endpoints;
import com.orangehrm.model.IssueOAuthToken;
import com.orangehrm.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class OAuth2Test extends TestBase {
	
	@Title("Validate the generated access token by retrieving Admin user details")
	@Test
	public void test1() {
		Response resp = RestAssured.given().auth()
				.oauth2(IssueOAuthToken.getOAuth2Token())
				.get(Endpoints.ADMIN_GET_USERS);
		System.out.println("Code" + resp.getStatusCode());
		System.out.println(resp.jsonPath().prettify());
	}
}
