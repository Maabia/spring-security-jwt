package com.example.jwt.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class UserModel {
	
	@Id
	private String id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(name = "creaded_at")
	private LocalDateTime createdAt;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<RoleModel> roles;
	
	public UserModel(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	@PrePersist
	private void prePersist() {
		this.id = UUID.randomUUID().toString();
		this.createdAt = LocalDateTime.now();
	}
}
