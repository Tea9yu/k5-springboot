package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;	// H2에 있는 BOARD 데이터를 가져오려고 선언	
	
	public List<Board> getBoardList(){
		return boardRepo.findAll(); 
	}

	public Object getBoard(Board board) {		 
		return boardRepo.findById(board.getSeq()).get();
	}

	public void insertBoard(Board board) {
		boardRepo.save(board);
		
	}

	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
		
	}

	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
		
	}
	
}
