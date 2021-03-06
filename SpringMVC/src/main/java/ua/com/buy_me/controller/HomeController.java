package ua.com.buy_me.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.buy_me.dto.CommodityDto;
import ua.com.buy_me.dto.DtoUtilMapper;
import ua.com.buy_me.dto.UserDto;
import ua.com.buy_me.entity.Commodity;
import ua.com.buy_me.entity.User;
import ua.com.buy_me.service.CommodityService;
import ua.com.buy_me.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String commodity(Model model){
		List<CommodityDto> commodities = commodityService.findAllDto();
		model.addAttribute("commodities", commodities);
		List<UserDto> users = DtoUtilMapper.listUserToUserDto(userService.findAll());
		model.addAttribute("users", users);
//		System.out.println(commodityService.findAll());
		return "home";
	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home() {
//		return "home";
//	}
	
	@RequestMapping(value="/buy/{id}", method=RequestMethod.GET)
	public String home(Principal principal, @PathVariable String id){
		User user = userService.fetchUser(Integer.parseInt(principal.getName()));
		Commodity commodity = commodityService.findOneUser(Integer.parseInt(id));
		System.out.println(user.getUsername());
		commodity.setUser(user);
		commodityService.save(commodity);
//		user.getCommodities().add(commodity);
//		System.out.println(user.getCommodities().size()+"");
//		userService.save(user);
		return "redirect:/";
	}
}
