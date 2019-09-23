package com.orangehrm.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.orangehrm.cucumber.serenity.EmployeeModuleSerenitySteps;
import com.orangehrm.reusablemethods.ReusableSpecifications;
import com.orangehrm.testbase.TestBase;
import com.orangehrm.utils.TestUtils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTest extends TestBase{
	
	private String firstName;
	private String lastName;
	private String code;
	private String dob;
	private String gender;
	private String maritalStatus;
	private String nationality;
	private static String response;
	
	@Steps
	EmployeeModuleSerenitySteps steps;

	@Title ("Employee - 05.Employee Search")
	@Test
	public void testEmployeeSearchFunctionality() {
		steps.getEmployeesList()
		.assertThat().statusCode(200)
		.log().all();
	}
	
	
	@Title ("Employee - 01.Save Employee")
	@Test
	public void testCreateEmployee() {
		firstName = TestUtils.getFirstName();
		lastName = TestUtils.getLastName();
		code = TestUtils.getCode();
		 response= steps.createNewEmployee(firstName, lastName, code)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.statusCode(200)
		.extract().jsonPath().get("id");
		System.out.println("Employee ID: " + response);
	
	}
	
	@Title("Employee - 02.Employee Detail")
	@Test
	public void testGetEmployeeDetails() {
		steps.getEmployeeDetails(response)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		.statusCode(200)
		.log().all();
	}
	
	@Title("Employee - 03.Update Employee Detail (Dob, MaritalStatus, Gender & Nationality")
	@Test
	public void testUpdateEmployeeDetails() {
		dob= TestUtils.getDob();
		maritalStatus = TestUtils.getMaritalStatus();
		gender = TestUtils.getGender();
		nationality = TestUtils.getNationality();
		steps.updateEmployeeDetails(response, dob, maritalStatus, gender, nationality)
		.statusCode(200)
		.log().all();
	
	}



}
