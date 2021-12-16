package com.example.jwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.jwt.model.RoleModel;
import com.example.jwt.model.UserModel;
import com.example.jwt.repository.RoleRepository;
import com.example.jwt.service.UserService;

@SpringBootApplication
public class ApiRestSpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestSpringSecurityJwtApplication.class, args);
	}
	
	// APENAS PARA NÃO TER QUE TODA HORA FICAR CADASTRANDO 
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    CommandLineRunner runner(RoleRepository roleRepository, UserService userService) {
	        return args -> {
	            roleRepository.save(new RoleModel("ROLE_MASTER"));
	            roleRepository.save(new RoleModel("ROLE_ADMIN"));
	            roleRepository.save(new RoleModel("ROLE_USER"));

	            userService.save(new UserModel("Pedro", "pedro@gmail.com", "123456"));
	            userService.save(new UserModel("Fuskinha", "fuskinha@gmail.com", "123456"));
	            userService.save(new UserModel("Ana", "ana@gmail.com", "123456"));

	            userService.addRoleToUser("pedro@gmail.com", "ROLE_ADMIN");
	            userService.addRoleToUser("fuskinha@gmail.com", "ROLE_MASTER");
	            userService.addRoleToUser("ana@gmail.com", "ROLE_USER");
	        };
	    }

}
