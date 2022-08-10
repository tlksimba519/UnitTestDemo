package com.systex.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systex.demo.repository.MainRepository;
import com.systex.demo.repository.People;

@Service
public class MainService {

	@Autowired
	private MainRepository repo;

	public String addService(People p) {
		repo.saveAndFlush(p);
		return "done";
	}

	public String deleteService(String id) {
		repo.deleteByID(id);
		return "done";
	}

	public String searchService(String id) {
		People p = repo.findByID(id);
		return p.getName();
	}

	public String modifyService(People p) {
		repo.saveAndFlush(p);
		return "done";
	}

}
