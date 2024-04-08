package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		System.out.println("member : " + member);
		
		System.out.println("=".repeat(40));
		System.out.println(member.getName() + "가(이) 저장한 글 목록");
		System.out.println("=".repeat(40));
//		List<Board> list = member.getBoardList();
//		for (Board b : list) System.out.println(b);
		
	}
	
	@Test
	@Transactional
	public void test01() {
		Board b = boardRepo.findById(1L).get();
		System.out.println(b.getTitle());
		
		System.out.println(b.getMember().getName());
	}
}
