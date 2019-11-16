package com.techelevator.npgeek.survey;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;

@Controller
public class AccountController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ParkDAO parkDao;

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("Register")) {
			modelHolder.put("Register", new User());
		}
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String submitRegisterForm(@Valid @ModelAttribute("Register") User regFormValues, BindingResult result,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Register", result);
			flash.addFlashAttribute("Register", regFormValues);
			
			String email = regFormValues.getEmailAddress();
			String password = regFormValues.getPassword();
			
			userDao.addUser(email, password);
			
			return "redirect:/register";

		}
		flash.addFlashAttribute("message", "You have successfully registered.");

		return "redirect:/confirmation";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model modelHolder) {
		if (!modelHolder.containsAttribute("Login")) {
			modelHolder.addAttribute("Login", new Login());
		}
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String submitLoginForm(@Valid @ModelAttribute("Login") Login loginFormValues, BindingResult result,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
			flash.addFlashAttribute("Login", loginFormValues);
			return "redirect:/login";
		}
		flash.addFlashAttribute("message", "You have successfully logged in.");

		return "redirect:/confirmation";
	}

	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String showConfirmationView(HttpSession session) {
		List<Park> listParks = parkDao.getAllParks();
		
		session.setAttribute("listParks", listParks);
		return "confirmation";
	}
}
