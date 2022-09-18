package com.societegenerale.demoapi.model;

public class Person {
	private int id;
	private String firstName;
	private String lastName;

	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (getId() != person.getId()) return false;
		if (!getFirstName().equals(person.getFirstName())) return false;
		return getLastName().equals(person.getLastName());
	}

	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + getFirstName().hashCode();
		result = 31 * result + getLastName().hashCode();
		return result;
	}
}