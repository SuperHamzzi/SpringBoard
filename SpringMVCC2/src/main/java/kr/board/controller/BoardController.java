package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController{	// new BoardController();
	
	@Autowired	
	BoardMapper mapper;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	// @ResponseBody ->jackson-databind(객체를->json 데이터로 변환)
	@RequestMapping("/boardList.do")
	public @ResponseBody List<Board> boardList() {
		List<Board> list = mapper.getLists();
		return list; //JSON 데이터 형식으로 변환해서 리턴하겠다.
	}
	@RequestMapping("/boardInsert.do")
	public @ResponseBody void boardInsert(Board vo) {
		mapper.boardInsert(vo); //등록성공
	}
}
