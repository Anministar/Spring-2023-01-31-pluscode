package com.test.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.TestDto;
import com.test.service.TestService;

import lombok.extern.log4j.Log4j;

@RequestMapping("/Rest")
@Log4j
@RestController //뷰로 이동하는게 아니라 여기서 자체적으로 데이터를 만들어서 뷰로 전달.(response body에 실려감)
public class RestTestController {
	
	@Autowired
	TestService service;
	
	
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8") // text/plain ==> html파일이 아니라 단순 순수한 text파일로 전달되는것.
	public String func1() {
		log.info("MINE TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "HELLO WORLD!!!!";
	}
	
	@GetMapping(value="/getText2", produces=MediaType.TEXT_PLAIN_VALUE) 
	public String func2() {
		log.info("MINE TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "HELLO WORLD2222";
	}
	
	@GetMapping(value="/getRest", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}) 
	public TestDto func3() {
		return new TestDto(1, "홍길동");
	}
	
	@GetMapping(value="/getRest2")
	public List<Map<String, Object>> func4() {
		return service.SelectAllTestObject();
	}
	
	@GetMapping(value="/getRest3", params= {"condition", "type", "keyword"})
	public ResponseEntity<List<Map<String, Object>>> func5(String condition, String type, String keyword) {
		
		ResponseEntity<List<Map<String, Object>>> result = null;
		List<Map<String, Object>> list = null;
		
		if(condition==null || condition.equals("")) { //condition 파라미터 값이 없는 경우
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(list);
		}
		else { //condition 파라미터 값이 있는 경우
			System.out.println("condition : " + condition + " type : " + type + " keyword : " + keyword);
			Map<String, Object> map = new HashMap();
			map.put("condition", condition);
			map.put("type", type);
			map.put("keyword", keyword);
			list = service.SelectAllTestObject(map);
			result = ResponseEntity.status(HttpStatus.OK).body(list);
		}
		
		return result;
	}
	
	@PostMapping("/getRest4")
	public TestDto func6(@RequestBody TestDto dto) {
		System.out.println("DTO : " + dto);
		return dto;
	}
	
	
	@PostMapping("/PostReq")
	public TestDto func7(@RequestBody TestDto dto) {
		System.out.println("DTO : " + dto);
		return dto;
	}
}
