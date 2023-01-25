package com.test.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
	private String email;
	private String pwd;
	private String phone;
	private int zipcode;
	private Date birth;	//String->Date
	private String addr1;
	private String addr2;
	private int grade;
}
