package com.qrcode.buspass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qrcode.buspass.entity.UserEntity;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/login")
	public String login(@ModelAttribute("userEntity") UserEntity userEntity,Model model) {
		model.addAttribute("userEntity",userEntity);
		
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration(@ModelAttribute("userEntity") UserEntity userEntity,Model model) {
		model.addAttribute("userEntity",userEntity);
		

		String msg=(String) model.asMap().get("message");
		
		if(msg!=null) {
			model.addAttribute("message",msg);
		}
		
		
		return "registration";
	}
	@PostMapping("/loginByEmailAdd")
	public String loginByEmailAdd(@ModelAttribute("userEntity") UserEntity userEntity,Model model) {
		
		
		userEntity.setUserType("1");
		model.addAttribute("userEntity",userEntity);
		if(userEntity.getUserType().equals("1")) {
			return "admin-home-page";
		}else {
			
		}
		
		
		return "user-homepage";
	}
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute("userEntity") UserEntity userEntity,Model model,RedirectAttributes redirectAttributes) {
		int saveId=userService.createUser(userEntity);
		if(saveId>0) {
			redirectAttributes.addAttribute("message", "User Created Successfully");
		}
		return "redirect:/registration";
	}
}
