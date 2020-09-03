package com.github.neo4j.country;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends Neo4jRepository<Country, String> {

	@Query("match(b:Bank {name: $bankName})-[:HAS_CUSTOMER]->(p:Person)-[:HAS_NATIONALITY]->(c:Country) return c")
	List<Country> findPeopleCountiesAssignedToBank(@Param("bankName") String bankName);
}
