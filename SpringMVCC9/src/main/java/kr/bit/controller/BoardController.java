package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.PageMaker;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public String getList(Criteria cri, Model model) {
		List<Board> list = service.getList(cri);
		model.addAttribute("list", list);
		//페이징 처리에 필요한 부분
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount());
		model.addAttribute("pageMaker", pageMaker);
		return "board/list";
	}
	@GetMapping("/register")
	public String register() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(Board vo, RedirectAttributes rttr) {
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getIdx()); //1회성 세션을 사용하는것임
		return "redirect:/board/list";
	}
	@GetMapping("/get")
	public String get(@RequestParam("idx")int idx,Model model,@ModelAttribute("cri") Criteria cri) {
		Board vo = service.get(idx);
		model.addAttribute("vo", vo);
		return "board/get";
	}
	@GetMapping("/modify")
	public String modify(@RequestParam("idx")int idx,Model model,@ModelAttribute("cri") Criteria cri) {
		Board vo = service.get(idx);
		model.addAttribute("vo", vo);
		return "board/modify";
	}
	@PostMapping("/modify")
	public String modify(Board vo,Criteria cri,RedirectAttributes rttr) {
		service.modify(vo); // 수정	
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/list";
	}
	@GetMapping("/remove")
	public String remove(@RequestParam("idx") int idx,Criteria cri,RedirectAttributes rttr) {
		service.remove(idx);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/list";
	}
	@GetMapping("/reply")
	public String reply(int idx,Model model,@ModelAttribute("cri") Criteria cri) {
		Board vo =service.get(idx);
		model.addAttribute("vo", vo);
		return "board/reply";
	}
	@PostMapping("/reply")
	public String reply(Board vo,Criteria cri,RedirectAttributes rttr) {
		//답글에 필요한 처리
		service.replyProcess(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/list";
	}
}
