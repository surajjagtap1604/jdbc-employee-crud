# jdbc-employee-crud
"Java CRUD app with JDBC for managing employee data. Features include add, update, delete, search functionalities. Easy-to-use CLI interface."
**Java Employee Management System with JDBC CRUD Operations**

This Java project provides a simple yet robust Employee Management System designed to perform basic CRUD (Create, Read, Update, Delete) operations on an Employee table stored in a database using JDBC (Java Database Connectivity). The system offers the following functionalities:

1. **Show Employee details joined between specific dates**: Enables users to retrieve employee details based on their join dates falling within a specified range.

2. **Insert new Employee**: Allows users to add a new employee to the database.

3. **Update emp deptName & give salary increment**: Provides the capability to update an employee's department name and grant a salary increment.

4. **Delete employee details**: Facilitates the removal of employee records from the database.

5. **Display deptwise avg salary**: Presents the average salary of employees within each department.

6. **Display all employee details**: Shows all details of every employee currently stored in the database.

7. **Exit**: Terminates the application.

**Key Features:**
- Utilizes JDBC for seamless interaction with the underlying database, ensuring compatibility across various database management systems.
- Offers a user-friendly command-line interface for smooth interaction and ease of use.
- Implements comprehensive error handling to manage exceptions effectively.
- Supports essential CRUD operations to manage employee data efficiently.
- Employs a menu-driven approach for intuitive navigation and operation.

**Instructions for Usage:**
1. Clone the repository to your local machine.
2. Set up the required database schema and table (e.g., `employee` table) with appropriate fields.
3. Configure the JDBC connection string within the code to establish connectivity with your database.
4. Compile the Java source files.
5. Execute the `TestEmployeeCRUD` class to launch the application.
6. Follow the prompts displayed on the console to perform desired CRUD operations on employee data.

**Note:**
- Prior knowledge of Java programming and JDBC concepts is assumed.
- Exercise caution while handling database credentials, avoiding hardcoding them directly in the source code.
- Customize the application as per specific requirements, such as incorporating additional functionalities or enhancing error handling mechanisms.
- Contributions and feedback are highly encouraged. Fork the repository, submit pull requests for enhancements, or report any issues for resolution. Your collaboration is valued and appreciated.
