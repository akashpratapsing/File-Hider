# File Hider 

This project implements a command-line interface (CLI) application for hiding and unhiding files using Java. It leverages several technologies to provide a robust and secure solution:

- **Java:** The core programming language for developing the application logic.
- **JavaMail API:** (Optional) Enables functionalities like sending email notifications for account creation or password resets (if implemented).
- **MySQL:** Stores user credentials and file information in a relational database.
- **JDBC Connectivity:** Facilitates interaction between the Java application and the MySQL database.

## Functionality Overview

The File Hider application offers the following functionalities through a user-friendly CLI menu:

1. **Signup:** New users can create an account by providing a username and password.
2. **Login:** Existing users can log in with their registered credentials.
3. **Hide Files:** Users can choose files or directories to hide, making them invisible in the file system.
4. **Unhide Files:** Previously hidden files or directories can be unhidden and restored to their original visibility.
5. **View Hidden Files:** Users can list all hidden files associated with their account.
6. **Exit:** Terminates the application.

**Note:** Integration with the JavaMail API for email notifications is an optional feature and might not be implemented in the current version.

## System Requirements

- Java Runtime Environment (JRE) installed on your system (refer to https://www.oracle.com/java/technologies/downloads/ for download and installation instructions).
- MySQL database server running on your system or a remotely accessible server.
- JDBC driver for MySQL (refer to the official MySQL documentation for driver download and configuration instructions).

## Usage Instructions

1. Clone this repository to your local machine.
2. Configure the database connection details in the Java code (e.g., hostname, port, username, password).
3. Ensure the JDBC driver for MySQL is included in your project's classpath.
4. Compile and run the main Java class to launch the File Hider application.
5. Follow the on-screen prompts to interact with the CLI menu and manage your files.

## Additional Notes

This README provides a general overview of the File Hider project. The actual implementation details like specific Java classes, database schema, and error handling mechanisms can be found within the project codebase.

Feel free to explore the code and customize it to enhance functionalities or add new features!
