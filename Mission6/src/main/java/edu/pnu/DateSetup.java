//package edu.pnu;
//
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import edu.pnu.domain.Member;
//import edu.pnu.persistence.MemberRepository;
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class DateSetup implements ApplicationRunner {
//	
//	private final MemberRepository memberRepo;
//	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		for (int i = 1; i <=5; i++)
//			memberRepo.save(Member.builder()
//							.name("name" + i)
//							.password("pass" + i)
//							.role("User")
//							.build()
//							);
//
//	}
//
//}
