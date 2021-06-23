package com.authorizationMicroservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.authorizationMicroservice.controller.JWTController;

@SpringBootTest
public class AuthorizationMicroserviceApplicationTests {

	
	
	@Test
	public void applicationStarts() {
		AuthorizationMicroserviceApplication.main(new String[] {});
		assertTrue(true);
	}

}
