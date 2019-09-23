package com.orangehrm.cucumber.serenity;

import com.orangehrm.config.Endpoints;
import com.orangehrm.pojos.Customer;
import com.orangehrm.reusablemethods.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TimeModuleSerenitySteps {
	
	@Step ("Add new Customer")
	public ValidatableResponse addCustomer(int customerId, String name, String description) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setName(name);
		customer.setDescription(description);
		return SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.contentType("multipart/form-data")
				.multiPart("customerId", customer.getCustomerId())
				.multiPart("name", customer.getName())
				.multiPart("description", customer.getDescription())
				.when()
				.post(Endpoints.CUSTOMER)
				.then();
	}
	
	@Step("Get Customers")
		public ValidatableResponse getCustomers() {
		
		return SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.when()
				.get(Endpoints.CUSTOMER)
				.then();
	}

}
