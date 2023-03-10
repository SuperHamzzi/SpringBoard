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
</head>
<body>
 
<div class="container">
  <h2>Spring 열심히하자</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
    	<form action="${cpath}/board/reply" method="post">
     		<input type="hidden" name="idx" value="${vo.idx}"/>
    		<input type="hidden" name="memID" value="${mvo.memID}"/>
    		<div class="form-group">
    			<label>제목</label>
    			<input type="text" name="title" class="form-control" value= "<c:out value='${vo.title}'/>">
    		</div>
    		<div class="form-group">
    			<label>답변</label>
    			<textarea rows="10" class="form-control" name="content"></textarea>
    		</div>
    		<div class="form-group">
    			<label>작성자</label>
    			<input type="text" readonly="readonly" name="writer" class="form-control"  value="${mvo.memName}"/>
    		</div>
    		<button class="btn btn-default btn-sm" type="submit">답변</button>
    		<button class="btn btn-default btn-sm" type="reset">취소</button>
    		<button class="btn btn-default btn-sm" type="button" onclick="location.href='${cpath}/board/list'">목록</button>
    	</form>
    </div>
    <div class="panel-footer">답변형,페이징처리 공부</div>
  </div>
</div>

</body>
</html>