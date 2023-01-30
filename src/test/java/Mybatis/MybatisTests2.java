package Mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dto.TestDto;
import com.test.service.TestService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MybatisTests2 {


	@Autowired
	TestService service;
	
	@Test 
	public void func1() {
	
		TestDto dto =  service.GetTestObject(200);
		log.info("DTO : " + dto);	
	}
	
}




