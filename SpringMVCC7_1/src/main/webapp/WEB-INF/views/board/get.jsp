<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<c:set var="cpath" value="${pageContext.request.contextPath}" /> <!-- /sp01 경로를 가져옴 -->

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("button").on("click", function(e){
  			var formData=$("#frm");
  			var btn=$(this).data("btn"); //$(this):현재 가리킨 버튼
  			if(btn=='reply'){
  				formData.attr("action", "${cpath}/board/reply")
  			}else if(btn=='modify'){
  				formData.attr("action", "${cpath}/board/modify")
  			}else if(btn=='list'){
  				formData.find("#idx").remove();
  				formData.attr("action", "${cpath}/board/list")
  			}
  			formData.submit();
  		});
  	});
  </script>
</head>
<body>
 
<div class="container">
  <h2>Spring 열심히하자</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
    	<table class="table table-bordered">
    		<tr>
    		<td>번호</td>
    		<td><input type="text" class="form-control" name="idx" readonly="readonly" value="${vo.idx}" /></td>
    		</tr>
    		<tr>
    		<td>제목</td>
       		<td><input type="text" class="form-control" name="title" readonly="readonly" value="<c:out value='${vo.title}'/>" /></td>
    		</tr>
    		<tr>
    		<td>내용</td>
    		<td><textarea rows="10" class="form-control" name="content" readonly="readonly"><c:out value="${vo.content}" />
    		</textarea></td>
    		</tr>
    		<tr>
    		<td>작성자</td>
    		<td><input type="text" class="form-control" name="writer" readonly="readonly"  value="${vo.writer}"/></td>
    		</tr>
    		<tr>
    			<td colspan="2" style="text-align: center;">
    				<c:if test="${!empty mvo}">
    				<button data-btn="reply" class="btn btn-sm btn-primary">답글</button>
    				<button data-btn="modify" class="btn btn-sm btn-success">수정</button>
    				</c:if>
    				<c:if test="${empty mvo}">
    				<button disabled="disabled" class="btn btn-sm btn-primary">답글</button>
    				<button disabled="disabled" class="btn btn-sm btn-success">수정</button>
    				</c:if>
    				<button data-btn="list" class="btn btn-sm btn-info" onclick="location.href='${cpath}/board/list'">목록</button>
    			</td>
    		</tr>
    	</table>
    	<form id="frm" method="get">
    		<input type="hidden" id="idx" name="idx" value="<c:out value='${vo.idx}'/>"/>
    	</form>
    </div>
    <div class="panel-footer">답변형,페이징처리 공부</div>
  </div>
</div>

</body>
</html>