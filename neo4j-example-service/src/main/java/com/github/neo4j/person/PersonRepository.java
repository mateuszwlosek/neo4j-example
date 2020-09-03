package com.github.neo4j.person;

import org.springframework.data.neo4j.annotation.Depth;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, String> {

	Person findByName(String name, @Depth int depth);

	@Query("match(p1:Person {name: $name})-[x:SENDS_MONEY]->(p2:Person), " +
		" cyclePath=shortestPath((p2) - [*]->(p1))" +
		"with " +
		"p1 " +
		"return p1")
	Person findPersonWithSendingMoneyLoop(@Param("name") final String name);

	@Query("match(p1:Person)-[:SENDS_MONEY]->(p2:Person), " +
		" cyclePath=shortestPath((p2) - [*]->(p1))" +
		"with " +
		"p1, nodes(cyclePath) as cycle " +
		"where id(p1) = apoc.coll.max([node in cycle | id(node)]) " +
		"return p1")
	List<Person> findPeopleWithSendingMoneyLoops();
}
