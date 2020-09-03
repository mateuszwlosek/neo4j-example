package com.github.neo4j.person;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity("Person")
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Relationship(type = "SENDS_MONEY")
	private List<Person> sendsMoney = new ArrayList<>();

}
