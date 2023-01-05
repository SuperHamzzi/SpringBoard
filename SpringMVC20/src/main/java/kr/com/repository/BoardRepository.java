package kr.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.com.entity.Board;

@Repository //생략가능 CRUD Method
public interface BoardRepository extends JpaRepository<Board, Long>{
	
}
