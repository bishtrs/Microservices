package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ToyClientServiceRestController {
	
	@Autowired
    private RestTemplate restTemplate;

	private static final Logger LOG = LoggerFactory.getLogger(ToyClientServiceRestController.class);

	@RequestMapping("/toy-client-service/toys") // http://localhost:8090/toys, http://localhost:8091/toy-client-service/toys
    public ResponseEntity<?> getToys() {
		LOG.info("calling toy service");
        return restTemplate.getForEntity("http://toy-service/toys/", String.class);
    }
	
	@RequestMapping("/toy-client-service/{id}") // http://localhost:8090/toys/1, http://localhost:8091/toy-client-service/1
    public ResponseEntity<?> getToy(@PathVariable String id) {
		LOG.info("calling toy service");
        return restTemplate.getForEntity("http://toy-service/toys/"+id, String.class);
    }
        
}
