package com.example.jwt.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(this.bCryptPasswordEncoder);
	}
	
	// É AQUI QUE CONTROLO QUAIS RECURSOS PODEM SER ACESSADOS ATRAVÉS DO TIPO DE PERFIL DO USUÁRIO
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/roles").hasAuthority("ROLE_MASTER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/users").hasAnyAuthority("ROLE_MASTER", "ROLE_ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("ROLE_MASTER", "ROLE_ADMIN", "ROLE_USER");
		http.authorizeRequests().anyRequest().authenticated();
	}
	
	
	
}
