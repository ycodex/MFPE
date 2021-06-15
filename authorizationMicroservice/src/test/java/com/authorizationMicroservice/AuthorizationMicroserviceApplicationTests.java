package com.authorizationMicroservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.authorizationMicroservice.controller.JWTController;

@SpringBootTest
public class AuthorizationMicroserviceApplicationTests {

	@Autowired
	JWTController controller;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	public void applicationStarts() {
		AuthorizationMicroserviceApplication.main(new String[] {});
	}

}
