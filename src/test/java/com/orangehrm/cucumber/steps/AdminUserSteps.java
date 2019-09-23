package com.orangehrm.cucumber.steps;

import com.orangehrm.cucumber.serenity.AdminModuleUserSerenitySteps;
import com.orangehrm.reusablemethods.ReusableSpecifications;
import com.orangehrm.testbase.TestBase;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AdminUserSteps extends TestBase {
	
	@Steps AdminModuleUserSerenitySteps steps;
	
	@When("^User sends a GET request with valid token then admin user details to be retrieved along with statuscode 200$")
	public void getAdminUserDetails() {
		steps.getAdminUsers()
		  .spec(ReusableSpecifications.getGenericResponseSpec())
		  .statusCode(200)
		  .log().all();
	}
	
	@When("^User sends a GET request with valid token then Organization details to be retrieved with statuscode 200$")
	public void getOrgInfo() {
		steps.getOrganizationDetails()
				.spec(ReusableSpecifications.getGenericResponseSpec())
				.statusCode(200)
				.log().all();
	}
}
