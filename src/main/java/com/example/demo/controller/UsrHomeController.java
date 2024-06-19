package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	
//  주소를 요청함
	@GetMapping("/usr/home/main")
//	메서드에 응답하기 위한 몸통
	@ResponseBody 
	public String showMain() {
		return "안녕하세요";
	}



}
