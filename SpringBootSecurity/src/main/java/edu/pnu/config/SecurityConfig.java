package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration		// 이 클래스가 설정 클래스라고 저으이(IoC 컨테이너에 로드)
@EnableWebSecurity	// 스프링 시큐리티 적요에 필요한 객체들 자동 생성
public class SecurityConfig {
	
	@Bean				// 이 메서드가 리턴하는 객체를 IoC 컨테이너에 등록하라는 지시
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(security->security
				.requestMatchers(new AntPathRequestMatcher("/member/**")).authenticated()
				.requestMatchers(new AntPathRequestMatcher("/manager/**")).hasRole("MANAGER")
				.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
				.anyRequest().permitAll());
		
		http.csrf(cf->cf.disable());		// CSRF 보호 비활성화 (JavaScript 호출)
		
		http.formLogin(form->form			// SpringBoot가 제공해주는 로그인 사용
					.loginPage("/login")
					.defaultSuccessUrl("/loginSuccess", true)
		);
		
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));		
		
		http.logout(logout->logout
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login"));
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean	// 대부분 위에 방법을 사용하지만 이런 방법도 있다.
//	PasswordEncoder encoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password("{noop}abcd")
//			.roles("MANAGER");
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("{noop}abcd")
//			.roles("ADMIN");
//	}
	
	

}
