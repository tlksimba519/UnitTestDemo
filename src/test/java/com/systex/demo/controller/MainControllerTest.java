package com.systex.demo.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.systex.demo.UnitTestDemoApplication;
import com.systex.demo.repository.MainRepository;
import com.systex.demo.repository.People;
import com.systex.demo.service.MainService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnitTestDemoApplication.class)
public class MainControllerTest {

	// 測試Controller需要建立假的MVC環境
	private MockMvc mockMvc;

	@Autowired
	private MainController controller;

	// 使用MockBean製作假元件
	@MockBean
	private MainService service;
	// 使用MockBean製作假元件
	@MockBean
	private MainRepository repo;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(this.controller).build();
	}

	@Test
	public void add() throws Exception {
		ObjectMapper om = new ObjectMapper();
		// Mocking
		when(this.service.addService(any())).thenReturn("done");

		String id = "test";
		String name = "user";

		ResultActions resultActions = mockMvc
				.perform(post("/add").content(om.writeValueAsString(new People(id, name)))
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("status", is("OK")));
	}

	@Test
	public void delete() throws Exception {
		// Mocking
		when(this.service.deleteService(any())).thenReturn("done");

		String id = "test";

		ResultActions resultActions = mockMvc
				.perform(get("/delete").param("id", id).contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("status", is("OK")));
	}

	@Test
	public void search() throws Exception {
		// Mocking
		when(this.service.searchService(any())).thenReturn("test");
		
		String id = "test";

		ResultActions resultActions = mockMvc.perform(get("/").param("id", id).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("status", is("OK")));
	}

	@Test
	public void modify() throws Exception {
		ObjectMapper om = new ObjectMapper();
		// Mocking
		when(this.service.modifyService(any())).thenReturn("done");

		String id = "test";
		String nameX = "mod";

		ResultActions resultActions = mockMvc
				.perform(get("/update").content(om.writeValueAsString(new People(id, nameX)))
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("status", is("OK")));
	}

}
