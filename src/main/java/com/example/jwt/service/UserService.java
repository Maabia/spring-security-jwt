package com.example.jwt.service;

import org.springframework.stereotype.Service;

import com.example.jwt.model.RoleModel;
import com.example.jwt.model.UserModel;
import com.example.jwt.repository.RoleRepository;
import com.example.jwt.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	// EU SÓ TENHO O USER SERVICE (O FOCO NESSE CÓDIGO NÃO É NA API REST E SIM EM SPRING SECURITY E JWT
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public UserModel save(UserModel userModel) {return this.userRepository.save(userModel); }
	
	public void addRoleToUser(String email, String name) {
		UserModel user = this.userRepository.findByEmail(email).orElseThrow();
		RoleModel role = this.roleRepository.findByName(name).orElseThrow();
		
		user.getRoles().add(role);
		
		this.userRepository.save(user);
	}
}
