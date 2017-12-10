package com.springboot.security;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	public class SecurityConfiguration  {

/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Login");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}*/
}
