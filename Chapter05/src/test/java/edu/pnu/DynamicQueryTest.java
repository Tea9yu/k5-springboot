package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.DynamicBoardRepository;

@SpringBootTest
public class DynamicQueryTest {
	@Autowired
	private DynamicBoardRepository boardRepo;
	
//	@Test
	public void testDynamicQuery() {
		String searchCondition = "TITLE";
		String searchKeyword = "게시글 1";
//		String searchCondition = "CONTENT";
//		String searchKeyword = "내용 1";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));			
		} else if(searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	// localhost:8080/boardSearch?title=테이블10
	// Title이 "%Title1%"인 데이터를 출력(testDynamicQuery01())
//	@Test
	public void testDynamicQuery01() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	// cnt가 50보다 큰 데이터를 출력(testDynamicQuery02())
//	@Test
	public void testDynamicQuery02() {
		List<Board> boardList = boardRepo.findByCntGreaterThan(50L);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	// 위 1번, 2번에서 데이터를 출력할 때 기능을 추가 (testDynamicQuery03(), testDynamicQuery04())
	@Test
	public void testDynamicQuery03() {
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		Page<Board> page = boardRepo.findByTitleContaining("1", paging);
		
		System.out.println("pageNumber: " + page.getNumber());
		
		List<Board> list = page.getContent();		
		for (Board b : list) {
			System.out.println(b);
		}
	}
	
//	@Test
	public void testDynamicQuery04() {
		
	}
	// 2. Controller에서 호출이 가능하도록 수정
	// BoardController - BoardService - BoardRepository
}
