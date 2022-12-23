package kr.ham.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ham.entity.Board;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	
	@Autowired
	BoardMapper boardMapper;
	
	
	/*
	public void testGetList() {
	List<Board> list = boardMapper.getList();
	for(Board vo: list) {
		log.info(vo);
	}
	} */
	@Test
	public void testInsert() {
		Board vo =new Board();
		vo.setMemID("kim2");
		vo.setTitle("C");
		vo.setContent("테스트연습");
		vo.setWriter("김재혁");
		boardMapper.insertSelectKey(vo);
		log.info(vo);
	}
	
}
