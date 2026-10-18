Automation Exercise - Selenium Cucumber Framework
📌 Project Overview
This project is a UI Test Automation Framework built using Java, Selenium WebDriver, and Cucumber BDD to automate web application testing on Automation Exercise (https://automationexercise.com/).
The framework follows a Behavior-Driven Development (BDD) approach, allowing test scenarios to be written in a clear, readable format using Gherkin syntax.
🛠️ Technologies & Tools
Java – Programming language
Selenium WebDriver – Browser automation
Cucumber BDD – Behavior-driven testing
JUnit 4 – Test execution
Maven – Dependency and project management
WebDriverManager – Browser driver management
Git & GitHub – Version control and source code hosting
IntelliJ IDEA – Development environment
✨ Key Features
Automated UI testing using Selenium WebDriver.
BDD test scenarios written in Gherkin.
Step Definitions connecting feature files to automation code.
Reusable Page Objects and shared browser setup.
Cucumber Hooks for test setup and teardown.
Automatic screenshot capture when a scenario fails.
Cucumber HTML test execution report.
Maven-based dependency management.
📂 Project Structure
AutomationExerciseSeleniumCucumber/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Pages/
│   │       │   ├── BasePage.java
│   │       │   ├── CartPage.java
│   │       │   ├── ContactUsPage.java
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── OrderPage.java
│   │       │   ├── ProductsPage.java
│   │       │   ├── RegisterPage1.java
│   │       │   ├── RegisterPage2.java
│   │       │   ├── SubscriptionPage.java
│   │       │   └── TestCasesPage.java
│   │       └── Properties/
│   │           └── config.properties
│   │
│   └── test/
│       └── java/
│           ├── Features/
│           │   ├── Cart.feature
│           │   ├── ContactUs.feature
│           │   ├── Login.feature
│           │   ├── Order.feature
│           │   ├── Products.feature
│           │   ├── RegisterPage1.feature
│           │   ├── RegisterPage2.feature
│           │   ├── Scroll.feature
│           │   ├── subscription.feature
│           │   └── TestCases.feature
│           ├── Runners/
│           │   └── TestRunner.java
│           └── Steps/
│               ├── CartFeatureSteps.java
│               ├── ContactUsFeatureSteps.java
│               ├── Hooks.java
│               ├── LoginFeatureSteps.java
│               ├── OrderFeatureSteps.java
│               ├── ProductFeatureSteps.java
│               ├── RegisterFeatureSteps1.java
│               ├── RegisterFeatureSteps2.java
│               ├── ScrollFeatureSteps.java
│               ├── SubscribeFeatureSteps.java
│               └── TestCasesSteps.java
│
├── src/test/resources/
│   └── test-document.pdf
│
├── target/
│   └── reports/
│       └── report.html
│
├── .gitignore
├── pom.xml
└── README.md
⚙️ Prerequisites
Before running the tests, make sure you have installed:
Java JDK
Apache Maven
Google Chrome or another browser configured for your tests
IntelliJ IDEA (recommended)
🚀 Getting Started
1. Clone the Repository
   git clone https://github.com/tokaadel16/AutomationExerciseSeleniumCucumber.git
2. Open the Project
   Open the cloned project in IntelliJ IDEA and allow Maven to load the dependencies.
3. Run the Tests
   From the project root directory, execute:
   mvn test
   Alternatively, run the TestRunner.java class from IntelliJ IDEA.
   📊 Test Reports
   After test execution, the Cucumber HTML report is generated at:
   target/reports/report.html
   Open the report in a web browser to review the test execution results.
   📸 Screenshots on Failure
   The framework captures a screenshot when a Cucumber scenario fails and attaches it to the scenario execution results.
   This helps with debugging and identifying UI issues.
   🔄 Test Execution Flow
   Cucumber reads the scenarios from the .feature files.
   Step Definitions execute the corresponding automation code.
   Selenium WebDriver interacts with the browser.
   Cucumber Hooks handle browser setup and teardown.
   Screenshots are captured when scenarios fail.
   The HTML report summarizes the execution results.
   👨‍💻 Author
   GitHub: tokaadel16 (https://github.com/tokaadel16)
   📄 License
   This project is intended for learning, practice, and demonstration of UI test automation skills.