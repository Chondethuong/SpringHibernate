package springpractise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springpractise.service.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping({"/","/home","/login"})
	public String Home(@RequestParam(value="error", required = false)final String error, final Model model){
		model.addAttribute("message", "Login Failed !");
		return "index";
	}
}
