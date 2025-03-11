# PetStore Automation Tests

This project provides automated tests for the PetStore API using Rest Assured, TestNG, and Maven. The tests cover the following functionalities:
1. Create a user.
2. Log in with the newly created user.
3. List all pets with the status "available".
4. Retrieve details for a specific pet.
5. Create an order (purchase) for a pet.
6. Log out from the application.

Each test is independent, uses DTOs for data mapping, and includes detailed documentation.

## Prerequisites

- Java 8 or higher.
- Maven (or Gradle) for dependency management.
- An active internet connection.

## Running Tests
All tests are executed using the TestNG suite defined in the suite.xml file, which is located in the src/test/resources directory. To run the tests, you can:

- Use Maven from the command line:
```
mvn test -DsuiteXmlFile=src/test/resources/suite.xml
```
- Run the TestNG suite directly in your IDE by loading the suite.xml file.

## Dependencies
This project uses the following main dependencies:

- Rest Assured for API testing.
- TestNG as the test runner.
- Lombok for reducing boilerplate code in DTOs.
- Jackson for JSON processing.

Ensure all dependencies are correctly configured in your pom.xml (or Gradle configuration file).

## Code Documentation
- **DTO Annotations**:

  The DTOs use Lombok annotations such as @Data, @Builder, @AllArgsConstructor, and @NoArgsConstructor to generate boilerplate code. The annotation @JsonIgnoreProperties(ignoreUnknown = true) is used to ignore any JSON properties that are not mapped in the DTO.

- **Test Structure**:

  Each test class (e.g., CreateUserTest, LoginTest, etc.) is documented and uses descriptive names (provided via the testName attribute in the @Test annotation) for clarity.

- **Request Builder**:

  A common RequestBuilder class handles GET and POST requests, which simplifies the test code and ensures consistency across tests.

## Notes
- **Independent Tests**:

  All tests are designed to be independent. Each test creates its own data when necessary to ensure isolation.

- **Suite File Usage**:

  Remember to use the suite.xml file located in src/test/resources to run the complete test suite.

