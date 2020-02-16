package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SayHello;
import com.example.repositories.SayHelloRepository;
@CrossOrigin(origins = "*")
@Controller
public class RestIndController {
	@Autowired
	SayHello sayhello;
//	@Autowired
//	SayHelloService sayHelloService; 
	
	public RestIndController(SayHelloRepository sayHelloService) {
		
	}
	
public RestIndController() {
		
	}
	
	@RequestMapping(value = "/posted", method = RequestMethod.GET)
	@ResponseBody
	public SayHello sayIt() {
		return new SayHello("Thanks For Posting!!!", "Hello");
	}
	
    @RequestMapping(value="/home", method = RequestMethod.GET)
    @ResponseBody
    public String getMapping() {
        System.out.println("hello weeeee");
        return "index.jsp";
    }

}