package kr.ham.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ham.entity.Board;
import kr.ham.entity.Member;

//@Mapper
public interface BoardMapper {
	public List<Board> getList();
	public void insert(Board vo);
	public void insertSelectKey(Board vo);
	public Member login(Member vo);
	public Board read(int idx);
}
