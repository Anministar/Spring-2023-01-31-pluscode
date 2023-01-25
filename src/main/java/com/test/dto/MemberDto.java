package com.test.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
	private String email;
	private String pwd;
	private String phone;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String grade;
}
