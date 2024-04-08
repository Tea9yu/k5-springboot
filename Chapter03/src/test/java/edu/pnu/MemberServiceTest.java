package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberServiceTest {
	
	@Autowired	// new를 사용하지 않고 IocContainer에 자동으로 올라가게 만들어야됨. 1. 필드에 2. 생성자 3. set에 선언할 수 있음
	private MemberService memberService;
	
	

	@Test
	@DisplayName("입력한 데이터를 읽어옵니다.")
	public void test02() {
		List<MemberVO> list = memberService.getMembers();
		for (MemberVO m : list) System.out.println(m);
	}

}













