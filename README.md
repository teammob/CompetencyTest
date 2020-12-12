# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.12.RELEASE/maven-plugin/)

# CompetencyTest Java API

This API is used to store user information into H2 local database <br/>

### Run

  - mvn build <br/>

  - java -jar target/CompetencyTest-0.0.1-SNAPSHOT.jar <br/>
  
It has only 1 endpoint  http://localhost:8080/api/v1/save<br/>

You need to post data with this method body<br/>

{
	"name":"Yucel",
	"age":33,
 	"country":"United Kingdom",
 	"sex":"Male"

}


### Test
- mvn test

### Swagger File

Call http://localhost:8080/v2/api-docs to view endpoints


