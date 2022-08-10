package com.systex.demo.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class MainRepositoryTest {

	@Resource
	private MainRepository repo;

	@Test
	@Transactional
	public void findById() {

		People sample = repo.findByID("test");
		Assertions.assertThat(sample).isNotNull();

	}

	@Test
	@Transactional
	public void deleteById() {
		// use verify for void function
		verify(repo).deleteById(any());
	}
}
