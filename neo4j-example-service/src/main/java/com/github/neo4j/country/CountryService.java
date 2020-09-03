package com.github.neo4j.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

	final CountryRepository repository;

	public List<Country> findPeopleCountiesAssignedToBank(final String bankName) {
		return repository.findPeopleCountiesAssignedToBank(bankName);
	}
}
