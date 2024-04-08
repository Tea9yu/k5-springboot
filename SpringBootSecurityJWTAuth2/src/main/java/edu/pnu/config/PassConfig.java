package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PassConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
// OAuth2SuccessHandler에 있는 passwordEncoder가 SecurityConfig에 passwordEncoder랑 충돌이 일어나 무한루프가 발생한다.
// 무한루프를 제거하기위해 PassConfig라는 클래스를 만들고 @Bean passwordEncoder 메서드를 옮김.