package com.heytusar.mongoapp.repository;


import java.util.List;

import com.heytusar.mongoapp.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findAllByCountry(String country);
}
