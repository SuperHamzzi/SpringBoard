package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.Member;
import kr.bit.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<Board> getList(Criteria cri) {
		//반영할 로직
		List<Board> list = mapper.getList(cri);
		return list;
	}

	@Override
	public Member login(Member vo) {
		Member mvo = mapper.login(vo);
		return mvo;
	}

	@Override
	public void register(Board vo) {
		mapper.insertSelectKey(vo);
		
	}

	@Override
	public Board get(int idx) {
		Board vo = mapper.read(idx);
		return vo;
	}

	@Override
	public void modify(Board vo) {
		mapper.update(vo);
	}

	@Override
	public void remove(int idx) {
		mapper.delete(idx);
		
	}

	@Override
	public void replyProcess(Board vo) {
		// 답글만들기
		// 1. 부모글의 정보를 가져오기
		Board parent= mapper.read(vo.getIdx());
		// 2. 부모글의 boardGroup의 값을 ->답글정보에 저장하기
		vo.setBoardGroup(parent.getBoardGroup());
		// 3. 부모글의 boardSequence의 값을->답글 정보에 저장
		vo.setBoardSequence(parent.getBoardSequence()+1);
		//4. 부모글의 BoardLevel의 값을->답글 정보에 저장
		vo.setBoardLevel(parent.getBoardLevel()+1);
		//5. 같은 boardGroup에 있는 글중에서 부모글의 boardSequence 보다 큰 값들을 모두 1씩 업데이트하기
		mapper.replySeqUpdate(parent);
		//6. 답글을 저장하기
		mapper.replyinsert(vo);
	}

	@Override
	public int totalCount(Criteria cri) {
		
		return mapper.totalCount(cri);
	}

}
