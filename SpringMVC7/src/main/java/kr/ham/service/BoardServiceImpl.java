package kr.ham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ham.entity.Board;
import kr.ham.entity.Member;
import kr.ham.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	
	public List<Board> getList() {
		List<Board> list = boardMapper.getList();
		
		return list;
	}
	@Override
	public Member login(Member vo) {
		Member mvo = boardMapper.login(vo);
		return mvo;
	}
	@Override
	public void register(Board vo) {
		boardMapper.insertSelectKey(vo);
		
	}
	@Override
	public Board get(int idx) {
		Board vo =boardMapper.read(idx);
		return vo;
	}
	
	

}
