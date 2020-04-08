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
		<!-- 
		<style>
			body {
			  padding-top: 70px;
			  padding-bottom: 30px;
			}
		</style> -->

	</head>

	<body>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    	
		<script type="text/javascript">
			function check() {
				  if(fr.theme1.value == "") {
				    alert("글을 입력해주세요.");
				    return false;
				  } 
				  else{
					  return true;
				  }
				}
		</script>
		
		<article>	
			<div class="container" role="main">
				<h2>내용 입력</h2>		
				<div class="row">
					<form action="<c:url value='/board/writePost' />"
							name="fr" id="fr" role="form" method="post" onsubmit="return check()" enctype="multipart/form-data">

					    <div class="mb-3">
					    	<textarea name="content1" class="form-control"> </textarea>
					    	<%-- <c:if test="${empty fileList }">
					    		잉 
					    	</c:if>
					    	<c:if test="${not empty fileList }">
					    		예 
					    	</c:if> --%>
					    </div>
					    
						<div class="mb-3">
							<input type="hidden" name="sido" value="${sido }">
							<input type="hidden" name="gugun" value="${gugun }">
							<input type="hidden" name="theme" value="${theme }">
							<input type="hidden" name="title" value="${title }">
							<input type="hidden" name="fileList" value="${fileList2 }">
							${fileList2 }
							<input class="btn btn-info" type="submit" value="글쓰기">					
						</div>
					</form>
				</div>		
				
			</div>
		</article>
	</body>
</html>


