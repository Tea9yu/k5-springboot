package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
import jakarta.annotation.PostConstruct;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	private List<Member> list;
	
	@PostConstruct	// 한 번만 실행하고 싶을 때 사용하는 어노테이션
	public void memberService() {
		System.out.println("MemberController 생성");
		
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Member member = new Member();
			member.setId("태규" + i);
			member.setPassword("태규111");
			member.setName("태규");
			member.setRole("User");
			memberRepo.save(member);
		}
	}

	public List<Member> getMembers() {		
		return memberRepo.findAll();
	}

	public Member getMember(String id) {
		return memberRepo.findById(id).get();
	}
	
	public Member addMember(Member member) {
		return memberRepo.save(member);
	}
	
	public Member updateMember(Member member) {
		Member m = getMember(member.getId());
		if (member.getName() != null) {
			m.setName(member.getName());
		}
		if (member.getPassword() != null) {
			m.setPassword(member.getPassword());
		}
		if (member.getRole() != null) {
			m.setRole(member.getRole());
		}
		
		return memberRepo.save(m);
		
	}
	
	public Integer removeMember(String id) {
			memberRepo.deleteById(id);
		return 1;
	}

}
