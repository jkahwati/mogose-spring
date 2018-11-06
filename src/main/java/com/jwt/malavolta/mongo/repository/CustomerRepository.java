package com.jwt.malavolta.mongo.repository;

import com.jwt.malavolta.mongo.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository  extends MongoRepository<Customer,String> {

    public Customer findByFirstName(String frisName);

    public List<Customer> findByLastName(String lastName);
}
