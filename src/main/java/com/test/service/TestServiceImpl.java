package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.TestDao;
import com.test.dto.TestDto;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestDao dao;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public TestDto GetTestObject(int id) {
		return dao.select(id);
	}

	
}









