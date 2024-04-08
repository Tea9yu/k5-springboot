package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
//	@GetMapping("/member")
//	public List<Member> getMembers(){
//		return memberService.getMembers();
//	}
//	
//	@GetMapping("/member/{id}")
//	public Member getMember(@PathVariable String id) {
//		return memberService.getMember(id);
//	}
	
	@GetMapping("/member")
	public ResponseEntity<?> getMembers(String id) {	// ResponseEntity는 타입을 통합해서 사용가능
		
		if (id == null)
			return ResponseEntity.ok(memberService.getMembers());
		
		return ResponseEntity.ok(memberService.getMember(id));
	}
	
	@PostMapping("/member")
	public ResponseEntity<?> addMember(Member member) {
		return ResponseEntity.ok(memberService.addMember(member));
	}
	
	@PutMapping("/member")
	public ResponseEntity<?> updateMember(Member member) {
		return ResponseEntity.ok(memberService.updateMember(member));
	}
	
	@DeleteMapping("/member")
	public ResponseEntity<?> removeMember(String id) {
		return ResponseEntity.ok(memberService.removeMember(id));
	}
}
