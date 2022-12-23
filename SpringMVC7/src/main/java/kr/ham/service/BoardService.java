package kr.ham.service;

import java.util.List;

import kr.ham.entity.Board;
import kr.ham.entity.Member;

public interface BoardService {
	
	public List<Board> getList();
	public Member login(Member vo);
	public void register(Board vo);
	public Board get(int idx);
}
