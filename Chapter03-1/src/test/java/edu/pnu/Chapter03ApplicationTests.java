package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith  	// junit5부터는 사용을 안함.
@SpringBootTest
//@TestMethodOrder 		// @test 순서를 정해주는 어노테이션
class Chapter03ApplicationTests {
	
//	@Autowired
//	private MemberService memberService;
	
	@Test
	void contextLoads() {
		System.out.println("Test입니다.");
	}
	
	@Test
	public void mytest01() {
		
//		List<MemberVo> list = memberService.getMember();
		
		System.out.println("MyTest입니다.");
	}
	
}
