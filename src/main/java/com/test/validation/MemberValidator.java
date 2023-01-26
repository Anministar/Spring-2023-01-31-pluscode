package com.test.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.test.dto.MemberDto;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberDto dto = (MemberDto)target;
		String email = dto.getEmail();
		String pwd = dto.getPwd();
		 
		if(email==null||"".equals(email.trim())) {
			errors.rejectValue("email", "required");
		}
		if(pwd==null||"".equals(pwd.trim())) {
			errors.rejectValue("pwd", "required");
		}
		 
	}

	
	
}
