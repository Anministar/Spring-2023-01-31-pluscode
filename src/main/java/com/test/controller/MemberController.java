package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.MemberDto;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	
	

//	@RequestMapping(value="/join",method=RequestMethod.GET)
	@GetMapping("/join")
	public void doGet() {
		log.info("join form!!...");
	}
	
//	@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("/save")
	public String doPost(MemberDto dto,Model model) {
		log.info("request save!!...");
		//1 파라미터 
		log.info("dto : " + dto);
		//2 유효성체크
		boolean flag= isValid(dto);
		if(!flag) {
			//메시지 전달
			model.addAttribute("msg", "유효성체크 결과 문제가 있음..");
			//특정 뷰 이동
			return "redirect:/member/join";
		}
		//3 서비스실행
		
		//4 뷰로이동
		return "login";
	}

	private boolean isValid(MemberDto dto) {
		
		return false;
	}
	
}





