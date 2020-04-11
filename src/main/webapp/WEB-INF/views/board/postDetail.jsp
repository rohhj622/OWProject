<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  	<head>
	    <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    
	    <!-- Bootstrap CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value='/css/bootstrap-theme.css' />" rel="stylesheet">
	    
	    <!-- Bootstrap JS -->
	    <link href="<c:url value='/js/bootstrap.js' />">

	    <title>Hello, world!</title>
	    
		
	</head>

	<body>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    	
		<article>
			<div class="container" role="main">
				<h2>board Content</h2>
				
				<div class="table-responsive">	
					<table class="table table-striped table-sm">
						<tr>
							<td>
								제목
							</td>
							<td colspan="3">
								<c:out value="${post.post_title}"/>
							</td>
						</tr>
						<tr>
							<td>
								작성자 
							</td>
							<td>
								<c:out value="${post.mem_id}"/>
							</td>
						</tr>
						<tr>
							<td>
								작성일 
							</td>
							<td>
								<c:out value="${post.post_date }"/>
							</td>
						</tr>
						<tr>
							<td>
								TAG
							</td>
							<td colspan="3">
								<c:out value="${post.post_sido}"/>,<c:out value="${post.post_gugun}"/>,<c:out value="${post.post_theme}"/>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<c:out value="${post.post_content }"/>
							</td>
						</tr>
						<c:forEach var="fl" items="${fileList}">
						
						</c:forEach>
					</table>
				</div>
				
				<div class="bg-white rounded shadow-sm">
					<div class="board_title"><c:out value="${post.post_title}"/></div>
					<div class="board_info_box">
						<span class="board_author"><c:out value="${post.mem_id}"/>,</span><span class="board_date"><c:out value="${post.post_date }"/></span>
					</div>
					<div class="board_content">${post.post_content }</div>
					<div class="board_tag">TAG : <c:out value="${post.post_sido}"/></div>
					<div class="board_tag">TAG : <c:out value="${post.post_gugun}"/></div>
					<div class="board_tag">TAG : <c:out value="${post.post_theme}"/></div>
				</div>
	
				<div style="margin-top : 20px">
					<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
					<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
					<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
				</div>
			</div>
		</article>
	
	</body>
</html>


