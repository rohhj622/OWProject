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
	    
	    <script type="text/javascript">
			
		</script>
	    
		<style>
			.pagination {
			   justify-content: center;
			}
		</style>
	</head>

	<body>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    	
    	<!-- Pagination -->
		<script>	
			
			
			//이전 버튼 이벤트		
			function fn_prev(page, range, rangeSize) {
				
				var page = ((range - 2) * rangeSize) + 1;
				var range = range - 1;
				var url = "${pageContext.request.contextPath}/board/postList";
			
				url = url + "?page=" + page;			
				url = url + "&range=" + range;
			
				location.href = url;
			}			
			
			//페이지 번호 클릭
			function fn_pagination(page, range, rangeSize, searchType, keyword) {
				  
				var url = "${pageContext.request.contextPath}/board/postList";			
				url = url + "?page=" + page;			
				url = url + "&range=" + range;
				location.href = url;				
			}
			  
			//다음 버튼 이벤트
			function fn_next(page, range, rangeSize) {

				var page = parseInt((range * rangeSize)) + 1;
				var range = parseInt(range) + 1;
				var url = "${pageContext.request.contextPath}/board/postList";
			
				url = url + "?page=" + page;
				url = url + "&range=" + range;
			
				location.href = url;
			}	
		</script>
		<article>
			<div class="container">	
				<div class="table-responsive">	
					<table class="table table-striped table-sm">
						<colgroup>
							<col style="width:5%;" />
							<col style="width:auto;" />
							<col style="width:15%;" />
							<col style="width:10%;" />
							<col style="width:10%;" />
						</colgroup>
						<thead>
							<tr>
								<th>NO</th>
								<th>작성자</th>
								<th>글제목</th>
								<th>시도</th>
								<th>구군</th>
								<th>장소</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<%
								String a = request.getAttribute("listCnt").toString();
								int listCnt = Integer.parseInt(a);
							%>
							
							<c:choose>
								<c:when test="${empty list }" >
									<tr><td colspan="8" align="center">데이터가 없습니다.</td></tr>
								</c:when> 
								<c:when test="${!empty list}">
									<c:forEach var="list" items="${list}">
										<tr>
											<td><%-- <c:out value="${list.post_idx}"/>  --%><%=listCnt %></td>
											<td> <a href="<c:url value='/board/postDetail?idx=${list.post_idx }' />"><c:out value="${list.mem_id}"/></a></td>
											<td><c:out value="${list.post_title}"/></td>
											<td><c:out value="${list.post_sido}"/></td>
											<td><c:out value="${list.post_gugun}"/></td>
											<td><c:out value="${list.post_theme}"/></td>
											<td><c:out value="${list.post_date}"/></td>
											<td><c:out value="${list.post_views}"/></td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
							<%listCnt=listCnt-1; %>
						</tbody>		
					</table>
				</div>
			</div>
			
			<!-- pagination{s} -->
			<div id="paginationBox">
				 <ul class="pagination justify-content-center">
					<c:if test="${pagination.prev}">
						<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
					</c:if>
					<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
						<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
					</c:forEach>
					<c:if test="${pagination.next}">
						<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
					</c:if>
				</ul>
			</div>
			<!-- pagination{e} -->
			
		</article>		
	</body>
</html>


