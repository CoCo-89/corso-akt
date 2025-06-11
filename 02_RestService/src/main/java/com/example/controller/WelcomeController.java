package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/home")
public class WelcomeController {

	@GetMapping("/rest")
	public String welcome() {
		return "Welcome to Spring RESTful Web Services";
	}
	
	@GetMapping(value= {"/multi1", "/multi2"})
	public String multiURL(HttpServletRequest request) {
		String fullURL = request.getRequestURI();
        String[] parts = fullURL.split("/");
        if (parts.length > 1) {
            String lastPart = parts[parts.length - 1];
            if (lastPart.equals("multi1")) {
                return "Hai visitato multi1";
            } else if (lastPart.equals("multi2")) {
                return "Hai visitato multi2";
            } else {
                return "Hai visitato: " + lastPart;
            }
        }
        return null; 
        //non verrà usato perchè in caso di URL diversi
        //darà comunque Whitelabel Error Page
	}
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}
	
}






