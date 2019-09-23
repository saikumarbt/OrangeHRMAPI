package com.orangehrm.cucumber.serenity;

import com.orangehrm.config.Endpoints;
import com.orangehrm.pojos.Employee;
import com.orangehrm.reusablemethods.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmployeeModuleSerenitySteps {
	
	@Step ("Get list of Employees")
	public ValidatableResponse getEmployeesList() {
		
		return SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.when()
				.get(Endpoints.EMPLOYEE_SEARCH)
				.then();
	}
	
	@Step("Create new employee")
	public ValidatableResponse createNewEmployee(String firstName, String lastName, String code) {
		
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setCode(code);
		return SerenityRest.rest()
		.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.contentType("multipart/form-data")
	    .multiPart("firstName", emp.getFirstName())
	    .multiPart("lastName", emp.getLastName())
	    .multiPart("code", emp.getCode()).log().all()
	    .when()
		.post("http://127.0.0.1/orangehrm/symfony/web/index.php/api/v1/employee/"+emp.getCode())
		.then();
	}
	
	@Step("Get Employee Details")
	public ValidatableResponse getEmployeeDetails(String id) {
		return SerenityRest.rest()
				.given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.get(Endpoints.EMPLOYEE+"/"+id)
				.then();
	}
	
	@Step("Update Employee Details: DOB, Marital Status, Gender, Nationality")
	public ValidatableResponse updateEmployeeDetails(String id, String dob, String maritalStatus, String gender, String nationality ) {
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setDob(dob);
		emp.setMaritalStatus(maritalStatus);
		emp.setGender(gender);
		emp.setNationality(nationality);
		
		return SerenityRest.rest()
		.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.contentType("multipart/form-data")
	    .multiPart("dob", emp.getDob())
	    .multiPart("maritalStatus", emp.getMaritalStatus())
	    .multiPart("gender", emp.getGender())
	    .multiPart("nationality", emp.getNationality())
	    .log().all()
	    .when()
		.put(Endpoints.EMPLOYEE+"/"+emp.getId())
		.then();
		
		
		
	}
	

}
