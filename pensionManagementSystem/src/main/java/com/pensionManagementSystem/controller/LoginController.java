package com.pensionManagementSystem.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionManagementSystem.client.AuthorizationMicroserviceClient;
import com.pensionManagementSystem.model.JWTResponse;
import com.pensionManagementSystem.model.User;

import jdk.internal.org.jline.utils.Log;

/**
 * @author Karthik
 *
 */
@Controller
public class LoginController {

	@Autowired
	AuthorizationMicroserviceClient authorizationMicroserviceClient;
	
	/**
	 * login page
	 * @param user
	 * @return
	 */
	@GetMapping("/login")
	public String showLoginPage(@ModelAttribute User user) {
		return "Testlogin";
	}

	/**
	 * Process login after entering details
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	public String processLogin(@ModelAttribute User user, ModelMap model, HttpSession session) {

		ResponseEntity<?> token;
		try {
			token = authorizationMicroserviceClient.generateToken(user);
			HashMap<String, String> tokenBodyMap = (LinkedHashMap<String, String>) token.getBody();
			JWTResponse response = new JWTResponse(tokenBodyMap.get("token"));
			model.addAttribute("status", "Login Success!!");
			Log.info("setting token to session");
			session.setAttribute("token", response.getToken());

		} catch (Exception e) {
			model.addAttribute("status", "Invalid Credentials!!");
			return "Testlogin";
		}

		return "redirect:/processPensionerInput";
	}

	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logoutUser(ModelMap model, HttpSession session) {
	
		boolean validated = authorizationMicroserviceClient.validateToken((String) session.getAttribute("token"));

		if (validated) {
			model.addAttribute("status", "Logout Successfully!");
		} else {
			model.addAttribute("status", "Wrong User!!");
		}
		Log.info("invalidating session");
		session.invalidate();
		return "Testlogin";
	}

}
