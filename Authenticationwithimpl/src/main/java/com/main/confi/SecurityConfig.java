package com.main.confi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails user = User.withDefaultPasswordEncoder().username("sara").password("sara123").roles("USER").build();
		UserDetails admin = User.withDefaultPasswordEncoder().username("sss").password("sss@123").roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests((authorize) -> authorize.antMatchers("/api/products/welcome").permitAll()
				.antMatchers("/api/products/fetch-all").hasRole("USER").antMatchers("/api/products/fetch/**")
				.hasRole("ADMIN").antMatchers("/api/products/delete/**").hasRole("ADMIN").anyRequest().authenticated())
				.httpBasic();

		return http.build();
	}
}