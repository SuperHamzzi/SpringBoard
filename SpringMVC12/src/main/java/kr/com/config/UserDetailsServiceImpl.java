package kr.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.com.entity.CustomUser;
import kr.com.entity.Member;
import kr.com.repository.MemberRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findById(username).get();
		if(member==null) {
			throw new UsernameNotFoundException(username+"없음");
		}
		return new CustomUser(member);
	}

}
