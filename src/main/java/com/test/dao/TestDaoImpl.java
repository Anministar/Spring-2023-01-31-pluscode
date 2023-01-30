package com.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.TestDto;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class TestDaoImpl implements TestDao {
	
	@Autowired
	private SqlSession session;
	
	private static String namespace="com.test.mapper.TestMapper.";
	
	//SELECTone
	@Override
	public TestDto select(int id) {
		return session.selectOne(namespace+"selectXML",id);
	}
	
	//Insert
	
	//Update
	
	//Delete
	
	//SelectAll

}




