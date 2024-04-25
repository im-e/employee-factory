## EmployeeFactory
EmployeeFactory is a group project by the 'udonUnit' consisting of Imogen, Irina, Alexander and Mamoon 👋.

The project creates a Java application that utilises a provided EmployeeFactory to generate random employee data, then converts the data from the provided csv file into Employee objects using a DTO design pattern, stores them, and implements methods to search for employees by Employee ID, Last Name (partial match), hire date range, age range, and salary range.

## More about the project
Our application allows the user to query the data to: identify an employee based on the employee ID number and
by using a partial match of an input to find employees whos last name contain the query. 
Another query that can be is the retrieval of all employees hired within a specified date range. The user is able to search for all the employees within a specified age range or salary range. Lastly, there is a function to retrieve every employee in the program.

We hope to extend the functionality of our queries by adding methods to query our public record that enable us to retrieve an employee by an email address, first name or gender.


## Dependencies

JDK 22, Junit 


## How to Use the Project 

Setup: Ensure you have Java installed on your system. 

    Fork this repository
    Clone the forked repository and import it into yout preferred Java IDE
    Add your contributions (code or documentation)
    Commit and push
    Wait for pull request to be merged

## How to use the Program 

Open the project directory: "Employeefactory" and open the class named "App".
Ensure that the init function has been called on the EmployeeSearcher class, this should come before use of the following methods.

Within the main method you can access the data with 6 different queries: 

        EmployeeSearcher.init(); //<- Needs to be initialised before other methods will work
    
        EmployeeSearcher.(methodName)
        
        searchEmployeeByID(int employeeID);                                 //int - e.g. 198429;
        searchEmployeesByHiredDateRange(String rangeStart, String rangeEnd);//string, string (M/DD/YYYY) - e.g.: 8/26/2013, 9/26/2013 
        searchEmployeesByAgeRange(Integer rangeStart, Integer rangeEnd);    //int, int - e.g. 21, 23 
        searchEmployeesBySalaryRange(Integer rangeStart, Integer rangeEnd); //int, int - e.g. 69294,71294
        searchEmployeesByLastNameContains(String lastNameContains);         //string - e.g. "Smith', "Smi"
        searchAllEmployees();                                               //void - returns all employees
        
You can use any combination or frequency of these methods, and by running the program the results of each search will be shown in the console.        

For each run of App, there will be a recorded file of the results named SearchResult-YYYY-MM-DD---hh-mm-ss.txt.
These can be found in the resources (src/main/resources) folder.


To enhance maintainability we created logging functionality using java.util.logging. Our colour-coded logger allows you to easily track 
the flow of the program, record the state when an important event happens and capture errors or exceptions that occur during runtime.
This can be used through the Log class and it's static methods.

##  
📫 If you encounter any bugs, please open up an issue to let us know.
Alternatively, we welcome suggestions for any updates or improvements you would like to see! 
