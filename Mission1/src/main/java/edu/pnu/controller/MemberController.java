package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	MemberService m = new MemberService();
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return m.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return m.getMember(id);
	}
		
	@PostMapping("/member")
	public int addMember(MemberVO memberVO) {
		return m.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
		return m.updateMember(memberVO);
	}
	
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		return m.removeMember(id);
	}
}


















