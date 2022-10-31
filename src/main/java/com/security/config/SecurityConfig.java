package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.security.model.CustomUserDetails;
import com.security.service.impl.CustomUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public CustomUserDetailsServiceImpl customUserDetailsServiceImpl ;

//	@Override   //  httpBasic authintication
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		       .csrf().disable()
////		       .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
//		       .authorizeRequests()
//		       .antMatchers("/vehicle/**").hasRole("ADMIN")
//		       .antMatchers("/test/info").hasRole("NORMAL")
//		       .anyRequest()
//		       .authenticated()
//		       .and()
//		       .httpBasic();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////	auth.inMemoryAuthentication().withUser("Talib").password("Talib@123").roles("ADMIN");
////	auth.inMemoryAuthentication().withUser("Sobhit").password("123456").roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("Talib").password(this.passwordEncoder().encode("Talib@123")).roles("ADMIN");
//	    auth.inMemoryAuthentication().withUser("Sobhit").password(this.passwordEncoder().encode("123456")).roles("NORMAL");
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

	// form based authintication

	@Override
	protected void configure(HttpSecurity http) throws Exception {
         http
              .authorizeRequests()
              .antMatchers("/vehicle/**").hasRole("ADMIN")
              .antMatchers("/test/**").hasRole("NORMAL")
              .antMatchers("/signin").permitAll()
              .anyRequest()
              .authenticated()
              .and()
              .formLogin()
              .loginPage("/signin")
              .loginProcessingUrl("/dologin")
              .defaultSuccessUrl("/test/message");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.inMemoryAuthentication().withUser("Talib").password(this.passwordEncoder().encode("Talib@123")).roles("ADMIN");
//	    auth.inMemoryAuthentication().withUser("Sobhit").password(this.passwordEncoder().encode("123456")).roles("NORMAL");
        auth.userDetailsService(customUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
