package com.qrcode.buspass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qrcode.buspass.entity.AmountAddEntity;


@RequestMapping("/addAmount")
@Controller
public class AmountAddController {
	
	
	@GetMapping("/addAmount")
	public String addAmountToWallet(Model model,@ModelAttribute("amountAddEntity") AmountAddEntity amountAddEntity) {
		model.addAttribute("amountAddEntity", amountAddEntity);
		return "topup-wallet";
	}
	
	@GetMapping("/topupWallet")
	public String topupWallet(Model model) {
		return "";
	}
	
	

}
