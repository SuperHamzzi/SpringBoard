package kr.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.entity.Member;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/login/*")
public class LoginController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/loginProcess")
	public String login(Member vo, HttpSession session) {
		Member mvo = service.login(vo);
		if(mvo !=null) {
			session.setAttribute("mvo", mvo);
		}
		return "redirect:/board/list";
	}
	@RequestMapping("/logoutProcess")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 끊음 세션무효화(로그아웃처리)
 		return "redirect:/board/list";
	}
}
