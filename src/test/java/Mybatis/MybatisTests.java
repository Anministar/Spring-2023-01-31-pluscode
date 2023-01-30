package Mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dto.TestDto;
import com.test.mapper.TestMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MybatisTests {


	@Autowired
	TestMapper mapper;
	
	@Test 
	public void func1() {
		log.info("mapper : " + mapper);
		log.info("CountXML :" + mapper.countXML());
		log.info("CountAT :" + mapper.countAt());
	}
	
	@Test
	public void func2() {
//		TestDto dto = mapper.selectXML(2);
		log.info("DTOXML : " + mapper.selectXML(2));
		log.info("DTOAt : " + mapper.selectAT(3));
	}
	@Test 
	public void func3() {
		List<TestDto> list = mapper.selectXML2(1);
		for(TestDto dto : list) {
			log.info(dto);
		}
		log.info("--------------------------");
		mapper.selectAT2(2).forEach((dto)->{log.info(dto);});
	}
	
	@Test
	public void func4() {
		//mapper.insertXML(new TestDto(4,"hoho"));
		//mapper.insertAT(new TestDto(5,"test"));
		mapper.insertPARAM(6, "abc");
	}
	@Test
	public void func5() {
		TestDto dto = new TestDto(0,"tete");
		mapper.insertKeyBeforeXML(dto);
		log.info("beforeKey : "+dto.getId());
		
	}
}




