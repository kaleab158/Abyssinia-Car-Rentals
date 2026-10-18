🚗 Abyssinia Car Rentals

A Java-based car rental and vehicle management system built with the MVC (Model-View-Controller) architecture and the DAO (Data Access Object) pattern.

📖 Overview

Abyssinia Car Rentals lets a rental business manage its fleet, customers, and rental transactions in one application. The codebase separates presentation, business logic, and data access so each part is easy to maintain, test, and extend.

✨ Features
Add, update, delete, and view vehicles
Manage customer records
Create and track rentals and returns
Check vehicle availability
Persistent storage through a database layer
Clean separation of concerns (MVC + DAO)

Edit this list to match what your app actually does.

🏗️ Project Structure
Abyssinia-Car-Rentals/
├── Controller/   # Handles user actions, connects View and Model
├── DAO/          # Data Access Objects: all database queries live here
├── DataBase/     # Database connection and setup/schema scripts
├── Model/        # Entity classes (Car, Customer, Rental, ...)
└── View/         # User interface (screens/forms)
Layer	Responsibility
Model	Represents the core data and business entities
View	Displays information and collects user input
Controller	Processes input, calls DAOs, updates the View
DAO	Isolates SQL/database logic from the rest of the app
DataBase	Manages the connection and schema
🛠️ Tech Stack
Language: Java (JDK 17+ recommended)
Architecture: MVC with DAO pattern
Database: [MySQL / SQLite / other, fill in]
UI: [Swing / JavaFX / Console, fill in]
Build/IDE: [IntelliJ IDEA / Eclipse / NetBeans, fill in]
🚀 Getting Started
Prerequisites
Java JDK 17 or later
[Your database server, e.g. MySQL] installed and running
The JDBC driver for your database added to the project classpath
Installation
Clone the repository
bash
   git clone https://github.com/kaleab158/Abyssinia-Car-Rentals.git
   cd Abyssinia-Car-Rentals
Set up the database
Create a database, e.g. abyssinia_car_rentals
Run the schema script found in the DataBase/ folder
Configure the connection
Open the connection class in DataBase/
Update the URL, username, and password:
java
     String url = "jdbc:mysql://localhost:3306/abyssinia_car_rentals";
     String user = "your_username";
     String password = "your_password";
Run the application
Open the project in your IDE
Run the main class: [Main.java, fill in the path]
🧪 Usage
Launch the application
Use the menu or dashboard to manage vehicles and customers
Create a rental by selecting a customer and an available vehicle
Mark the vehicle as returned when the rental ends
🗺️ Roadmap
 User authentication and roles (admin / staff)
 Payment and invoice generation
 Search and filtering for vehicles
 Rental history reports
 Unit tests for DAO and Controller layers
👥 Team
Name	Role
Kaleab	Team Lead / Project Manager
[Teammate]	[Role]
[Teammate]	[Role]
🤝 Contributing
Fork the repo
Create a feature branch: git checkout -b feature/your-feature
Commit your changes: git commit -m "Add your feature"
Push the branch: git push origin feature/your-feature
Open a Pull Request
