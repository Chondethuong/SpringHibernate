package springpractise.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springpractise.entity.Account;
import springpractise.service.AccountService;

@Controller
public class LoginController {
	@Autowired
	private AccountService accountService;
	
	/*@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse respone,
			@ModelAttribute("account")Account account){
		ModelAndView model = null;
		boolean isValidUser = accountService.validateAccount(account.getUsername(), account.getPassword());
		if (isValidUser){
			request.setAttribute("username", account.getUsername());
			model = new ModelAndView("redirect:/customers");
		}else{
			model = new ModelAndView("index");
			model.addObject("account",account);
			request.setAttribute("message", "Invalid credentials!");
		}
		return model;
	}*/
}
