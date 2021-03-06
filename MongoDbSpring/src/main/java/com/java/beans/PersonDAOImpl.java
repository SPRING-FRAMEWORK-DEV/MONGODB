package com.java.beans;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;

public class PersonDAOImpl implements PersonDAO {

	private MongoOperations mongoOps;
	private static final String PERSON_COLLECTION = "Person";

	public PersonDAOImpl(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
		System.out.println(mongoOps.getClass());
	}

	// @Override
	public void create(Person p) {
		this.mongoOps.insert(p, PERSON_COLLECTION);

	}

	// @Override
	public Person readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
	}

	// @Override
	public void update(Person p) {
		this.mongoOps.save(p, PERSON_COLLECTION);
	}

	// @Override
	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOps.remove(query, Person.class,
				PERSON_COLLECTION);
		return result.getN();
	}

	public List<Person> getAll() {
		// TODO Auto-generated method stub

		return this.mongoOps.findAll(Person.class, PERSON_COLLECTION);
	}

}