package ua.com.buy_me.controller;

import java.security.Principal;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.buy_me.entity.User;
import ua.com.buy_me.service.UserService;

 
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/newUser", method=RequestMethod.GET)
	public String user(){
		return "user";
	}
	
	@RequestMapping(value="/newUserAdd", method=RequestMethod.POST)
	public String saveCommodity(@RequestParam String nameUser, @RequestParam String emailUser, @RequestParam String phoneUser, @RequestParam String passwordUser){
			User user = new User(nameUser, phoneUser, passwordUser, emailUser);
			userService.save(user);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/selectGet", method=RequestMethod.POST)
	public String select(@RequestParam String formSelect){
			System.out.println(formSelect);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/loginpage", method=RequestMethod.GET)
	public String loginpage(){
		return "loginpage";
	}
	//need to change
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String home(Principal principal){
		
		return "redirect:/";
	}
	
	@RequestMapping(value={"/logout"}, method=RequestMethod.POST)
	public String logout(){
		
		return "redirect:/";
	}
	//need to change
	@RequestMapping(value={"/add"}, method=RequestMethod.POST)
	public String getUserName(Principal principal){
		User user = userService.findOneUser(Integer.parseInt(principal.getName()));
		return "redirect:/";
	}
	
}
