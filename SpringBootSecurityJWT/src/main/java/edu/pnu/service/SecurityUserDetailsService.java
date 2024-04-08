package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 사용자명(username)을 기반으로 데이터베이스에서 Member 정보를 조회한다.
		Member member = memRepo.findById(username)
								.orElseThrow(()->new UsernameNotFoundException("Not Found"));							
		
		// Spring security의 UserDatails를 구현한 User 객체를 생성하여 반환한다.
		// 이 User 객체에는 사용자명, 비밀번호, 권한 정보가 포함됩니다.
		return new User(member.getUsername(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}

}
