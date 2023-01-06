package kr.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.com.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

}
