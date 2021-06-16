package com.authorizationMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authorizationMicroservice.model.JWTResponse;
import com.authorizationMicroservice.model.User;
import com.authorizationMicroservice.service.CustomUserDetailsService;
import com.authorizationMicroservice.util.JWTUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JWTController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	private UserDetails userDetails;

	/**
	 * Authenticate the user
	 * @param authenticationRequest
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody User authenticationRequest) throws UsernameNotFoundException {

		log.info(authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("Incorrect username or password", e);
		} catch (BadCredentialsException e) {
			throw new UsernameNotFoundException("Incorrect username or password", e);
		}

		userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		String token = jwtUtil.generateToken(userDetails);

		log.info("JWT Token: " + token);

		return ResponseEntity.ok(new JWTResponse(token));
	}

	/**
	 * Validate user
	 * @param token
	 * @return
	 */
	@PostMapping("/validate")
	public Boolean validateToken(@RequestBody String token) {
		return jwtUtil.validateToken(token, userDetails);
	}

}
