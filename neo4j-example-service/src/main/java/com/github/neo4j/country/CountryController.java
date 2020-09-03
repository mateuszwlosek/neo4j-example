package com.github.neo4j.country;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bank")
@RequiredArgsConstructor
public class CountryController {

	private final CountryService service;

	@GetMapping("findPeopleCountriesAssignedToBank/{bank}")
	public List<Country> findPeopleCountiesAssignedToBank(@PathVariable final String bank) {
		return service.findPeopleCountiesAssignedToBank(bank);
	}
}
