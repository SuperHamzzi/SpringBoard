<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<c:set var="cpath" value="${pageContext.request.contextPath}" /> <!-- /sp01 경로를 가져옴 -->

<!DOCTYPE html>
<html lang="en">
<head>
  <title>재혁게시판</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">
  	$(document).ready(function(){
  		var result='${result}';
  		checkModal(result);
  		
  			$("#regBtn").click(function(){
  				location.href="${cpath}/board/register";
  			});
  			//페이지 번호 클릭시 이동 하기
  			var pageFrm=$("#pageFrm");
  			$(".paginate_button a").on("click", function(e){
  				e.preventDefault(); // a tag의 기능을 막음
  				var page =$(this).attr("href"); //페이지번호
				pageFrm.find("#page").val(page);
  				pageFrm.submit();
  			});
  			//상세 보기 클릭시 이동 하기
  			$(".move").on("click",function(e){
  				e.preventDefault();
  				var idx = $(this).attr("href");
  				var tag ="<input type='hidden' name='idx' value='"+idx+"'/>";
  				pageFrm.append(tag);
  				pageFrm.attr("action","${cpath}/board/get");
  				pageFrm.submit();
  			})
  			
  			
  	});
  	function checkModal(result){
  		if(result==''){
  			return;
  		}
  		if(parseInt(result)>0){
  			$(".modal-body").html("게시글"+parseInt(result)+"번이 등록되었습니다.");
  			$("#myModal").modal("show");
  		}
  	}
  	function goMsg(){
  		alert("삭제된 게시물 입니다");
  	}
  </script>
  
</head>
<body>
 
<div class="container">
  <h2>Spring 열심히하자</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    	<c:if test="${empty mvo}">
		 <form class="form-inline" action="${cpath}/login/loginProcess" method="post">
			  <div class="form-group">
			    <label for="memID">아이디</label>
			    <input type="text" class="form-control" name="memID">
			  </div>
			  <div class="form-group">
			    <label for="pwd">비밀번호</label>
			    <input type="password" class="form-control" name="memPwd">
			  </div>
			  <button type="submit" class="btn btn-default">로그인</button>
		</form>
	   </c:if>
	   <c:if test="${!empty mvo}">
	   	<form class="form-inline" action="${cpath}/login/logoutProcess" method="post">
			  <div class="form-group">
			    <label>${mvo.memName}님 방문 환영합니다.</label>
			  </div>
			  <button type="submit" class="btn btn-default">로그아웃</button>
		</form>
	   </c:if>
    </div>
    <div class="panel-body">
    	<table class="table table-bordered table-hover">
    		<thead>
    			<tr>
    				<th>번호</th>
    				<th>제목</th>
    				<th>작성자</th>
    				<th>작성일</th>
    				<th>조회수</th>
    			</tr>
    		</thead>
    		<c:forEach var="vo" items="${list}">
    			<tr>
    				<td>${vo.idx}</td>
    				<td>
    				<c:if test="${vo.boardLevel>0}">
    					<c:forEach begin="1" end="${vo.boardLevel}">
    						<span style= "padding-left: 10px"></span>
    					</c:forEach>
    				</c:if>
    				<c:if test="${vo.boardLevel>0}">
    					<span>[RE]</span>
    				</c:if>
    				
    				<c:if test="${vo.boardAvailable>0}">
    				<a class="move" href="${vo.idx}">
    				<c:out value="${vo.title}" />
    				</a></td>
    				</c:if>
    				<c:if test="${vo.boardAvailable==0}">
    				<a href="javascript:goMsg()">삭제된 게시물입니다.</a></td>
    				</c:if>
    				<td>${vo.writer}</td> 
    				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.indate}"/></td>
    				<td>${vo.count}</td>
    			</tr>
    		</c:forEach>
    		<c:if test="${!empty mvo}">
    		<tr>
    			<td colspan="5">
    				<button id="regBtn" class="btn btn-sm btn-primary pull-right">글쓰기</button>
    			</td>
    		</tr>
    		</c:if>
    	</table>
    	<!--  페이징 처리 뷰 -->
   <div style= "text-align: center">
    	<ul class="pagination">
    	<!-- 이전처리 -->
    	<c:if test="${pageMaker.prev}">
    		<li class="paginate_button previous">
    			<a href="${pageMaker.startPage-1}">◀</a>
    		</li>
    	</c:if>
    	<!-- 페이지번호 처리 -->
    	  <c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			  <li class="paginate_button ${pageMaker.cri.page==pageNum ? 'active' :'' }">
			  <a href="${pageNum}">${pageNum}</a></li>
		   </c:forEach>
		
    	<!--  다음처리 -->
    	<c:if test="${pageMaker.next}">
    		<li class="paginate_button next">
    			<a href="${pageMaker.endPage+1}">▶</a>
    		</li>
    	</c:if>
    	</ul>
    </div>
    	<!--  END  -->
    	
    	<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">게시글</h4>
		      </div>
		      <div class="modal-body">
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		
		  </div>
		</div>
    	<!-- Modal END -->
    	<form id="pageFrm" action="${cpath}/board/list" method="get">
    		<!--  게시물 번호(idx) 추가 -->
			<input type="hidden" id="page" name="page" value="${pageMaker.cri.page}" />
			<input type="hidden" name="perPageNum" value="${pageMaker.cri.perPageNum}" /> 	
    	</form>
    </div>
    <div class="panel-footer">답변형,페이징처리 공부</div>
  </div> 
</div>

</body>
</html>