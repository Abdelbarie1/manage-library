package com.biblio.exmpl.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class acceuilController {
	@GetMapping(value = "")
	public String acceuil() {
		return "acceuil";
	}
}
