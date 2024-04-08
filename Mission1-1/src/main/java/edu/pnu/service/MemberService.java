package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {
	private List<MemberVO> list;	// 데이터를 저장할 리스트를 생성
	
	public MemberService() {
		System.out.println("===> MemberController 생성");
		
		list = new ArrayList<>();
		for (int i = 1; i<= 10; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
		}
		
		
	}
	public List<MemberVO> getMembers() {
		return list;
	}
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {	// list를 반복하면서 찾는 값 확인
			if (m.getId() == id) {	// 만약 MemberVO에서 가져오는 아이디 값이 같으면..
				return m;			// MemberVO를 리턴한다.
			}
		}
		return null;		// 찾는 값과 같은 값이 없으면 null을 리턴한다. 
	}
	private MemberVO getMember(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) {
				return m;
			}
		}
		return null;
	}
	
	public int addMember(MemberVO memberVO) {
		if (getMember(memberVO) != null) {
			return 0;
		}
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return 1;
	}
	public int updateMembers(MemberVO memberVO) {
		if (getMember(memberVO) == null) {
			return 0;
		}
		if (memberVO.getName() != null) {
			getMember(memberVO).setName(memberVO.getName());
		}
		if (memberVO.getPass() != null) {
			getMember(memberVO).setPass(memberVO.getPass());
		}
		return 1;
	}
	public int removeMember(Integer id) {
		if (getMember(id) != null) {
			list.remove(getMember(id));
			return 1;
		} else return 0;
	}
}
