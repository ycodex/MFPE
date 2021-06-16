package com.pensionManagementSystem.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionManagementSystem.client.AuthorizationMicroserviceClient;
import com.pensionManagementSystem.client.ProcessPensionMicroserviceClient;
import com.pensionManagementSystem.model.PensionDetail;
import com.pensionManagementSystem.model.PensionerInput;
import com.pensionManagementSystem.repo.PensionDetailsRepo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class PensionerInputController {
	@Autowired
	ProcessPensionMicroserviceClient processPensionMicroserviceClient;

	@Autowired
	AuthorizationMicroserviceClient authorizationMicroserviceClient;
	PensionDetail pD;
	@Autowired
	PensionDetailsRepo repo;
	boolean invalidInput = false;
	
	/**
	 * Process the input
	 * @param pensionerInput
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/processPensionerInput")
	public String showPensionerInputForm(@ModelAttribute PensionerInput pensionerInput, HttpSession session,
			ModelMap model) {
		
		boolean validated = authorizationMicroserviceClient.validateToken((String) session.getAttribute("token"));
		if (validated) {
			if (invalidInput) {
				model.addAttribute("status", "Wrong Pension Data!!");
				invalidInput = false;
			}
			log.info("returning the input page");
			return "TestpensionerInput";
		}
		return "redirect:/login";
	}

	
	/**
	 * calculate pension
	 * @param pensionerInput
	 * @param result
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping("/getPensionerDetail")
	public String fetchDetails(@ModelAttribute PensionerInput pensionerInput, BindingResult result, HttpSession session,
			ModelMap model) {

		log.info(pensionerInput.toString());

		PensionDetail pensionDetail = processPensionMicroserviceClient.getPensionDetails(pensionerInput);
		log.info("Details: " + pensionDetail);

		if (pensionDetail == null) {
			invalidInput = true;
			return "redirect:/processPensionerInput";
		}
		pD=pensionDetail;
		model.addAttribute("pensionDetail", pensionDetail);
		return "TestpensionDisbursement";
	}

	/**
	 * disbursement of pension
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/disbursement")
	public String successfulDisbursement(ModelMap model, HttpSession session) {
		boolean validated = authorizationMicroserviceClient.validateToken((String) session.getAttribute("token"));
		if (validated) {
			log.info("saving into database");
			repo.save(pD);
			model.addAttribute("msg", "Congratulations!!");
			model.addAttribute("info", "Amount has been disbursed to your bank account.");
			return "success";
		}
		model.addAttribute("status", "Error in disbursement");
		return "TestpensionDisbursement";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
