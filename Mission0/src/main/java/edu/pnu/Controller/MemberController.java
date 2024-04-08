package edu.pnu.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

// M = Model V = View C = Controller
// MVC에서 V가 생략되고 MC만 있음
@RestController
public class MemberController {
	
	private List<MemberVO> list;
	
	public MemberController () {
		System.out.println("===> MemberController 생성");
		
		list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
//			MemberVO m = new MemberVO();
//			m.setId(i);
//			m.setPass("pass" + i);
//			m.setName("name" + i);
//			m.setRegidate(new Date());
//			list.add(m);
			list.add(MemberVO.builder()
					.id(i)
					.name("name" + i)
					.pass("pass" + i)
					.regidate(new Date())
					.build());
		}
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return list;
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	private MemberVO getMember(MemberVO memberVO) {
		for ( MemberVO m :list) {
			if (m.getId() == memberVO.getId())
				return m;
		}
		return null;
	}
	
//	@GetMapping("/member")
//	public ResponseEntity<?> getMembers(Long id) {
//		
//		if (id == null)
//			return ResponseEntity.ok(memberService.getMembers());
//		
//		return ResponseEntity.ok(memberService.getMember(id));
//	}
	
	@PostMapping("/member")
	public int addMember(MemberVO memberVO) {
		if (getMember(memberVO) != null)
			return 0;
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return 1;
	}
	
	@PostMapping("/memberJSON")
	public int addMemberJSON(@RequestBody MemberVO memberVO) {
		if (getMember(memberVO) != null)
			return 0;
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return 1;
	}
	
	@PutMapping("/member")
	public int updateMembers(MemberVO memberVO) {
		MemberVO m = getMember(memberVO);
		if (m == null)
			return 0;
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		return 1;
		
	}
	
	@DeleteMapping("/member")
	public int removeMember(@PathVariable Integer id) {
//		MemberVO m = getMember(id);
//		list.remove(m);
//		return 1;
		
		try {
			list.remove(getMember(id));			
		} catch (Exception e) {e.printStackTrace();}
		
		return 1;
		
//		for (MemberVO m : list) {
//			if (m.getId() == id) {
//				return m.remove(id);
//			}
//		}
//		return 0;
	}
	
//	@GetMapping("/getMember2")
//	public MemberVO getMember(Integer id) {
//		for (MemberVO m : list) {
//			if (m.getId() == id) {
//				return m;
//			}
//		}
//		return null;
//	}
//	
//	@GetMapping("/getMemberList")
//	public List<MemberVO> getMemberList() {
//		List<MemberVO> memberList = new ArrayList<MemberVO>();
//		for (int i = 1; i <= 10; i++) {
//			MemberVO member = new MemberVO();
//			member.setId(i);
//			member.setPass("pass" + i);
//			member.setName(i + "name");
//			member.setRegidate(new Date());
//			memberList.add(member);
//		}
//		return memberList;
//	}
//	
//	// localhost:8080/getMember2/10
//	@GetMapping("/getmember3/{id}")
//	public MemberVO getMember2(@PathVariable Integer id) {
//		return getMember(id);
//	}
}

















