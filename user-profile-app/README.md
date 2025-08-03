# User Profile Application

This project is a Java web application that allows users to manage their profiles. Users can create, view, edit, and delete their profiles, which include information such as name, surname, login ID, and password. The application uses Spring Boot for the backend and Thymeleaf for the frontend.

## Features

- User registration and profile management
- List all users
- Edit user profiles
- Delete user profiles

## Project Structure

```
user-profile-app
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── example
│   │   │   │       ├── controller
│   │   │   │       │   └── UserController.java
│   │   │   │       ├── model
│   │   │   │       │   └── User.java
│   │   │   │       ├── repository
│   │   │   │       │   └── UserRepository.java
│   │   │   │       └── service
│   │   │   │           └── UserService.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── templates
│   │   │       ├── user-list.html
│   │   │       ├── user-edit.html
│   │   │       └── user-profile.html
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd user-profile-app
   ```

2. **Build the project:**
   ```
   mvn clean install
   ```

3. **Configure the application:**
   Update the `src/main/resources/application.properties` file with your database connection settings.

4. **Run the application:**
   ```
   mvn spring-boot:run
   ```

5. **Access the application:**
   Open your web browser and navigate to `http://localhost:8080`.

## Usage Guidelines

- To create a new user, navigate to the user registration page.
- To view the list of users, go to the user list page.
- To edit a user profile, select a user from the list and make the necessary changes.
- To delete a user, select the user and confirm the deletion.

## Technologies Used

- Java
- Spring Boot
- Thymeleaf
- Maven
- JPA (Java Persistence API)

## License

This project is licensed under the MIT License.