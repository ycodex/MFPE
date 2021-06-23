package com.authorizationMicroservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authorizationMicroservice.repository.LoginRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	/**
	 *Loading the input username
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.authorizationMicroservice.model.User user = loginRepository.findByUsername(username);

		if (user == null) {
			log.info("User not found:" + username);
			throw new UsernameNotFoundException("User not found !!");
		}
		log.info("User found: " + user.getUsername());

		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}
