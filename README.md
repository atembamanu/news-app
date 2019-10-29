# News-App
An application that allows one to add more users, add departments, add users to those departments, create news for the departments as well as create general news.
The front-end is presented using Postman API tester application.
## Author

* **Atemba Emmanuel** 

## Getting Started

Clone this repository to your local machine to get Started

Github: [https://github.com/atembamanu/news-app.git](https://github.com/atembamanu/news-app.git)

### Prerequisites

You need the following installed on your machine
- java
- JDK - Java Development Kit
- Maven
- Gradle
- An IDE - Intellij
- Postman
- PostgreSQL database


To confirm run the following command on linux
```
$ java --version       //java version
$ mvn --version        //maven version
$ gradle --version     //gradle version
```

## Installing

After cloning to your local machine navigate to the folder you cloned into and open it with intellij.
* Navigate into the ``` src/main/java/App.java ``` and click run in intellij.
* Open postman api-tester and select the HTTP method, enter your root api url and send the connection

## Running the Tests 

Create a test class for running tests in the application.

This is a sample test that tests if the getter method works

```
    @Test
    public  void  getFirstName_returnsCorrectFirstName(){
        User user = setupUser();
        assertEquals("Emmanuel", user.getFirstName());

    }

    @Test
    public void getSecondName_returnsCorrectSecondName() {
        User user = setupUser();
        assertEquals("Atemba", user.getSecondName());

    }

```

Create Credentials file to store your username and pass

```
public class Credentials {
    public static final String username = "username";
    public static final String pass = "passs!";
}

```
creating tables in PostgreSQL

```
    SET MODE PostgreSQL;

    CREATE DATABASE organizational_api;

    \c organizational_api;

    CREATE TABLE IF NOT EXISTS users (
    id int serial PRIMARY KEY,
    firstName VARCHAR,
    secondName VARCHAR,
    designation VARCHAR,
    role VARCHAR,
    department_id int
    );

    CREATE TABLE IF NOT EXISTS departments (
    id serial PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    empNo int
    );

    CREATE TABLE IF NOT EXISTS news (
    id serial PRIMARY KEY,
    title VARCHAR,
    content VARCHAR,
    category VARCHAR
    );

    CREATE DATABASE organizational_api_test WITH TEMPLATE organizational_api;
```

## Built With

* [Java](https://www.java.com/) - The language used
* [Intellij Idea](https://www.jetbrains.com/idea/) - Intergated development
* [Spark]() - Framework

## Test API with

*[Postman](https://www.getpostman.com/)


## Contributing
If you want to put out a pull request you first have to send us the sample code that you want to add to our repository for cross-checking before we allow the pull.

## Versioning

We use [Github](https://github.com/) for versioning. This is the first version of this application

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details