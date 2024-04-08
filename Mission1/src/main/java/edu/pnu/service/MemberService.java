package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import edu.pnu.domain.MemberVO;


public class MemberService {
	
	private List<MemberVO> list;
	
	public MemberService() {
		System.out.println("===> MemberController 생성");
		
		list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(MemberVO.builder()
					.id(i)
					.pass("pass" + i)
					.name("name" + i)
					.regidate(new Date())
					.build());
		}
	}
	
	public List<MemberVO> getMembers(){
		return list;
	}
	
	
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
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
	
	
	public int updateMember(MemberVO memberVO) {
		MemberVO m = getMember(memberVO);
		if (m == null) {	// 수정하려는 객체가 없으면..
			return 0;
		}
		if (memberVO.getName() != null) {
			m.setName(memberVO.getName());
		}
		if (memberVO.getPass() != null) {
			m.setPass(memberVO.getPass());
		}
		return 1;
	}
	
	
	public int removeMember(Integer id) {
		MemberVO m = getMember(id);
		if (m != null) {
			list.remove(m);
			return 1;
		} else	return 0;
	}
}


















