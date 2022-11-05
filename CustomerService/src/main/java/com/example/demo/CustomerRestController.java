package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerRestController.class);

	private List<Customer> customers = new ArrayList<>();

	public CustomerRestController() {
		customers.add(new Customer("superman", "Clark Kent"));
		customers.add(new Customer("batman", "Ben Affleck"));
		customers.add(new Customer("thor", "Chris Hemsworth"));
	}

	@RequestMapping(value = "/v1/customers/{id}")
	public Customer getCustomer(@PathVariable String id) {
		LOG.info("returning toy");
		return customers.stream().filter(customer -> customer.getId().equalsIgnoreCase(id)).findFirst().get();
	}

}
