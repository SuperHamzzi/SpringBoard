package kr.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.com.entity.Board;
import kr.com.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Board> list =boardService.getList();
		model.addAttribute("list", list);
		return "board/list"; 
	}
	
	@GetMapping("/get")
	public @ResponseBody Board get(Long idx) {
		Board vo =boardService.get(idx);
		return vo;
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/register")
	public String register(Board vo) {
		boardService.register(vo);
		return "redirect:/board/list";
	}
	@GetMapping("/remove")
	public String remove(Long idx) {
		boardService.delete(idx);
		return "redirect:/board/list";
	}
	@PostMapping("/modify")
	public String modify(Board vo) {
		
		boardService.update(vo);
		return "redirect:/board/list";
	}
}
