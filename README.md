<h1 align="center">Validate amount tickets Jira 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0-blue.svg?cacheSeconds=2592000" />
</p>

> This project contains the validation in Jira of the amount of tickets for FTR TSO :)

## Install

Use either idea or eclipse command in base of what IDE you're using

```sh
mvn clean install -DskipTests
```
```sh
mvn idea:idea    // For IntelliJ
mvn eclipse:eclipse    // For Eclipse
```

## Usage

Execute the TestNG suite called: 
```sh
suiteComparison.xml
```

You need to be connected to the FTR VPN in order to access to the Jira pages.

Also, you need to update the config.properties file with your own Jira authentication details: 
```sh
jira.auth.username=smm843
jira.auth.password=MyPass123123
```

Make sure you're using Java 8 and you have selected the correct driver that matches with the browser you're using. 
By default, it is set to work with Chrome. You only need to change the version of the ChromeDriver in the Driver class 
in the following line. By default, it is set to the version 83:

```sh
System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver83.exe");
```

## Run tests

```sh
mvn clean install -DskipTests
```
## Captures

![](https://i.imgur.com/RLQD6RQ.png)

# Notes!

  - This project uses Lombok and it is declared on the POM. If your are getting an error with annotations such as @Getter, @Slf4j and so on... Be sure to follow this steps.
  ![](https://i.imgur.com/ZKxDtGl.png)
  - This project has been created using IntelliJ and Maven dependencies.
  - This project uses Page Object Model.

## Author

👤 **Sebastian Mesa Guzmán**

* Github: [@semeguze](https://github.com/semeguze)

## Thank you

Thank you!
