<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>     
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

		<style>
			.max-small {
			    width: auto; height: auto;
			    max-width: 500px;
			    max-height: 500px;
			}
		</style>
		
		<script type="text/javascript">
		
			function deleteOK(){
				if(confirm("삭제하시겠습니까?")){
					return true;
				}else{
					return false;
				}
			}
			
		
		</script>
		
	    <title>Hello, world!</title>
	    
			
	</head>

	<body>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    	
		<article>
			<div class="container" role="main">
				<h2>board Content</h2>
				<div class="row">
					<div class="col-sm-1">
						<form action="">
							<input class="btn btn-sm btn-primary" type="submit" value="수정"/>
						</form>
					</div>
					<div class="col-sm-1">
						<button type="button" class="deletePost" onclick="willUdeletePost()">삭제</button>
					</div>
					<div class="col-sm-1">
						<form action="<c:url value='/board/postList'/>">
							<input class="btn btn-sm btn-primary" type="button"  value="목록"/>
						</form>
					</div>
				</div>
				<div class="table-responsive">	
					<table class="table table-striped table-sm" style="text-align:center;">
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
							<tr>
								<td colspan="5">
									<img class="max-small" src="/hj/img/${fl.af_reName }"/>
								</td>
							</tr>
						</c:forEach>
					</table>
					${post.post_idx}
				</div>
			</div>
		</article>
		<script type="text/javascript">
		function willUdeletePost(){
			if(!confirm("삭제하시겠습니까?")){
			}
			
			var post_idx=${post.post_idx};
			
			$.ajax({
				type:"POST",
				url:"/board/deletePost",
				dataType:"json",
				data:{post_idx:post_idx},
				success: function(response,txtStatus,xhr){
					console.log(response);
					if(ParseInt(response)>0){
						alert("삭제되었습니다.");
						location.href="/board/postList"
					}else{
						alert("오류발생")
						return false;
					}							
				}
				
			});
		};
		</script>
	</body>
</html>


