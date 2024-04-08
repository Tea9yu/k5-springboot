package edu.pnu;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberRepositoryTest {		
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	@Order(1)
	public void testInsertMember() {
		for (int i = 1; i <= 3; i++) {
				
			Member member = new Member();
			member.setId("태규" + i);
			member.setPassword("태규111");
			member.setName("태규");
			member.setRole("User");
			memberRepo.save(member);
		}
	}
//	@Test
	@Order(2)
	public void testUpdateMember() {
		Member member = memberRepo.findById("태규2").get();
		
		member.setName("태규3");
		memberRepo.save(member);
	}
//	@Test
	@Order(3)
	public void testDeleteMember() {
		memberRepo.deleteById("태규1");
	}
	
}
