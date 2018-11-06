package com.jwt.malavolta.mongo;

import com.jwt.malavolta.mongo.entity.Customer;
import com.jwt.malavolta.mongo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Antonio", "Malavolta"));
		repository.save(new Customer("Lucia", "Falco"));


		System.out.println("Customer found with findByFirstName('Antonio'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Antonio"));

		System.out.println("Customers found with findByLastName('Lucia'):");
		System.out.println("--------------------------------");
		System.out.println();

		repository.findAll().forEach(customer -> {
			System.out.println(customer);
		});
	}
}