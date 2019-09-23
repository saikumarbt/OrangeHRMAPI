package com.orangehrm.cucumber.steps;

import com.orangehrm.cucumber.serenity.EmployeeModuleSerenitySteps;
import com.orangehrm.reusablemethods.ReusableSpecifications;
import com.orangehrm.testbase.TestBase;
import com.orangehrm.utils.TestUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EmployeeSteps extends TestBase {
	
	private static String empId;

	@Steps EmployeeModuleSerenitySteps steps;
	
	@When("^admin user sends a get request with a valid token, employee list should be retrieved$")
	public void getListOfEmployees() {
		steps.getEmployeesList()		
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.statusCode(200)
		.log().all();
	}
	
	@When("^User should be able to create a new employee by providing firstName, lastName and code$")
	public void testCreateEmployee() {
		String firstName = TestUtils.getFirstName();
		String lastName = TestUtils.getLastName();
		String code = TestUtils.getCode();
		steps.createNewEmployee(firstName, lastName, code)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.statusCode(200)
		.log().all();
	
	}
	
	
	@When("^I create an employee by providing firstname, lastname and code$")
	public void createNewEmployee() {
		String firstName = TestUtils.getFirstName();
		String lastName = TestUtils.getLastName();
		String code = TestUtils.getCode();
		empId = steps.createNewEmployee(firstName, lastName, code)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.extract().jsonPath().get("id");
	}
	
	@Then("^I verify the employee creation by fetching the employee details.$")
	public void checkCreatedEmployeeDetails() {		
		steps.getEmployeeDetails(empId)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.statusCode(200)
		.log().all();
	}
	
	
	@When("^I try to update employee details by providing Marital Status, Gender, DOB & Nationality$")
	public void updateExistingEmployeeDetails() {
		String id = empId;
		String dob = TestUtils.getDob();
		String gender = TestUtils.getGender();
		String maritalStatus = TestUtils.getMaritalStatus();
		String nationality = TestUtils.getNationality();
		steps.updateEmployeeDetails(id, dob, maritalStatus, gender, nationality)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.log().all();	
	}
	
	@Then("^I should get a status code of 200 for updating the records successfully.$")
	public void validateStatusCode() {
		steps.getEmployeeDetails(empId)
		.statusCode(200);
	}
}
