package com.github.neo4j.country;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity("Country")
public class Country {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
}
