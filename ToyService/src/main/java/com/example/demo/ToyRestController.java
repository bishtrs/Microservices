package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ToyRestController.class);

	private List<Toy> toys = new ArrayList<>();

	public ToyRestController() {
		toys.add(new Toy("Barbie", "Doll", 45.0));
		toys.add(new Toy("My Little Pony", "Animal", 10.4));
		toys.add(new Toy("Hot Wheels", "Car", 5.4));
	}

	@RequestMapping(value = "/toys") // http://localhost:8090/toys
	public List<Toy> listAll() {
		LOG.info("returning list of toys");
		return toys;
	}
	
	@RequestMapping(value = "/toys/{id}") // http://localhost:8090/toys/1
	public Toy getToy(@PathVariable int id) {
		LOG.info("returning toy");
		return toys.get(id);
	}

}
