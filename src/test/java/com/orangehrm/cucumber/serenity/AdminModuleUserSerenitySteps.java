package com.orangehrm.cucumber.serenity;

import com.orangehrm.config.Endpoints;
import com.orangehrm.reusablemethods.ReusableSpecifications;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AdminModuleUserSerenitySteps {

	@Step ("Get Admin User details")
	public ValidatableResponse getAdminUsers() {
		return SerenityRest.rest()
		.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		//.queryParam("access_token", IssueOAuthToken.getOAuth2Token())
		//.auth().oauth2(IssueOAuthToken.getOAuth2Token())
		
		.when()
		.get(Endpoints.ADMIN_GET_USERS)
		.then();
	  //System.out.println(resp.jsonPath().prettify());
	}
	
	@Step ("Get Organization details")
	public ValidatableResponse getOrganizationDetails() {
		return SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.when()
				.get(Endpoints.ADMIN_GET_ORGANIZATION)
				.then();
	}
	
	@Step ("User Login")
	public ValidatableResponse verifyUserLogin() {
		return SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.contentType("multipart/form-data")
				.multiPart("username", "jsmith")
				.multiPart("password", "Test@123")
				.when()
				.post(Endpoints.USER_LOGIN)
				.then();
	}
}
