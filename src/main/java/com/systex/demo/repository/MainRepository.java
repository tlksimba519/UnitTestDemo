package com.systex.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MainRepository extends JpaRepository<People, Long> {

	@Transactional
	@Modifying
	@Query("select * from People p where p.Id=?1")
	People findByID(String id);
	
	@Transactional
	@Modifying
	@Query("delete from People p where p.Id=?1")
	void deleteByID(String id);
}
