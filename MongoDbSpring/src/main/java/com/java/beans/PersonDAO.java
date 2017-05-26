package com.java.beans;

import java.util.List;

public interface PersonDAO {

	public void create(Person p);

	public Person readById(String id);

	public void update(Person p);

	public int deleteById(String id);

	public List<Person> getAll();
}