package com.github.neo4j.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository repository;

	public Person findByName(final String name, final int depth) {
		final Person personWithLoop = repository.findPersonWithSendingMoneyLoop(name);
		log.info("Found a person with loop: {}, will not apply depth", personWithLoop);

		return Optional
			.ofNullable(personWithLoop)
			.orElseGet(() -> repository.findByName(name, depth));
	}

	public List<Person> findPeopleWithSendingMoneyLoops() {
		return repository.findPeopleWithSendingMoneyLoops();
	}
}
