package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;
													// T=타입, ID=식별자 타입
public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByTitleContaining(String string);

	Page<Board> findByTitleContaining(String string, Pageable paging);

	List<Board> findByTitleContainingOrContentContaining(String string, String string1);
	
	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	@Query("SELECT b FROM Board b "
			+ "WHERE b.title like %:searchKeyword% "
			+ "ORDER BY b.seq DESC")
				List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
			+ "FROM Board b "
			+ "WHERE b.title like %?1% "
			+ "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);
	
	@Query(value="select seq, title, writer, create_date "
			+ "from board where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest4(String searchKeyword);
	
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest5(Pageable paging);
	
}
