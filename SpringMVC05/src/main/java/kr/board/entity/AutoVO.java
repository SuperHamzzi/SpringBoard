package kr.board.entity;

import lombok.Data;


@Data
public class AutoVO {
	private int no; // 일련번호
	private String memID; //회원 아이디
	private String auth; //회원권한(3가지할거임,ROLE_USER,ROLE_MANAGER,ROLE_ADMIN)
	
}
