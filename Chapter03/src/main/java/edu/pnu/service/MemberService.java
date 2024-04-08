package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberService() {
		System.out.println("MemberService 생성");
	}
	
	public List<MemberVO> getMembers() {
		return memberDao.getMembers();
	}
	
//	public MemberVO getMember(Integer id) {
//		return memberDao.getMember(id);
//	}
	
	public int addMember(MemberVO memberVO) {
		return memberDao.addMember(memberVO);
	}
	
}
