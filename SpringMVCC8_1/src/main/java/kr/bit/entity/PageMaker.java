package kr.bit.entity;

import lombok.Data;

//페이징 처리를 만드는 클래스(v)
@Data
public class PageMaker {
	private Criteria cri;
	private int totalCount; // 게시글 총개수
	private int startPage; //시작 페이지번호
	private int endPage; //끝페이지번호(조정필요)
	private boolean prev; // 이전버튼(true:만듬 , false:사라짐)
	private boolean next; // 다음버튼(true:만듬 , false:사라짐)
	private int displayPageNum=3; // 하단 페이지 개수
	//총 게시글의 수를 구하는 메서드
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		makePaging();
	}
	private void makePaging() {
		//1. 화면에 보여질 마지막 페이지 번호
		endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		// 2. 시작페이지 번호 구하기
		startPage= endPage-displayPageNum+1;
		if(startPage<=0) startPage=1;
		//3.실제 마지막 페이지 번호 구하기
		int tempEndPage=(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		//4. 화면에 보여질 마지막 페이지 유효성 체크
		if(tempEndPage<endPage) { 
			endPage= tempEndPage;
		}
		//5 . 이전 페이지 버튼 존재여부
		prev=(startPage==1)?false : true;
		//6. 다음 페이지 버튼 존재 여부
		next=(endPage<tempEndPage)? true: false;
		}
		
	}

