package kr.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

//UserDetailsService -2번
public class MemberUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 로그인 처리 하기
		Member mvo = memberMapper.memLogin(username);
		//->UserDetails --->User -> extends--->MemberUser
		if(mvo != null) {
			return new MemberUser(mvo);
		}else {
			throw new UsernameNotFoundException(username);
		}
	
	}

}