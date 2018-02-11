package com.spring.webflux.demo1;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebfluxDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxDemo1Application.class, args);
	}
	
	
	@Controller
	public class IndexController{
		
		@GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
		public String index(){
			return "index";
		}
	}
	
	@RestController
	public class NumerosController{
		
		
		@GetMapping(path = "/numeros", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
		public Flux<Integer> all(){
			return Flux.range(1, 30).delayElements(Duration.ofSeconds(1)).map(n -> n);
		}
	}
}