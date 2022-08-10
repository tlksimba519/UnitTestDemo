package com.systex.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.systex.demo.repository.MainRepository;
import com.systex.demo.repository.People;
import com.systex.demo.service.MainService;

@RestController
public class MainController {

	@Autowired
	private MainService service;

	@PostMapping("/add")
	public String create(@RequestBody People people) {
		service.addService(people);
		return "OK";
	}

	@GetMapping("/delete")
	public String delete(String id) {
		service.deleteService(id);
		return "OK";
	}

	@GetMapping("/search")
	public String search(String id) {
		return service.searchService(id);
	}

	@PostMapping("/update")
	public String update(@RequestBody People people) {
		service.modifyService(people);
		return "OK";
	}
}
