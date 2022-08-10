package com.systex.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.systex.demo.UnitTestDemoApplication;
import com.systex.demo.repository.People;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnitTestDemoApplication.class)
public class MainServiceTest {

	@Autowired
	private MainService service;

	public void justServiceTest() {

		// 測試變數
		String id = "test";
		String name = "user";
		String nameX = "mod";

		// junit 原生寫法
		Assert.assertEquals("done", service.addService(new People(id, name)));
		Assert.assertEquals("done", service.deleteService(id));
		Assert.assertEquals("done", service.searchService(id));
		Assert.assertEquals("done", service.modifyService(new People(id, nameX)));

		// AssertJ 寫法
		Assertions.assertThat(service.addService(new People(id, name))).isEqualTo("done");
		Assertions.assertThat(service.deleteService(id)).isEqualTo("done");
		Assertions.assertThat(service.searchService(id)).isEqualTo("done");
		Assertions.assertThat(service.modifyService(new People(id, nameX))).isEqualTo("done");

	}

}
