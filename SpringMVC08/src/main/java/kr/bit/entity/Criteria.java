package kr.bit.entity;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지 번호를 저장
	private int perPageNum; // 한페이지에 보여줄 게시글의 수
	public Criteria() {
		this.page=1;
		this.perPageNum=10; //나중에 조정
	}
	//현재 페이지의 게시  글의 시작번호
	public int getPageStart() { //1page
		return(page-1)*perPageNum; //mysql 은 0부터 시작하기때문에 0으로 만들어야함 시작페이지는 보여주는것은
									//나중에 1로 바꿈
	}
	
}
