package com.jspiders.hibernate.codestandard.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class StudentDTOcodeStandard {
	@Id
	private int id;
	private String name;
	private String email;
	private long contact;
	private String city;
	
}
