# Hotel Search Automation Framework

This is a test automation framework for a hotel search application, built using **Cucumber**, **Selenium**, **TestNG**, and **Allure** for reporting. It demonstrates a robust, scalable approach to web and mobile (Appium) testing, with features like parallel execution, screenshot capture, and reusable page objects.

## Features
- **Cucumber BDD**: Behavior-driven development with Gherkin feature files (`login.feature`, `hotelSearch.feature`).
- **Page Object Model**: Modular page classes (`BasePage`, `LoginPage`, `HomePage`, `SearchResultsPage`) for maintainability.
- **Thread-Safe WebDriver**: Supports parallel execution on Chrome and Firefox using `DriverManager` with `ThreadLocal`.
- **Custom Assertions**: `CustomAssert` integrates with Allure for screenshot attachments on assertion passes and failures.
- **Allure Reporting**: Generates detailed test reports with screenshots.
- **Appium Support**: Configured for mobile testing (e.g., Android app testing).
- **Configuration Management**: Uses `config.properties` for flexible configuration.

## Project Structure
selenium-cucumber-adactinhotel/
├── pom.xml                                 # Maven dependencies and build configuration
├── testng.xml                              # TestNG suite for parallel execution
├── src/
│   ├── main/
│   │   ├── java/com/qa/
│   │   │   ├── pages/                      # Page Object Model classes
│   │   │   └── utils/                      # Utility classes (DriverManager, CustomAssert, etc.)
│   │   └── resources/
│   │       └── config.properties           # Configuration file
│   └── test/
│       ├── java/com/qa/
│       │   ├── steps/                      # Cucumber step definitions
│       │   ├── hooks/                      # Cucumber hooks for setup/teardown
│       │   ├── runners/                    # TestNG runner
│       │   └── listeners/                  # TestNG listeners for failure screenshots
│       └── resources/
│           └── features/                   # Cucumber feature files

## Prerequisites
- **Java**: JDK 8 or higher
- **Maven**: 3.6.0 or higher
- **Browsers**: Chrome, Firefox (latest versions)
- **Appium**: (Optional) For mobile testing
- **Allure**: For report generation
- **Git**: For cloning the repository

## Setup Instructions
1. **Clone the Repository**:
   
       git clone https://github.com/magabene/selenium-cucumber-adactinhotel.git
       cd hotel-search-automation

2. **Install Dependencies**:
   
       mvn clean install -U
   
3. **Update Configuration**:
  **Edit** src/main/resources/config.properties:
   
       browser=chrome
       url=https://example.com
       username=testuser
       password=testpass
       platformName=Android
       deviceName=emulator-5554
       app=/path/to/app.apk
       appiumServer=http://127.0.0.1:4723
   
4. **Run Tests**:
   
       mvn test -DsuiteXmlFile=testng.xml
   
5. **Generate Allure Report**:
   
        allure serve target/allure-results

## Running Tests
- **Parallel Execution**: Tests run on Chrome and Firefox concurrently via testng.xml.
- **Feature Files**: login.feature and hotelSearch.feature cover login and hotel search scenarios.
- **Screenshots**: Attached to Allure reports on assertion failures or test failures.

## Key Components
- **DriverManager**: Thread-safe WebDriver management for Chrome, Firefox, and Appium.
- **BasePage**: Abstract class with generic methods (verifyElementText, verifyElementValue).
- **CustomAsser**t: Custom assertions with screenshot integration.
- **Hooks**: Initializes WebDriver and navigates to URL before each scenario.
- **TestRunner**: Configures Cucumber with TestNG and Allure plugins.

## Notes
- Replace https://example.com in config.properties with the actual application URL.
- For Appium, ensure an Appium server is running and update appiumServer, app, etc.
- Reports are generated in target/allure-results and can be archived:
  
      mv target/allure-results target/allure-results-$(date +%F-%H-%M-%S)

 ## License
 - MIT License

**Created by [Justice Thulane Magabene Mohuba]**





