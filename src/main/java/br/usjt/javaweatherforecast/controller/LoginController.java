package br.usjt.javaweatherforecast.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.javaweatherforecast.model.User;
import br.usjt.javaweatherforecast.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping (value = {"/login", "/"})
	public ModelAndView login () {
		ModelAndView mv = new ModelAndView ("login");
		mv.addObject(new User());
		return mv;
	}
	
	@PostMapping ("/doLogin")
	public String fazerLogin (HttpServletRequest request, User user) {
		if (loginService.login(user)) {
			request.getSession().setAttribute("currentUser", user);
			return "redirect:weather";
		}
		else {
			return "login";
		}
	}
}
