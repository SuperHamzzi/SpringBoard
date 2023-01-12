package kr.bit.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.bit.entity.Board;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 루트 context파일을 실행시킴
public class BoardMapperTest {

		@Autowired
		BoardMapper boardmapper;
		
		@Test
		public void testGetList() {
			List<Board> list = boardmapper.getList();
			for(Board vo: list) {
				log.info(vo);
			}
		}
}
