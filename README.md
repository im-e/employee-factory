## EmployeeFactory
EmployeeFactory is a group project by the 'udonUnit' consisting of Imogen, Irina, Alexander and Mamoon 👋.

The project creates a Java application that utilises a provided EmployeeFactory to generate random employee data, then converts the data from the provided csv file into Employee objects using a DTO design pattern, stores them, and implements methods to search for employees by Employee ID, Last Name (partial match), hire date range, age range, and salary range.

## More about the project
Our application allows the user to interrogate the data to: identify an employee based on the employee Id number and
by partially inputting the Last Name of an employee. Additionally, it is possible to query the data and retrieve all 
employees hired within a specified date range. Lastly, the user is able to search for all the employees within a specified
age range or salary range.

We hope to extend the functionality of our queries by adding methods to query our public record that enable us to retrieve an employee
by an email address, first name or gender.


## How you install and Run the Project

Dependencies required: Junit 


## How to Use the Project 


Setup: Ensure you have Java installed on your system. 

    Fork this repository
    Clone the forked repository and import it into yout preferred Java IDE
    Add your contributions (code or documentation)
    Commit and push
    Wait for pull request to be merged

## How to use the Program 

Step1: Open the File Directory "employeefactory" and open the class named "App".

Step2: Within the main method you can perform 5 different queries: 

        ```* EmployeeSearcher.searchEmployeeByID(int employeeID); // inserting the desired ID into the brackets e.g.198429;
        * EmployeeSearcher.searchEmployeesByHiredDateRange(String rangeStart,String rangeEnd); // in the following format: M/DD/YYYY; e.g.: 8/26/2013, 9/26/2013 
        * EmployeeSearcher.searchEmployeesByAgeRange(Integer rangeStart, Integer rangeEnd); //e.g. 21, 23 
        *EmployeeSearcher.searchEmployeesBySalaryRange(Integer rangeStart, Integer rangeEnd);//e.g. 69294,71294```
        
Step 3: Run the App
Step 4: You can review the previous search results in the resources folder results.log file;


To enhance maintainability we created logging functionality using java.util.logging. Our colour-coded logger allows you to easily track 
the flow of the program, record the state when an important event happens and capture errors or exceptions that occur during runtime.

📫 
If you encounter any bugs, please open up an issue to let us know.
Alternatively, we welcome suggestions for any updates or improvements you would like to see! 
