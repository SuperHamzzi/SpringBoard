package kr.bit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.bit.entity.Criteria;
import kr.bit.mapper.BoardMapper;
import kr.bit.mapper.BoardMapperTest;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 루트 context파일을 실행시킴
public class BoardServiceTest {
	
	@Autowired
	BoardService service;
	
	@Test
	public void testGetList() {
		Criteria cri =new Criteria();
		cri.setPage(4);
		cri.setPerPageNum(10);
		service.getList(cri).forEach(vo->log.info(vo));
	}
	
}
