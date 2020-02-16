package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SayHello;
import com.example.repositories.SayHelloRepository;
@Service
public class SayHelloService {
	@Autowired
	SayHelloRepository sayHelloRepository;
	
	
	public SayHelloService() {
		
	}
	
	public List<SayHello> getAll() {
		return sayHelloRepository.findAll();
	}
	
	public SayHello getId(String id) {
		return sayHelloRepository.findById(id).orElse(null);
	}
	
	public void saveObj(SayHello sh) {
	sayHelloRepository.save(sh);
	}
	
}
