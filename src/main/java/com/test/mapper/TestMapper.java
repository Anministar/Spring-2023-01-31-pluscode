package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.test.dto.TestDto;

public interface TestMapper {

	//XML
	public int countXML();
	//At
	@Select("Select count(*) from tbl_a")
	public int countAt();
	
	public TestDto selectXML(int id);
	
	@Select("Select * from tbl_a where id=#{id}")
	public TestDto selectAT(int id);
	
	public List<TestDto> selectXML2(int id);
	
	@Select("Select * from tbl_a where id>=#{id}")
	public List<TestDto> selectAT2(int id);
	
	public int insertXML(TestDto dto);
	
	@Insert("Insert into tbl_a values(#{id},#{name})")
	public int insertAT(TestDto dto);
	
	public int insertPARAM(@Param("id")int i , @Param("name")String n);
	
	
	public int insertKeyBeforeXML(TestDto dto);
}
