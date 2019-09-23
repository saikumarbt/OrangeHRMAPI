$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/admin.feature");
formatter.feature({
  "name": "Orange HRM - Admin",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get Admin User List",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User sends a GET request with valid token then admin user details to be retrieved along with statuscode 200",
  "keyword": "When "
});
formatter.match({
  "location": "AdminUserSteps.getAdminUserDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Get Organization details",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User sends a GET request with valid token then Organization details to be retrieved with statuscode 200",
  "keyword": "When "
});
formatter.match({
  "location": "AdminUserSteps.getOrgInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/features/customer.feature");
formatter.feature({
  "name": "Orange HRM - Time",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Save Customer info",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I try to save customer details by providing customer id, name and descrition I should get statuscode of 200",
  "keyword": "When "
});
formatter.match({
  "location": "CustomerSteps.saveCustomerDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/features/employees.feature");
formatter.feature({
  "name": "Orange HRM - Employee",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get the list of Employees",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "admin user sends a get request with a valid token, employee list should be retrieved",
  "keyword": "When "
});
formatter.match({
  "location": "EmployeeSteps.getListOfEmployees()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add an Employee",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User should be able to create a new employee by providing firstName, lastName and code",
  "keyword": "When "
});
formatter.match({
  "location": "EmployeeSteps.testCreateEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate if the employee has been added",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I create an employee by providing firstname, lastname and code",
  "keyword": "When "
});
formatter.match({
  "location": "EmployeeSteps.createNewEmployee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the employee creation by fetching the employee details.",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployeeSteps.checkCreatedEmployeeDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate if the employee details are updated",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I try to update employee details by providing Marital Status, Gender, DOB \u0026 Nationality",
  "keyword": "When "
});
formatter.match({
  "location": "EmployeeSteps.updateExistingEmployeeDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get a status code of 200 for updating the records successfully.",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployeeSteps.validateStatusCode()"
});
formatter.result({
  "status": "passed"
});
});