package com.orangehrm.cucumber.steps;

import com.orangehrm.cucumber.serenity.TimeModuleSerenitySteps;
import com.orangehrm.reusablemethods.ReusableSpecifications;
import com.orangehrm.utils.TestUtils;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CustomerSteps {

	@Steps TimeModuleSerenitySteps steps;
	private int customerId;
	private String name;
	private String description;
	
	@When("^I try to save customer details by providing customer id, name and descrition I should get statuscode of 200$")
	public void saveCustomerDetails() {
		customerId = TestUtils.getCustomerId();
		name = TestUtils.getCompanyName();
		description = TestUtils.getCompanyDesc();
		steps.addCustomer(customerId, name, description)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.statusCode(200);
	}
}
