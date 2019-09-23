package com.orangehrm.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.orangehrm.cucumber.serenity.AdminModuleUserSerenitySteps;
import com.orangehrm.reusablemethods.ReusableSpecifications;
import com.orangehrm.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AdminTest extends TestBase {
	
	@Steps
	AdminModuleUserSerenitySteps steps;

	@Title("Admin - 1.Get Users")
	@Test
	public void testGetAdminUsers() {
	  steps.getAdminUsers()
	  .statusCode(200)
	  .spec(ReusableSpecifications.getGenericResponseSpec())
	  .log().all();
	 
	}
	
	@Title("Admin - 3.Get Organization Information")
	@Test
	public void testGetOrganizationInfo() {
		steps.getOrganizationDetails()
		.statusCode(200)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.log().all();
	}
	
	@Title("Admin - 2.User Login")
	@Test
	public void testUserLogin() {
		String res = steps.verifyUserLogin()
				.statusCode(200)
		.extract().response().asString();
		System.out.println(res);
	}
}
