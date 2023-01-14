package kr.bit.entity;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지
	private int perPageNum; // 한페이지에 보여줄 게시글의 수
	public Criteria() {
		this.page=1;
		this.perPageNum=10; //나중에 조정
	}
	// 현재 페이지의 게시글의 시작번호
	public int getPageStart() { 
		return (page-1)*perPageNum; //1page :0~ 2page : 10~ 3page : 20~ -- sql에서는 limit 0,10 을사용해 가져올건데 0~9까지 가져옴
	}
}
