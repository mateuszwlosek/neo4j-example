package com.github.neo4j.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

	private final PersonService service;

	@GetMapping("/{name}")
	public Person findByName(@PathVariable final String name, @RequestParam(value = "depth", defaultValue = "0") final int depth) {
		return service.findByName(name, depth);
	}

	@GetMapping("/findPeopleWithSendingMoneyLoops")
	public List<Person> findPeopleWithSendingMoneyLoops() {
		return service.findPeopleWithSendingMoneyLoops();
	}
}
