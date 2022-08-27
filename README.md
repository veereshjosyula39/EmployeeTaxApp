# EmployeeTaxApp
-----------------

DB Details
------------------
H2 DB Console URL
--------------------
http://localhost:8080/h2-console
JDBC URL=jdbc:h2:mem:crm
username=emptax
password=tax

API
---------
1. API endpoint to store employee details(Validate the data and throw the errors on invalid data)
    Employee ID
    FirstName
    LastName
    Email
    PhoneNumber(May have multiple phone numbers)
    DOJ
    Salary(per month)

2. API endpoint to return employees tax deduction for the current financial year(April to March).
    API return employee code, first name, last name, yearly salary, tax amount, cess amount.
    
    Tax slabs on yearly salary:

Rules
-----------
No Tax for <=250000
5% Tax for >250000 and <=500000
10% Tax for >500000 and <=1000000
20% Tax for >1000000
Consider the DOJ while calculating total salary(If the employee joined on May 16th, we should not include April month salary and May month's 15 days salary in total salary)
Collect additional 2% cess for the amount more than 2500000 (ex: yearly salary is 2800000 then collect 2% cess for 300000)
Others:
Total Salary: Salary * Number of months
Loss of pay per day: Salary / 30

