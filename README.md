## Web Medical Management System

This project is a **Web Medical Management System** built using **Java (JSP/Servlets)** and **MySQL**. It allows users to manage patient records, including adding, viewing, updating, and deleting patient information. The application is deployed using the **Apache Tomcat Server**.

---

## Features
- **Add Patient**: Add new patient records to the system.
- **View Patients**: Display all patient records in the database.
- **Update Patient**: Edit existing patient details.
- **Delete Patient**: Remove patient records from the system.
- **Responsive Web Interface**: User-friendly JSP pages for interaction.

---

## Technologies Used
- **Frontend**: JSP (JavaServer Pages), HTML
- **Backend**: Java (Servlets)
- **Database**: MySQL
- **Server**: Apache Tomcat
- **Tools**: Eclipse/IntelliJ IDEA for development

---

## Prerequisites
1. **Java Development Kit (JDK)** installed.
2. **Apache Tomcat Server** (version 9.0 or later).
3. **MySQL Server** installed and running.
4. **MySQL Connector/J** added to the project.

---

## Project Setup

### Step 1: Database Configuration
1. **Create Database**:
   Use the following SQL script to set up the database:
   ```sql
   CREATE DATABASE medical_db;

   USE medical_db;

   CREATE TABLE patients (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       age INT NOT NULL,
       medical_condition VARCHAR(255)
   );
   ```
2. Update the database connection credentials in `DatabaseConnection.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/medical_db";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";
   ```

---

### Step 2: Running the Application
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your_username/medical-management-system.git
   cd medical-management-system
   ```

2. **Add MySQL Connector**:
   - Download the MySQL Connector/J `.jar` file from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
   - Place the `.jar` file in the `lib` folder of your Tomcat installation.

3. **Deploy the Project**:
   - Package the project as a `.war` file using your IDE or manually.
   - Place the `.war` file in the `webapps` directory of your Tomcat server.

4. **Start Tomcat**:
   - Navigate to the Tomcat `bin` directory and run:
     - On Windows: `startup.bat`
     - On macOS/Linux: `./startup.sh`

5. **Access the Application**:
   - Open a browser and navigate to:
     ```
     http://localhost:8080/medical-management-system
     ```

---

## Application Workflow
1. **Homepage**:
   - Access options to view patients, add new patients, or edit/delete existing ones.

2. **Patient Management**:
   - Add a patient by entering their details.
   - View all patients in a tabular format.
   - Edit or delete patient records as needed.

---

---

## Future Enhancements
- **Authentication**: Add login functionality for secure access.
- **Search Feature**: Allow users to search for specific patient records.
- **Advanced UI**: Enhance the interface using modern frontend frameworks (e.g., React or Angular).

---

## Contributions
Contributions are welcome! Feel free to fork the repository, make improvements, and submit a pull request.

---

## Author
Developed by YNK Annapurna as a web-based solution for managing medical records.
