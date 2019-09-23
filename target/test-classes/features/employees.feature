Feature: Orange HRM - Employee

Scenario: Get the list of Employees
When admin user sends a get request with a valid token, employee list should be retrieved

Scenario: Add an Employee
When User should be able to create a new employee by providing firstName, lastName and code 

Scenario: Validate if the employee has been added
When I create an employee by providing firstname, lastname and code
Then I verify the employee creation by fetching the employee details.

Scenario: Validate if the employee details are updated
When I try to update employee details by providing Marital Status, Gender, DOB & Nationality
Then I should get a status code of 200 for updating the records successfully.
