package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {	
		
	private static void insertData(EntityManagerFactory emf) {		// 파라미터를 작성하지 않아서 emf가 오류로 뜸
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			em.persist(board);
		
			tx.commit();
			
			System.out.println("등록이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
	}
	
	private static void searchData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		try {
			// 게시글 조회
			Board board = em.find(Board.class, 1L);
			if(board != null) System.out.println("Search: "+ board);
			else			  System.out.println("Not Found");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
		
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();	// em은 한번 쓰고 버리는 것. close()로 만든 곳에서 닫는다.
		
		// 데이터 입력
		insertData(emf);
		
		// 데이터 검색
		searchData(emf);
		
		//데이터 수정
//		modifyData(emf);
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			
			// 글 상세 조회
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println("---> " + searchBoard.toString());
			
//			// Transaction 시작
//			tx.begin();
//			
//			Board board = new Board();
//			board.setTitle("JPA 제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 되네요.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			// 글 등록
//			em.persist(board);
//			
//			// Transaction commit
//			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
//			// Transaction rollback
//			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
