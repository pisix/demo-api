package com.societegenerale.demoapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.societegenerale.demoapi.model.Person;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

	private List<Person> persons = createList();

	@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
	public List<Person> firstPage() {
		return persons;
	}

	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET, produces = "application/json")
	public Person findOnePerson(@PathVariable("id") int id) {
		return new Person();
	}

	@DeleteMapping(path = { "/persons/{id}" })
	public Person delete(@PathVariable("id") int id) {
		Person deletedEmp = null;
		for (Person emp : persons) {
			if (emp.getId() == id) {
				persons.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping(path = { "/persons" })
	public Person create(@RequestBody Person user) {
		persons.add(user);
		System.out.println(persons);
		return user;
	}

	private static List<Person> createList() {
		List<Person> tempEmployees = new ArrayList<>();
		Person p1 = new Person();
		p1.setFirstName("Kimia");
		p1.setLastName("Kimimi");
		p1.setId(1);

		Person p2 = new Person();
		p2.setFirstName("Malia");
		p2.setLastName("Malili");
		p2.setId(2);

		Person p3 = new Person();
		p3.setFirstName("Séréna");
		p3.setLastName("Séréséré");
		p3.setId(3);

		tempEmployees.add(p1);
		tempEmployees.add(p2);
		tempEmployees.add(p3);

		return tempEmployees;
	}
}