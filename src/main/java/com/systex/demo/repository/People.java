package com.systex.demo.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(People.class)
@Table(name = "People")
public class People {

	public People(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// 欄位 : 人員ID
	@Id
	private String id;

	// 欄位 : 人員姓名
	private String name;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}