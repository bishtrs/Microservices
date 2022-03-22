package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@SpringBootApplication
public class ConfigClient {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}
}


/*@RefreshScope
@RestController
class MessageRestController {

  @Value("${message:Hello default}")
  private String message;

  @RequestMapping("/message")
  String getMessage() {
    return this.message;
  }
}
*/
// http://localhost:8080/message
