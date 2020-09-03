# Neo4j - Example

Example of [Neo4j](https://neo4j.com/) usage.

Application to use neo4j was developed in [Spring Boot](https://projects.spring.io/spring-boot/).

## Neo4j
* I prepared some test data with Banks, people and countries.  
![neo4j-data](https://user-images.githubusercontent.com/15820051/85205891-e0611300-b2e3-11ea-89bb-4a6081df2dd1.png)

## Application
I prepared some example queries to database:
* Find person by name, but as it is possible that relation of particular person will loop (person A -> person B -> person C -> person A), there is a protection of infinite loop to just return particular person without details about relations.
* Find people with loops, looks for all loops in relations, and returns one person from given looped relations
* Based on bank name, find all countries that people in that bank have nationality of

## How to run the environment?

### Before you start
* Make sure you have `Docker` and `docker-compose` installed.

[Docker CE INSTALLATION](https://docs.docker.com/install/linux/docker-ce/ubuntu/)  
[Docker Compose INSTALLATION](https://docs.docker.com/compose/install/#prerequisites)

### Start the environment
1. Build services:
    `docker-compose build`
2. Run services:
    `docker-compose up`

### Important endpoints:
* http://localhost:7474 - Neo4j Browser (credentials: neo4j/admin)
* http://localhost:8080/person/Jack - Example request to get person details by name
* http://localhost:8080/person/findPeopleWithSendingMoneyLoops - Request to get people with loops in relations
* http://localhost:8080/bank/findPeopleCountriesAssignedToBank/Bank%20of%20America - Example request to get countries of people related to particular bank

