package com.ensa.paiement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String doLogin(){
		return "login";
	}
	@RequestMapping("/logout")
	public String doLogout(){
		return "login";
	}
}
