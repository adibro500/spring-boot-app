package com.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SayHello;
import com.example.services.SayHelloService;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")

public class Rest2Controller {
	@Autowired
	SayHelloService shs;

	@GetMapping
	public List<SayHello> getThings() {
		return shs.getAll();
	}
	
	@GetMapping("/id/{id}")
	public SayHello getId(@PathVariable String id) {
		return shs.getId(id);
	}
	
	@PostMapping("/save/{id}")
	public SayHello updateById(@PathVariable String id, @RequestBody Map<String, String> msg) {
		SayHello sh = shs.getId(id);
		sh.setKio(msg.get("msg").toString());
		shs.saveObj(sh);
		return sh;
	}
	
	@PostMapping("/insert")
	public SayHello insert(@RequestBody Map<String, String> req) {
		SayHello sh = new SayHello();
		sh.setText(req.get("text").toString());
		sh.setKio(req.get("kio").toString());
		shs.saveObj(sh);
		return sh;
	}
	
	@PostMapping("/delete")
	public boolean deleteById(@RequestBody Map<String, String> deleteModel) {
		return shs.deleteById(deleteModel.get("id").toString());
	}
	
	@GetMapping("/byKio/{kio}")
	public List<SayHello> getByKio(@PathVariable String kio) {
		return shs.getByKio(kio);
	}

}
