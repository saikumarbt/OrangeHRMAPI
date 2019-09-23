package com.orangehrm.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.orangehrm.cucumber.serenity.TimeModuleSerenitySteps;
import com.orangehrm.reusablemethods.ReusableSpecifications;
import com.orangehrm.testbase.TestBase;
import com.orangehrm.utils.TestUtils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class CustomerTest extends TestBase {
	
	private int customerId;
	private String name;
	private String description;
	private static String custIdResponse;
	
	@Steps
	TimeModuleSerenitySteps steps;
	
	
	@Title("Time - 2.Save Customers")
	@Test
	public void testToAddCustomer() {
		customerId = TestUtils.getCustomerId();
		name = TestUtils.getCompanyName();
		description=TestUtils.getCompanyDesc();
		custIdResponse = steps.addCustomer(customerId, name, description)
				.statusCode(200)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.extract().jsonPath().get("customerId");
		
	}
	
	@Title("Time - 1.Get Customers")
	@Test
	public void testToRetrieveCustomerDetails() {
		steps.getCustomers()
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.statusCode(200)
		.log().all();
	}
}
