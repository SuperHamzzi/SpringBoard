package kr.com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.com.entity.Member;
import kr.com.entity.Role;
import kr.com.repository.MemberRepository;

@SpringBootTest
class SpringMvc12ApplicationTests {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	void createMember() {
		Member m = new Member();
		m.setUsername("wogur");
		m.setPassword(encoder.encode("wogur"));
		m.setName("김매니저");
		m.setRole(Role.MANAGER);
		m.setEnabled(true);
		memberRepository.save(m);
	}

}
