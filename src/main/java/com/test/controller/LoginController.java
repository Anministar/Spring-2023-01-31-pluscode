package com.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginController {
	
	@GetMapping("/login")
	void loginform() {
		log.info("login Get...");
	}
	
	@PostMapping("/login")
	String loginproc(String email,String pwd,boolean rememberId,Model model, HttpServletResponse response) {
		log.info("login Post...");
		//log.info("id : " + email + " pw : " + pwd + " idchk : " + rememberId);
		
		//1 파라미터(생략)
		
		//2 유효성
		boolean flag = isValid(email,pwd);
		if(!flag) {
			model.addAttribute("msg","ID/PW가 일치하지 않습니다.");
			return "redirect:/login";
		}
		//3 서비스
		if(rememberId) {
			Cookie cookie = new Cookie("email",email);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("email",email);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		//4 뷰
		return "main";
		
	}
	private boolean isValid(String email, String pwd) {
		return email.equals("abcd@naver.com")&&pwd.equals("1234");
	}
	
}


