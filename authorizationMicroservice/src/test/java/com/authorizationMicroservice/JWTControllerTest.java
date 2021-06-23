package com.authorizationMicroservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.authorizationMicroservice.controller.JWTController;
import com.authorizationMicroservice.service.CustomUserDetailsService;
import com.authorizationMicroservice.util.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class JWTControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	JWTUtil jwtUtil;

	@MockBean
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	JWTController authController;
	
	ObjectMapper objectMapper;

	@Test
	public void getTokenTest() throws Exception {

		com.authorizationMicroservice.model.User user = new com.authorizationMicroservice.model.User(1, "admin",
				"admin");
		UserDetails loadUserByUsername = customUserDetailsService.loadUserByUsername("admin");
		UserDetails value = new User(user.getUsername(), user.getPassword(), new ArrayList<>());

		when(customUserDetailsService.loadUserByUsername("admin")).thenReturn(value);
		when(jwtUtil.generateToken(loadUserByUsername)).thenReturn("token");

		ResponseEntity<?> login = authController.generateToken(user);
		assertEquals(200, login.getStatusCodeValue());

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
