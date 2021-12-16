package com.example.jwt.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserModel {
	
	@Id
	private String id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(name = "creaded_at")
	private LocalDateTime createdAt;
}
