package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberController {
	
	@Autowired	// 부트에 MemberService를 자동으로 연결해달라는 어노테이션
	private MemberService memberService;
	
	public MemberController() {
//		System.out.println("MemberController 생성");
		log.debug("MemberController 생성");
				
	}
	
	/*
	• http://localhost:8080/member : method=“get”
	• 모든 멤버 정보를 JSON 형태로 브라우저에 출력
	• public List<MemberVO> getMembers()
	• http://localhost:8080/member/{id} : method=“get”
	• 아이디가 {Id} 인 member를 찾아서 브라우저에 출력
	• public MemberVO getMember(@PathVariable Integer id)
	• http://localhost:8080/member : method=“post”
	• 추가하고자 하는 member 정보를 전달, 추가된 객체 수를 출력
	• public int addMember(MemberVO memberVO)
	• http://localhost:8080/member : method=“put”
	• 수정 대상 객체 정보를 전달, 수정된 객체 수를 출력
	• public int updateMembers(MemberVO memberVO)
	• http://localhost:8080/member/{id} : method=“delete”
	• 아이디가 {Id} 인 member를 찾아서 삭제, 브라우저에는 삭제된 객체 수를 출력
	• public int removeMember(@PathVariable Integer id)
	*/
	
	// 모든 멤버 정보를 JSON 형태로 브라우저에 출력
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return memberService.getMember(id);		
	}
}
